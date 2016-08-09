package orderpicker.receiving;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:26
 */
public interface Receiver<T> {

    void receive(T message) throws ReceiverException;
}
