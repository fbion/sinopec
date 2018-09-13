package com.sensenets.sinopec.kafka.common;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.sensenets.sinopec.kafka.cache.GlobalCache;
import com.sensenets.sinopec.kafka.core.KafkaClientException;
import com.sensenets.sinopec.kafka.core.KafkaProducerClient;
import com.sensenets.sinopec.kafka.procedure.AbstractProcedure;
import com.sensenets.sinopec.kafka.retry.RetryException;
import com.sensenets.sinopec.kafka.retry.Retryer;
import com.sensenets.sinopec.kafka.retry.RetryerBuilder;
import com.sensenets.sinopec.kafka.retry.StopStrategies;
import com.sensenets.sinopec.kafka.retry.WaitStrategies;

public abstract class KafkaProcedure<T> extends AbstractProcedure<T> {
    
    private static final Logger log = LoggerFactory.getLogger(KafkaProcedure.class);
	
    public KafkaProcedure(ListeningExecutorService executorService) {
		super(executorService);
	}
	
	@Override
	protected T doProcess(T message) throws Exception {
		String topic = getTopic(message);
		byte[] key = getKey(message);
		byte[] byMessage = getMessage(message);

		trySend(topic, key, byMessage);
		return message;
	}
	
	protected abstract String getTopic(T message) throws Exception;
	protected abstract byte[] getKey(T message) throws Exception;
	protected abstract byte[] getMessage(T message) throws Exception;
	

	protected void trySend(final String topic, final byte[] key, final byte[] message) throws ExecutionException, RetryException {
		Callable<Void> callable = new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				doSend(topic, key, message);
				return null;
			}};
		
		Retryer<Void> retryer = RetryerBuilder.<Void>newBuilder()
				.retryIfExceptionOfType(KafkaClientException.class)
				.withWaitStrategy(WaitStrategies.<Void>fixedWait(5, TimeUnit.MILLISECONDS))
				.withStopStrategy(StopStrategies.<Void>stopAfterAttempt(10))
				.build();
		retryer.call(callable);
	}
	
	protected void doSend(String topic, byte[] key, byte[] message) throws Exception {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(topic));
		Preconditions.checkNotNull(message, "message data is NULL!");
		Preconditions.checkArgument(message.length > 0, "message data is EMPTY!");
		
        KafkaProducerHolder producerHolder = GlobalCache.getCache(KafkaProducerHolder.class);
        KafkaProducerClient producer = producerHolder.getProducer();
        
        Preconditions.checkNotNull(producer, "kafka producer is NULL!");
        producer.send(topic, key, message);
	}
}
