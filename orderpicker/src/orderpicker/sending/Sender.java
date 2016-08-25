package orderpicker.sending;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:26
 */

/**
 * General interface to send messages
 */
public interface Sender<T> {
    /**
     * This method defines sending functionality.
     * @param message The message to send
     * @throws SenderException
     */
    void send(T message) throws SenderException;
}
