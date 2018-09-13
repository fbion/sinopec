package com.sensenets.sinopec.kafka.exception;

public class CacheLoadException extends IodException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5696027806741911491L;
	
	private Class<?> loadingCacheClass;

    public CacheLoadException(Class<?> loadingCacheClass, String message) {
        super(message);
        this.loadingCacheClass = loadingCacheClass;
    }

    public CacheLoadException(Class<?> loadingCacheClass, String message, Throwable cause) {
        super(message, cause);
        this.loadingCacheClass = loadingCacheClass;
    }

    public CacheLoadException(Class<?> loadingCacheClass, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.loadingCacheClass = loadingCacheClass;
    }

    public CacheLoadException(Class<?> loadingCacheClass, Throwable cause) {
        super(cause);
        this.loadingCacheClass = loadingCacheClass;
    }
    
    public Class<?> getLoadingCacheClass() {
    	return loadingCacheClass;
    }
}