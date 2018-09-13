package com.sensenets.sinopec.kafka.utils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

public class JreUtil {
	private static final Logger log = LoggerFactory.getLogger(JreUtil.class);

	public static String getJavaHome() {
		String javaHome = null;

		javaHome = System.getenv("JAVA_HOME");

		if (Strings.isNullOrEmpty(javaHome)) {
			javaHome = System.getenv("JRE_HOME");
		}

		if (Strings.isNullOrEmpty(javaHome)) {
			javaHome = System.getProperty("java.home");
		}

		return javaHome;
	}

	public static String getJavaExecutable(String javaHome) {
		String javaExe = null;
		try {
			javaExe = Paths.get(javaHome, "bin", isWindows() ? "java.exe" : "java").toString();
		} catch (Exception ex) {
			log.error("error while combine java executable path.", ex);
		}

		return javaExe;
	}

	public static boolean isWindows() {
		String osname = System.getProperty("os.name").toLowerCase();

		return osname.indexOf("win") >= 0;
	}

	public static String getPid() {
		Management management = ManagementImpl.INSTANCE;
		String name = management.getName();
		String pid = "unknown";
		if (!Strings.isNullOrEmpty(name)) {
			pid = name.split("@")[0];
		}
		
		return pid;
	}
	
	public static long getUptime() {
		Management management = ManagementImpl.INSTANCE;
		
		return management.getUptime();
	}
	
	public static String getUptimeString() {
		long millis = getUptime();
		long day = 0;
		long hour = 0;
		long minute = 0;
		long second = 0;
		long millisecond = 0;
		
		second = millis / 1000;
		millisecond = millis % 1000;
		
		minute = second / 60;
		second = second % 60;
		
		hour = minute / 60;
		minute = minute % 60;
		
		day = hour / 24;
		hour = hour % 24;
		
		return String.format("%d days %d hours %d minutes %d seconds %d milliseconds", day, hour, minute, second, millisecond);
	}

	private interface Management {
		String getName();

		long getUptime();
	}

	private static class ManagementImpl implements Management {
		private static final Logger log = LoggerFactory.getLogger(ManagementImpl.class);
		private static final long NOIMPL = -1;
		
		private static ManagementImpl INSTANCE = new ManagementImpl();

		private Optional<Object> mxBean = Optional.absent();
		private Optional<Method> nameMethod = Optional.absent();
		private Optional<Method> uptimeMethod = Optional.absent();

		public ManagementImpl() {
			initialize();
		}

		private void initialize() {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			try {
				Class<?> mgmtFactory = Class.forName("java.lang.management.ManagementFactory", true, cl);
				Class<?> runtimeClass = Class.forName("java.lang.management.RuntimeMXBean", true, cl);
				Class<?> noparams[] = new Class<?>[0];
				Optional<Method> mxBeanMethod = Optional.of(mgmtFactory.getMethod("getRuntimeMXBean", noparams));
				mxBean = Optional.of(mxBeanMethod.get().invoke(mgmtFactory));
				nameMethod = Optional.of(runtimeClass.getMethod("getName", noparams));
				uptimeMethod = Optional.of(runtimeClass.getMethod("getUptime", noparams));
			} catch (NullPointerException | ClassNotFoundException | NoClassDefFoundError | NoSuchMethodException
					| SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				log.error("can not initialize management implementation!", new UnsupportedOperationException("Implementation not available in this environment", e));
			}
		}

		@Override
		public String getName() {
			String name = null;

			try
            {
				name =  String.valueOf(nameMethod.get().invoke(mxBean.get()));
            }
            catch (IllegalStateException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
            {
				log.error("can not get process name!", new UnsupportedOperationException("Implementation not available in this environment", e));
            }
			return name;
		}

		@Override
		public long getUptime() {
			long uptime = NOIMPL;
			
			try
            {
                uptime =  (long)uptimeMethod.get().invoke(mxBean.get());
            }
            catch (IllegalStateException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
            {
				log.error("can not get system up time!", new UnsupportedOperationException("Implementation not available in this environment", e));
            }
			return uptime;
		}

	}
}