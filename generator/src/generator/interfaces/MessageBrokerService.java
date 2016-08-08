package generator.interfaces;

import generator.exceptions.CommunicationException;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 16:20
 */
public interface MessageBrokerService {

    void close() throws CommunicationException;

    void open() throws CommunicationException;

}
