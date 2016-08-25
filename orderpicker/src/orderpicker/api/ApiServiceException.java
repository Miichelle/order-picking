package orderpicker.api;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 18:16
 */

/**
 *  Exception class for any exception concerning
 */
public class ApiServiceException extends Exception {
    public ApiServiceException(String message) {
        super(message);
    }

    public ApiServiceException(Throwable cause) {
        super(cause);
    }

    public ApiServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
