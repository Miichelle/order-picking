package generator.sending;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:34
 */
public class SenderException extends Exception {
    public SenderException() {
        super();
    }

    public SenderException(String message) {
        super(message);
    }

    public SenderException(String message, Throwable cause) {
        super(message, cause);
    }
}
