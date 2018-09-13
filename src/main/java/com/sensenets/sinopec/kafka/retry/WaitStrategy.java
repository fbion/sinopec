package com.sensenets.sinopec.kafka.retry;

/**
 * A strategy used to decide how long to sleep before retrying after a failed attempt.
 *
 * @author JB
 */
public interface WaitStrategy<V> {

    /**
     * Returns the time, in milliseconds, to sleep before retrying.
     *
     * @param failedAttempt the previous failed {@code Attempt}
     * @return the sleep time before next attempt
     */
    long computeSleepTime(Attempt<V> failedAttempt);
}