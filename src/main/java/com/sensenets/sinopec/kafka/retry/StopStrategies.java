package com.sensenets.sinopec.kafka.retry;

import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.google.common.base.Preconditions;

/**
 * Factory class for {@link StopStrategy} instances.
 *
 * @author JB
 */
public final class StopStrategies {

    private StopStrategies() {
    }

    /**
     * Returns a stop strategy which never stops retrying. It might be best to
     * try not to abuse services with this kind of behavior when small wait
     * intervals between retry attempts are being used.
     *
     * @return a stop strategy which never stops
     */
    public static <V> StopStrategy<V> neverStop() {
        return new NeverStopStrategy<V>();
    }

    /**
     * Returns a stop strategy which stops after N failed attempts.
     *
     * @param attemptNumber the number of failed attempts before stopping
     * @return a stop strategy which stops after {@code attemptNumber} attempts
     */
    public static <V> StopStrategy<V> stopAfterAttempt(int attemptNumber) {
        return new StopAfterAttemptStrategy<V>(attemptNumber);
    }

    /**
     * Returns a stop strategy which stops after a given delay. If an
     * unsuccessful attempt is made, this {@link StopStrategy} will check if the
     * amount of time that's passed from the first attempt has exceeded the
     * given delay amount. If it has exceeded this delay, then using this
     * strategy causes the retrying to stop.
     *
     * @param delayInMillis the delay, in milliseconds, starting from first attempt
     * @return a stop strategy which stops after {@code delayInMillis} time in milliseconds
     * @deprecated Use {@link #stopAfterDelay(long, TimeUnit)} instead.
     */
    @Deprecated
    public static <V> StopStrategy<V> stopAfterDelay(long delayInMillis) {
        return stopAfterDelay(delayInMillis, TimeUnit.MILLISECONDS);
    }

    /**
     * Returns a stop strategy which stops after a given delay. If an
     * unsuccessful attempt is made, this {@link StopStrategy} will check if the
     * amount of time that's passed from the first attempt has exceeded the
     * given delay amount. If it has exceeded this delay, then using this
     * strategy causes the retrying to stop.
     *
     * @param duration the delay, starting from first attempt
     * @param timeUnit the unit of the duration
     * @return a stop strategy which stops after {@code delayInMillis} time in milliseconds
     */
    public static <V> StopStrategy<V> stopAfterDelay(long duration, @Nonnull TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit, "The time unit may not be null");
        return new StopAfterDelayStrategy<V>(timeUnit.toMillis(duration));
    }

    @Immutable
    private static final class NeverStopStrategy<V> implements StopStrategy<V> {
        @Override
        public boolean shouldStop(Attempt<V> failedAttempt) {
            return false;
        }
    }

    @Immutable
    private static final class StopAfterAttemptStrategy<V> implements StopStrategy<V> {
        private final int maxAttemptNumber;

        public StopAfterAttemptStrategy(int maxAttemptNumber) {
            Preconditions.checkArgument(maxAttemptNumber >= 1, "maxAttemptNumber must be >= 1 but is %d", maxAttemptNumber);
            this.maxAttemptNumber = maxAttemptNumber;
        }

        @Override
        public boolean shouldStop(Attempt<V> failedAttempt) {
            return failedAttempt.getAttemptNumber() >= maxAttemptNumber;
        }
    }

    @Immutable
    private static final class StopAfterDelayStrategy<V> implements StopStrategy<V> {
        private final long maxDelay;

        public StopAfterDelayStrategy(long maxDelay) {
            Preconditions.checkArgument(maxDelay >= 0L, "maxDelay must be >= 0 but is %d", maxDelay);
            this.maxDelay = maxDelay;
        }

        @Override
        public boolean shouldStop(Attempt<V> failedAttempt) {
            return failedAttempt.getDelaySinceFirstAttempt() >= maxDelay;
        }
    }
}