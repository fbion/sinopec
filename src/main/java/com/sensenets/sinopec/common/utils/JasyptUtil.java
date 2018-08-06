package com.sensenets.sinopec.common.utils;

import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

/**
 * 
 * @ClassName: JasyptUtil
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: summer
 * @date: 2017年8月17日 上午11:57:12
 *
 */
public class JasyptUtil {

	private static final String key = MD5Helper.toMD5("sensenets");
	
	public static final String PREFIX = "SECU";

	private static JasyptUtil jasyptUtil;
	
	private static final Object Lock = new Object();
	
	private StandardPBEStringEncryptor encryptor;
	
	private JasyptUtil(){
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
		config.setPassword(key);
		// 应用配置
		encryptor.setConfig(config);
		this.encryptor = encryptor;
	}
	
	public static JasyptUtil getInstance(){
		if(null == jasyptUtil){
			synchronized(Lock){
				if(null == jasyptUtil){
					jasyptUtil = new JasyptUtil();
				}
			}
		}
		return jasyptUtil;
	}
	
	public String Encript(String message) {
		return encryptor.encrypt(message);
	}

	public String Decript(String message) {
		return encryptor.decrypt(message);
	}
	
	private void encrypts(String str){
		String[] strings = str.split(",");
		System.out.println("key:"+key);
		for(String s : strings){
			System.out.println(String.format("%s------>%s", s , Encript(s)));
		}
	}
	
	public static void main(String[] args) {
		JasyptUtil.getInstance().encrypts("root,1234");
		
	}
	
	
}
