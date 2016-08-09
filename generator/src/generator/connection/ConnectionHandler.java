package generator.connection;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 16:20
 */
public interface ConnectionHandler {
    //TODO: algemene handler voor het openen en sluiten van connectie (kan zijn dat deze niet voor elke broker nodig is)
    void close() throws ConnectionException;

    void open() throws ConnectionException;
}
