package generator.sending;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:26
 */
public interface Sender<T> {

    void send(T message) throws SenderException;
}