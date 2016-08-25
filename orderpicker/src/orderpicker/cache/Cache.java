package orderpicker.cache;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 20:30
 */

/**
 * This interface defines how a cache will be cached and cleared of its generic <T> objects
 * @param <T1> key
 * @param <T2> value
 */
public interface Cache<T1, T2> {
    /**
     * Defines how to cache a generic object <T>.
     * @param value The generic key <T>.
     * @param value The generic object <T>
     */
    void cache(T1 key, T2 value);

    /**
     * Defines how a generic object <T> is cleared from the cache using its key.
     * @param key Key to clear a corresponding generic object <T> from the cache.
     */
    void clear(T1 key);

    /**
     * Defines how a generic object <T> is retrieved from the cache using its key.
     * @param key Key to get a corresponding generic object <T> from the cache.
     */
    T2 get(T1 key);

    /**
     * Defines how to know whether a key is already used to cache a generic object <T>.
     * @param key Key to check with.
     * @return true if the key is already used and an object is buffered.
     */
    boolean isCached(T1 key);

    /**
     * Defines how to know whether a key is already scheduled <T>.
     * @param key Key to check with.
     * @return true if the key is already scheduled.
     */
    boolean isScheduled(T1 key);
}
