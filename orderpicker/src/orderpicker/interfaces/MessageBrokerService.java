package orderpicker.interfaces;

import orderpicker.exceptions.CommunicationException;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 16:20
 */
public interface MessageBrokerService {

    /**
     * This method defines close functionality of an messagebroker connection.
     *
     * @throws CommunicationException
     */
    void close() throws CommunicationException;

    /**
     * This method defines open functionality of an messagebroker connection.
     *
     * @throws CommunicationException
     */
    void open() throws CommunicationException;

}
