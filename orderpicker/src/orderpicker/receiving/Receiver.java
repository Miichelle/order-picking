package orderpicker.receiving;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:26
 */


/**
 * General interface to receive messages
 */
public interface Receiver {
    /**
     * This method defines receiving functionality.
     * @throws ReceiverException
     */
    void receive() throws ReceiverException;
}
