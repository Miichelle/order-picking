package orderpicker.receiving;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:34
 */

/**
 *Exception class for any exception concerning
 */
public class ReceiverException extends Exception {
    public ReceiverException() {
        super();
    }

    public ReceiverException(String message) {
        super(message);
    }

    public ReceiverException(String message, Throwable cause) {
        super(message, cause);
    }
}
