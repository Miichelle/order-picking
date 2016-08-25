package generator.consumation;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 21:59
 */

/**
 * This interface defines how messages can be consumed
 */
public interface Consumer<T> {

    /**
     * This method defines consuming functionality.
     *
     * @param target The target to consume
     */
    void consume(T target);
}
