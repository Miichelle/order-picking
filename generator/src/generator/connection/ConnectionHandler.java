package generator.connection;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 16:20
 */

/**
 *general handler to handle connections for a messagebroker
 */
public interface ConnectionHandler {
    /**
     * This method defines functionality to close a connection.
     *
     * @throws ConnectionException
     */
    void close() throws ConnectionException;

    /**
     * This method defines functionality to open a connection.
     *
     * @throws ConnectionException
     */
    void open() throws ConnectionException;
}
