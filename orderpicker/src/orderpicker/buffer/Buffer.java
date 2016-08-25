package orderpicker.buffer;

import java.util.List;

/**
 * Michelle Beckers
 * Datum: 25-8-2016
 * Time: 02:21
 */

/**
 * This interface defines how a buffer will be buffered and cleared of its generic <T> object
 * @param <T> object
 */
public interface Buffer<T> {
    /**
     * Defines how to buffer a generic object <T>.
     * @param target The generic object <T>.
     */
    void buffer(T target);

    /**
     * Defines how a generic object <T> is cleared from the buffer
     */
    void clear();

    /**
     * Gets the buffered items
     * @return List of generic objects <T>
     */
    List<T> getBufferedItems();
}
