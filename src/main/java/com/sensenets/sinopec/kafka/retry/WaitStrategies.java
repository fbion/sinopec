package com.sensenets.sinopec.kafka.retry;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Factory class for instances of {@link WaitStrategy}.
 *
 * @author JB
 */
public final class WaitStrategies {

    private WaitStrategies() {
    }

    /**
     * Returns a wait strategy that doesn't sleep at all before retrying. Use this at your own risk.
     *
     * @return a wait strategy that doesn't wait between retries
     */
    public static <V> WaitStrategy<V> noWait() {
        return new FixedWaitStrategy<V>(0L);
    }

    /**
     * Returns a wait strategy that sleeps a fixed amount of time before retrying.
     *
     * @param sleepTime the time to sleep
     * @param timeUnit  the unit of the time to sleep
     * @return a wait strategy that sleeps a fixed amount of time
     * @throws IllegalStateException if the sleep time is &lt; 0
     */
    public static <V> WaitStrategy<V> fixedWait(long sleepTime, @Nonnull TimeUnit timeUnit) throws IllegalStateException {
        Preconditions.checkNotNull(timeUnit, "The time unit may not be null");
        return new FixedWaitStrategy<V>(timeUnit.toMillis(sleepTime));
    }

    /**
     * Returns a strategy that sleeps a random amount of time before retrying.
     *
     * @param maximumTime the maximum time to sleep
     * @param timeUnit    the unit of the maximum time
     * @return a wait strategy with a random wait time
     * @throws IllegalStateException if the maximum sleep time is &lt;= 0.
     */
    public static <V> WaitStrategy<V> randomWait(long maximumTime, @Nonnull TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit, "The time unit may not be null");
        return new RandomWaitStrategy<V>(0L, timeUnit.toMillis(maximumTime));
    }

    /**
     * Returns a strategy that sleeps a random amount of time before retrying.
     *
     * @param minimumTime     the minimum time to sleep
     * @param minimumTimeUnit the unit of the minimum time
     * @param maximumTime     the maximum time to sleep
     * @param maximumTimeUnit the unit of the maximum time
     * @return a wait strategy with a random wait time
     * @throws IllegalStateException if the minimum sleep time is &lt; 0, or if the
     *                               maximum sleep time is less than (or equals to) the minimum.
     */
    public static <V> WaitStrategy<V> randomWait(long minimumTime,
                                          @Nonnull TimeUnit minimumTimeUnit,
                                          long maximumTime,
                                          @Nonnull TimeUnit maximumTimeUnit) {
        Preconditions.checkNotNull(minimumTimeUnit, "The minimum time unit may not be null");
        Preconditions.checkNotNull(maximumTimeUnit, "The maximum time unit may not be null");
        return new RandomWaitStrategy<V>(minimumTimeUnit.toMillis(minimumTime),
                maximumTimeUnit.toMillis(maximumTime));
    }

    /**
     * Returns a strategy that sleeps a fixed amount of time after the first
     * failed attempt and in incrementing amounts of time after each additional
     * failed attempt.
     *
     * @param initialSleepTime     the time to sleep before retrying the first time
     * @param initialSleepTimeUnit the unit of the initial sleep time
     * @param increment            the increment added to the previous sleep time after each failed attempt
     * @param incrementTimeUnit    the unit of the increment
     * @return a wait strategy that incrementally sleeps an additional fixed time after each failed attempt
     */
    public static <V> WaitStrategy<V> incrementingWait(long initialSleepTime,
                                                @Nonnull TimeUnit initialSleepTimeUnit,
                                                long increment,
                                                @Nonnull TimeUnit incrementTimeUnit) {
        Preconditions.checkNotNull(initialSleepTimeUnit, "The initial sleep time unit may not be null");
        Preconditions.checkNotNull(incrementTimeUnit, "The increment time unit may not be null");
        return new IncrementingWaitStrategy<V>(initialSleepTimeUnit.toMillis(initialSleepTime),
                incrementTimeUnit.toMillis(increment));
    }

    /**
     * Returns a strategy which sleeps for an exponential amount of time after the first failed attempt,
     * and in exponentially incrementing amounts after each failed attempt up to Long.MAX_VALUE.
     *
     * @return a wait strategy that increments with each failed attempt using exponential backoff
     */
    public static <V> WaitStrategy<V> exponentialWait() {
        return new ExponentialWaitStrategy<V>(1, Long.MAX_VALUE);
    }

    /**
     * Returns a strategy which sleeps for an exponential amount of time after the first failed attempt,
     * and in exponentially incrementing amounts after each failed attempt up to the maximumTime.
     *
     * @param maximumTime     the maximum time to sleep
     * @param maximumTimeUnit the unit of the maximum time
     * @return a wait strategy that increments with each failed attempt using exponential backoff
     */
    public static <V> WaitStrategy<V> exponentialWait(long maximumTime,
                                               @Nonnull TimeUnit maximumTimeUnit) {
        Preconditions.checkNotNull(maximumTimeUnit, "The maximum time unit may not be null");
        return new ExponentialWaitStrategy<V>(1, maximumTimeUnit.toMillis(maximumTime));
    }

    /**
     * Returns a strategy which sleeps for an exponential amount of time after the first failed attempt,
     * and in exponentially incrementing amounts after each failed attempt up to the maximumTime.
     * The wait time between the retries can be controlled by the multiplier.
     * nextWaitTime = exponentialIncrement * {@code multiplier}.
     *
     * @param multiplier      multiply the wait time calculated by this
     * @param maximumTime     the maximum time to sleep
     * @param maximumTimeUnit the unit of the maximum time
     * @return a wait strategy that increments with each failed attempt using exponential backoff
     */
    public static <V> WaitStrategy<V> exponentialWait(long multiplier,
                                               long maximumTime,
                                               @Nonnull TimeUnit maximumTimeUnit) {
        Preconditions.checkNotNull(maximumTimeUnit, "The maximum time unit may not be null");
        return new ExponentialWaitStrategy<V>(multiplier, maximumTimeUnit.toMillis(maximumTime));
    }

    /**
     * Returns a strategy which sleeps for an increasing amount of time after the first failed attempt,
     * and in Fibonacci increments after each failed attempt up to {@link Long#MAX_VALUE}.
     *
     * @return a wait strategy that increments with each failed attempt using a Fibonacci sequence
     */
    public static <V> WaitStrategy<V> fibonacciWait() {
        return new FibonacciWaitStrategy<V>(1, Long.MAX_VALUE);
    }

    /**
     * Returns a strategy which sleeps for an increasing amount of time after the first failed attempt,
     * and in Fibonacci increments after each failed attempt up to the {@code maximumTime}.
     *
     * @param maximumTime     the maximum time to sleep
     * @param maximumTimeUnit the unit of the maximum time
     * @return a wait strategy that increments with each failed attempt using a Fibonacci sequence
     */
    public static <V> WaitStrategy<V> fibonacciWait(long maximumTime,
                                             @Nonnull TimeUnit maximumTimeUnit) {
        Preconditions.checkNotNull(maximumTimeUnit, "The maximum time unit may not be null");
        return new FibonacciWaitStrategy<V>(1, maximumTimeUnit.toMillis(maximumTime));
    }

    /**
     * Returns a strategy which sleeps for an increasing amount of time after the first failed attempt,
     * and in Fibonacci increments after each failed attempt up to the {@code maximumTime}.
     * The wait time between the retries can be controlled by the multiplier.
     * nextWaitTime = fibonacciIncrement * {@code multiplier}.
     *
     * @param multiplier      multiply the wait time calculated by this
     * @param maximumTime     the maximum time to sleep
     * @param maximumTimeUnit the unit of the maximum time
     * @return a wait strategy that increments with each failed attempt using a Fibonacci sequence
     */
    public static <V> WaitStrategy<V> fibonacciWait(long multiplier,
                                             long maximumTime,
                                             @Nonnull TimeUnit maximumTimeUnit) {
        Preconditions.checkNotNull(maximumTimeUnit, "The maximum time unit may not be null");
        return new FibonacciWaitStrategy<V>(multiplier, maximumTimeUnit.toMillis(maximumTime));
    }

    /**
     * Returns a strategy which sleeps for an amount of time based on the Exception that occurred. The
     * {@code function} determines how the sleep time should be calculated for the given
     * {@code exceptionClass}. If the exception does not match, a wait time of 0 is returned.
     *
     * @param function       function to calculate sleep time
     * @param exceptionClass class to calculate sleep time from
     * @return a wait strategy calculated from the failed attempt
     */
    public static <T extends Throwable> WaitStrategy<T> exceptionWait(@Nonnull Class<T> exceptionClass,
                                                                   @Nonnull Function<T, Long> function) {
        Preconditions.checkNotNull(exceptionClass, "exceptionClass may not be null");
        Preconditions.checkNotNull(function, "function may not be null");
        return new ExceptionWaitStrategy<T>(exceptionClass, function);
    }

    /**
     * Joins one or more wait strategies to derive a composite wait strategy.
     * The new joined strategy will have a wait time which is total of all wait times computed one after another in order.
     *
     * @param waitStrategies Wait strategies that need to be applied one after another for computing the sleep time.
     * @return A composite wait strategy
     */
    public static <V> WaitStrategy<V> join(@SuppressWarnings("unchecked") WaitStrategy<V>... waitStrategies) {
        Preconditions.checkState(waitStrategies.length > 0, "Must have at least one wait strategy");
        List<WaitStrategy<V>> waitStrategyList = Lists.newArrayList(waitStrategies);
        Preconditions.checkState(!waitStrategyList.contains(null), "Cannot have a null wait strategy");
        return new CompositeWaitStrategy<V>(waitStrategyList);
    }

    @Immutable
    private static final class FixedWaitStrategy<V> implements WaitStrategy<V> {
        private final long sleepTime;

        public FixedWaitStrategy(long sleepTime) {
            Preconditions.checkArgument(sleepTime >= 0L, "sleepTime must be >= 0 but is %d", sleepTime);
            this.sleepTime = sleepTime;
        }

        @Override
        public long computeSleepTime(Attempt<V> failedAttempt) {
            return sleepTime;
        }
    }

    @Immutable
    private static final class RandomWaitStrategy<V> implements WaitStrategy<V> {
        private static final Random RANDOM = new Random();
        private final long minimum;
        private final long maximum;

        public RandomWaitStrategy(long minimum, long maximum) {
            Preconditions.checkArgument(minimum >= 0, "minimum must be >= 0 but is %d", minimum);
            Preconditions.checkArgument(maximum > minimum, "maximum must be > minimum but maximum is %d and minimum is", maximum, minimum);

            this.minimum = minimum;
            this.maximum = maximum;
        }

        @Override
        public long computeSleepTime(Attempt<V> failedAttempt) {
            long t = Math.abs(RANDOM.nextLong()) % (maximum - minimum);
            return t + minimum;
        }
    }

    @Immutable
    private static final class IncrementingWaitStrategy<V> implements WaitStrategy<V> {
        private final long initialSleepTime;
        private final long increment;

        public IncrementingWaitStrategy(long initialSleepTime,
                                        long increment) {
            Preconditions.checkArgument(initialSleepTime >= 0L, "initialSleepTime must be >= 0 but is %d", initialSleepTime);
            this.initialSleepTime = initialSleepTime;
            this.increment = increment;
        }

        @Override
        public long computeSleepTime(Attempt<V> failedAttempt) {
            long result = initialSleepTime + (increment * (failedAttempt.getAttemptNumber() - 1));
            return result >= 0L ? result : 0L;
        }
    }

    @Immutable
    private static final class ExponentialWaitStrategy<V> implements WaitStrategy<V> {
        private final long multiplier;
        private final long maximumWait;

        public ExponentialWaitStrategy(long multiplier,
                                       long maximumWait) {
            Preconditions.checkArgument(multiplier > 0L, "multiplier must be > 0 but is %d", multiplier);
            Preconditions.checkArgument(maximumWait >= 0L, "maximumWait must be >= 0 but is %d", maximumWait);
            Preconditions.checkArgument(multiplier < maximumWait, "multiplier must be < maximumWait but is %d", multiplier);
            this.multiplier = multiplier;
            this.maximumWait = maximumWait;
        }

        @Override
        public long computeSleepTime(Attempt<V> failedAttempt) {
            double exp = Math.pow(2, failedAttempt.getAttemptNumber());
            long result = Math.round(multiplier * exp);
            if (result > maximumWait) {
                result = maximumWait;
            }
            return result >= 0L ? result : 0L;
        }
    }

    @Immutable
    private static final class FibonacciWaitStrategy<V> implements WaitStrategy<V> {
        private final long multiplier;
        private final long maximumWait;

        public FibonacciWaitStrategy(long multiplier, long maximumWait) {
            Preconditions.checkArgument(multiplier > 0L, "multiplier must be > 0 but is %d", multiplier);
            Preconditions.checkArgument(maximumWait >= 0L, "maximumWait must be >= 0 but is %d", maximumWait);
            Preconditions.checkArgument(multiplier < maximumWait, "multiplier must be < maximumWait but is %d", multiplier);
            this.multiplier = multiplier;
            this.maximumWait = maximumWait;
        }

        @Override
        public long computeSleepTime(Attempt<V> failedAttempt) {
            long fib = fib(failedAttempt.getAttemptNumber());
            long result = multiplier * fib;

            if (result > maximumWait || result < 0L) {
                result = maximumWait;
            }

            return result >= 0L ? result : 0L;
        }

        private long fib(long n) {
            if (n == 0L) return 0L;
            if (n == 1L) return 1L;

            long prevPrev = 0L;
            long prev = 1L;
            long result = 0L;

            for (long i = 2L; i <= n; i++) {
                result = prev + prevPrev;
                prevPrev = prev;
                prev = result;
            }

            return result;
        }
    }

    @Immutable
    private static final class CompositeWaitStrategy<V> implements WaitStrategy<V> {
        private final List<WaitStrategy<V>> waitStrategies;

        public CompositeWaitStrategy(List<WaitStrategy<V>> waitStrategies) {
            Preconditions.checkState(!waitStrategies.isEmpty(), "Need at least one wait strategy");
            this.waitStrategies = waitStrategies;
        }

        @Override
        public long computeSleepTime(Attempt<V> failedAttempt) {
            long waitTime = 0L;
            for (WaitStrategy<V> waitStrategy : waitStrategies) {
                waitTime += waitStrategy.computeSleepTime(failedAttempt);
            }
            return waitTime;
        }
    }

    @Immutable
    private static final class ExceptionWaitStrategy<T extends Throwable> implements WaitStrategy<T> {
        private final Class<T> exceptionClass;
        private final Function<T, Long> function;

        public ExceptionWaitStrategy(@Nonnull Class<T> exceptionClass, @Nonnull Function<T, Long> function) {
            this.exceptionClass = exceptionClass;
            this.function = function;
        }

        @SuppressWarnings("unchecked")
		@Override
        public long computeSleepTime(Attempt<T> lastAttempt) {
            if (lastAttempt.hasException()) {
                Throwable cause = lastAttempt.getExceptionCause();
                if (exceptionClass.isAssignableFrom(cause.getClass())) {
                    return function.apply((T) cause);
                }
            }
            return 0L;
        }
    }
}