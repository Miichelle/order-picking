package orderpicker.consumation;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 21:59
 */

//TODO: observer pattern
public interface Consumer<T> {
    void consume(T target);
}
