package orderpicker.amqp;

import orderpicker.connection.ConnectionException;
import orderpicker.connection.ConnectionHandler;
import orderpicker.receiving.Receiver;
import orderpicker.receiving.ReceiverException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:23
 */

/***
 * This class is specifiq for receiving AMQP messages
 */
public interface AMQPReceiver<T> extends Receiver, ConnectionHandler {

    /**
     * This method defines functionality to close a connection (specifiq for AMQP).
     * @throws ConnectionException
     */
    @Override
    void close() throws ConnectionException;

    /**
     * This method defines functionality to open a connection (specifiq for AMQP).
     * @throws ConnectionException
     */
    @Override
    void open() throws ConnectionException, ReceiverException;

    /**
     * This method defines receiving functionality of an AMQP message.
     * @throws ReceiverException
     */
    @Override
    void receive() throws ReceiverException;
}
