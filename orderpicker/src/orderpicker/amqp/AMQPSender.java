package orderpicker.amqp;

import orderpicker.connection.ConnectionException;
import orderpicker.connection.ConnectionHandler;
import orderpicker.sending.Sender;
import orderpicker.sending.SenderException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:23
 */

/***
 * This class is specifiq for sending AMQP messages
 */
public interface AMQPSender<T> extends Sender<T>, ConnectionHandler {
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
    void open() throws ConnectionException;

    /**
     * This method defines sending functionality of an AMQP message.
     *
     * @param message The message to send.
     * @throws SenderException
     */
    @Override
    void send(T message) throws SenderException;
}
