package orderpicker.connection;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 15:38
 */

/**
 *Exception class for any exception concerning
 */
public class ConnectionException extends Exception {
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
