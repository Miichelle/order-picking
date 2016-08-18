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
public interface AMQPReceiver<T> extends Receiver<T>, ConnectionHandler {

    @Override
    void close() throws ConnectionException;

    @Override
    void open() throws ConnectionException, ReceiverException;

    @Override
    void receive() throws ReceiverException;
}
