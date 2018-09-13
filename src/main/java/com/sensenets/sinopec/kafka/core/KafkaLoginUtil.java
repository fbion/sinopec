package com.sensenets.sinopec.kafka.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.google.common.base.Strings;

public class KafkaLoginUtil {
	public static final String KAFKA_KBS_ENABLED = "kafka_kbs_enabled";
	public static final String KAFKA_ZOOKEEPER_PRINCIPAL = "kafka_zookeeper_principal";
	public static final String KAFKA_PRINCIPAL = "kafka_principal";
	public static final String KAFKA_JASS_CONF_PATH = "kafka_jass_conf_path";
	public static final String KAFKA_KRB5_CONF_PATH = "kafka_krb5_conf_path";
	public static final String KAFKA_KERBEROS_SERVICE_NAME = "sasl.kerberos.service.name";

	public enum Module {
		STORM("StormClient"), KAFKA("KafkaClient"), ZOOKEEPER("Client");

		private String name;

		private Module(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	/**
	 * line operator string
	 */
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * jaas file postfix
	 */
	private static final String JAAS_POSTFIX = ".jaas.conf";

	/**
	 * is IBM jdk or not
	 */
	private static final boolean IS_IBM_JDK = System.getProperty("java.vendor").contains("IBM");

	/**
	 * IBM jdk login module
	 */
	private static final String IBM_LOGIN_MODULE = "com.ibm.security.auth.module.Krb5LoginModule required";

	/**
	 * oracle jdk login module
	 */
	private static final String SUN_LOGIN_MODULE = "com.sun.security.auth.module.Krb5LoginModule required";

	/**
	 * Zookeeper quorum principal.
	 */
	public static final String ZOOKEEPER_AUTH_PRINCIPAL = "zookeeper.server.principal";

	/**
	 * java security krb5 file path
	 */
	public static final String JAVA_SECURITY_KRB5_CONF = "java.security.krb5.conf";

	/**
	 * java security login file path
	 */
	public static final String JAVA_SECURITY_LOGIN_CONF = "java.security.auth.login.config";

	/**
	 * 设置jaas.conf文件
	 *
	 * @param principal
	 * @param keytabPath
	 * @throws IOException
	 */
	public static void setJaasFile(String principal, String keytabPath) throws IOException {
		// String jaasPath =
		// new File(System.getProperty("java.io.tmpdir")) + File.separator +
		// System.getProperty("user.name")
		// + JAAS_POSTFIX;

		File keytabFile = new File(keytabPath);
		String jaasPath = keytabFile.getParent() + File.separator + System.getProperty("user.name") + JAAS_POSTFIX;
		// windows路径下分隔符替换
		jaasPath = jaasPath.replace("\\", "\\\\");
		// 删除jaas文件

		deleteJaasFile(jaasPath);
		writeJaasFile(jaasPath, principal, keytabPath);
		System.setProperty(JAVA_SECURITY_LOGIN_CONF, jaasPath);
	}

	/**
	 * 设置zookeeper服务端principal
	 *
	 * @param zkServerPrincipal
	 * @throws IOException
	 */
	public static void setZookeeperServerPrincipal(String zkServerPrincipal) throws IOException {
		System.setProperty(ZOOKEEPER_AUTH_PRINCIPAL, zkServerPrincipal);
		String ret = System.getProperty(ZOOKEEPER_AUTH_PRINCIPAL);
		if (ret == null) {
			throw new IOException(ZOOKEEPER_AUTH_PRINCIPAL + " is null.");
		}
		if (!ret.equals(zkServerPrincipal)) {
			throw new IOException(ZOOKEEPER_AUTH_PRINCIPAL + " is " + ret + " is not " + zkServerPrincipal + ".");
		}
	}

	/**
	 * 设置krb5文件
	 *
	 * @param krb5ConfFile
	 * @throws IOException
	 */
	public static void setKrb5Config(String krb5ConfFile) throws IOException {
		System.setProperty(JAVA_SECURITY_KRB5_CONF, krb5ConfFile);
		String ret = System.getProperty(JAVA_SECURITY_KRB5_CONF);
		if (ret == null) {
			throw new IOException(JAVA_SECURITY_KRB5_CONF + " is null.");
		}
		if (!ret.equals(krb5ConfFile)) {
			throw new IOException(JAVA_SECURITY_KRB5_CONF + " is " + ret + " is not " + krb5ConfFile + ".");
		}
	}

	/**
	 * 写入jaas文件
	 *
	 * @throws IOException
	 *             写文件异常
	 */
	private static void writeJaasFile(String jaasPath, String principal, String keytabPath) throws IOException {
		FileWriter writer = new FileWriter(new File(jaasPath));
		try {
			writer.write(getJaasConfContext(principal, keytabPath));
			writer.flush();
		} catch (IOException e) {
			throw new IOException("Failed to create jaas.conf File");
		} finally {
			writer.close();
		}
	}

	private static void deleteJaasFile(String jaasPath) throws IOException {
		File jaasFile = new File(jaasPath);
		if (jaasFile.exists()) {
			if (!jaasFile.delete()) {
				throw new IOException("Failed to delete exists jaas file.");
			}
		}
	}

	private static String getJaasConfContext(String principal, String keytabPath) {
		Module[] allModule = Module.values();
		StringBuilder builder = new StringBuilder();
		for (Module modlue : allModule) {
			builder.append(getModuleContext(principal, keytabPath, modlue));
		}
		return builder.toString();
	}

	private static String getModuleContext(String userPrincipal, String keyTabPath, Module module) {
		StringBuilder builder = new StringBuilder();
		if (IS_IBM_JDK) {
			builder.append(module.getName()).append(" {").append(LINE_SEPARATOR);
			builder.append(IBM_LOGIN_MODULE).append(LINE_SEPARATOR);
			builder.append("credsType=both").append(LINE_SEPARATOR);
			builder.append("principal=\"" + userPrincipal + "\"").append(LINE_SEPARATOR);
			builder.append("useKeytab=\"" + keyTabPath + "\"").append(LINE_SEPARATOR);
			builder.append("debug=true;").append(LINE_SEPARATOR);
			builder.append("};").append(LINE_SEPARATOR);
		} else {
			builder.append(module.getName()).append(" {").append(LINE_SEPARATOR);
			builder.append(SUN_LOGIN_MODULE).append(LINE_SEPARATOR);
			builder.append("useKeyTab=true").append(LINE_SEPARATOR);
			builder.append("keyTab=\"" + keyTabPath + "\"").append(LINE_SEPARATOR);
			builder.append("principal=\"" + userPrincipal + "\"").append(LINE_SEPARATOR);
			builder.append("useTicketCache=false").append(LINE_SEPARATOR);
			builder.append("storeKey=true").append(LINE_SEPARATOR);
			builder.append("debug=true;").append(LINE_SEPARATOR);
			builder.append("};").append(LINE_SEPARATOR);
		}
		return builder.toString();
	}

	public static void check(Properties properties) {
		boolean securityMode = Boolean.parseBoolean(properties.getProperty(KAFKA_KBS_ENABLED, "false"));
		if (!securityMode) {
			return;
		}
		try {
			String krb5ConfPath = properties.getProperty(KAFKA_KRB5_CONF_PATH);
			securityCheck(krb5ConfPath, KAFKA_KRB5_CONF_PATH);

			String zkPrincipal = properties.getProperty(KAFKA_ZOOKEEPER_PRINCIPAL);
			securityCheck(zkPrincipal, KAFKA_ZOOKEEPER_PRINCIPAL);

			String principal = properties.getProperty(KAFKA_PRINCIPAL);
			securityCheck(principal, KAFKA_PRINCIPAL);

			String jassConfPath = properties.getProperty(KAFKA_JASS_CONF_PATH);
			securityCheck(jassConfPath, KAFKA_JASS_CONF_PATH);

			KafkaLoginUtil.setKrb5Config(krb5ConfPath);

			KafkaLoginUtil.setZookeeperServerPrincipal(zkPrincipal);

			KafkaLoginUtil.setJaasFile(principal, jassConfPath);
		} catch (IOException e) {
			throw new RuntimeException("!!!HUAWEI FusionInsight HD Component Kafka Certification exception .", e);
		}
	}

	private static void securityCheck(String value, String key) {
		if (Strings.isNullOrEmpty(value)) {
			throw new RuntimeException(String.format("Please config %s 's value create consumer/producer.", key));
		}
	}
}
