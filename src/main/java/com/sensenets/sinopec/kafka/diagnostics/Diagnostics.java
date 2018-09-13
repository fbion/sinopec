package com.sensenets.sinopec.kafka.diagnostics;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.AtomicLongMap;
import com.google.common.util.concurrent.MoreExecutors;
import com.sensenets.sinopec.kafka.utils.JreUtil;

public abstract class Diagnostics {
    private static final Logger log = LoggerFactory.getLogger(Diagnostics.class);
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final long INVALID_VALUE = -1;
    private static final long DEFAULT_REPORT_INTERVAL = 60 * 1000L;

    private final String name;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Ordering<String> ordering;

    private final List<String> counterList;
    private Map<String, AtomicLongMap<String>> counterMap;
    private final List<String> timerList;
    private Map<String, Multimap<String, ProcedureTime>> timerMap;

    protected Diagnostics(String name, List<String> counterCategories, List<String> timerCategories) {
    	this(name, counterCategories, timerCategories, DEFAULT_REPORT_INTERVAL);
    }

    protected Diagnostics(String name, List<String> counterCategories, List<String> timerCategories, long reportInterval) {
    	this.name = name;
    	counterList = counterCategories;
    	timerList = timerCategories;
        ordering = Ordering.natural();

        initializeCounters();
        initializeTimers();

        ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(1, MoreExecutors.platformThreadFactory());
        scheduledExecutorService = MoreExecutors.getExitingScheduledExecutorService(threadPoolExecutor);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                report();
            }
        }, reportInterval, reportInterval, TimeUnit.MILLISECONDS);
    }
    
    protected void initializeCounters() {
    	counterMap = new HashMap<>();
    	for (String category : counterList) {
    		AtomicLongMap<String> counter = AtomicLongMap.create();
    		counterMap.put(category, counter);
    	}
    }
    
    protected void initializeTimers() {
    	timerMap = new HashMap<>();
    	for (String category : timerList) {
            HashMultimap<String, ProcedureTime> multiMap = HashMultimap.create();
            Multimap<String, ProcedureTime> timer = Multimaps.synchronizedSetMultimap(multiMap);
    		timerMap.put(category, timer);
    	}
    }

    public long count(String category, String name) {
        if (counterMap.containsKey(category)) {
            return counterMap.get(category).incrementAndGet(name);
        } else {
            return INVALID_VALUE;
        }
    }
    
    public long count(String category, String name, long delta) {
        if (counterMap.containsKey(category)) {
            return counterMap.get(category).addAndGet(name, delta);
        } else {
            return INVALID_VALUE;
        }
    }

    public void time(String category, String name, long period) {
        if (timerMap.containsKey(category)) {
            ProcedureTime time = new ProcedureTime();
            time.setName(name);
            time.setPeriod(period);
            time.setTime(new Date());

            timerMap.get(category).put(name, time);
        }
    }

    private void report() {
        StringBuilder builder =  new StringBuilder();

        builder.append(String.format("# system up time: %s", JreUtil.getUptimeString()));
        builder.append(NEW_LINE);
        
        builder.append(String.format("@@@@@@@@@@ %s @@@@@@@@@@", name));
        builder.append(NEW_LINE);
        
        for (String category : counterList) {
        	if (counterMap.containsKey(category)) {
        		AtomicLongMap<String> counter = counterMap.get(category);
	            Map<String, Long> map = counter.asMap();
	            builder.append(buildString(category, map));
        	}
        }

        for (String category : timerList) {
        	if (timerMap.containsKey(category)) {
        		Multimap<String, ProcedureTime> timer = timerMap.get(category);
	        	Multimap<String, ProcedureTime> times = ImmutableMultimap.copyOf(timer);
	            timer.clear();
	            builder.append(buildString(category, times));
        	}
        }

        log.warn(builder.toString());
    }

    private String buildString(String title, Map<String, Long> map) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("##### %s #####", title));
        builder.append(NEW_LINE);

        for (String key : ordering.immutableSortedCopy(map.keySet())) {
            builder.append(String.format("%s : %d", key, map.get(key).longValue()));
            builder.append(NEW_LINE);
        }

        return builder.toString();
    }
    
    private String buildString(String title, Multimap<String, ProcedureTime> timer) {
    	StringBuilder builder =  new StringBuilder();
    	
        builder.append(String.format("##### %s #####", title));
        builder.append(NEW_LINE);
        
        for (String key : ordering.immutableSortedCopy(timer.keySet())) {
            Collection<ProcedureTime> vals = timer.get(key);
            builder.append(buildString(key, vals));
            builder.append(NEW_LINE);
        }
        
        return builder.toString();
    }

    private String buildString(String name, Collection<ProcedureTime> times) {
        long ave = 0;
        if (times != null && times.size() > 0) {
            long total = 0;
            for (ProcedureTime time : times) {
                total += time.getPeriod();
            }
            ave = (long)(total / times.size());
        }
        return String.format("%s : %d ms (%d)", name, ave, times == null ? 0 : times.size());
    }

    static class ProcedureTime {
        private String name;
        private long time;
        private long period;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTime() {
            return new Date(time);
        }

        public void setTime(Date time) {
            this.time = time.getTime();
        }

        public long getPeriod() {
            return period;
        }

        public void setPeriod(long period) {
            this.period = period;
        }
    }
}