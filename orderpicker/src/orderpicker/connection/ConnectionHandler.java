package orderpicker.connection;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 16:20
 */
public interface ConnectionHandler {
    void close() throws ConnectionException;

    void open() throws ConnectionException;
}
