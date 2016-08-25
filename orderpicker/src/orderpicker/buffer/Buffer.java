package orderpicker.buffer;

import java.util.List;

/**
 * Michelle Beckers
 * Datum: 25-8-2016
 * Time: 02:21
 */
public interface Buffer<T> {
    void buffer(T target);
    void clear();
    List<T> getBufferedItems();
}
