package orderpicker.cache;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 20:30
 */
public interface Cache<T1, T2> {
    void cache(T1 key, T2 value);
    void clear(T1 key);
    T2 get(T1 key);
    boolean isCached(T1 key);
    boolean isScheduled(T1 key);
}
