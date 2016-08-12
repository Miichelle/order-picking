package generator.consumation;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 21:59
 */
public interface Consumer<T> {
    void consume(T target);
}
