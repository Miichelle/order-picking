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
public interface AMQPSender<T> extends Sender<T>, ConnectionHandler {
    @Override
    void close() throws ConnectionException;

    @Override
    void open() throws ConnectionException;

    //TODO: specifiek voor AMQP berichten te versturen
    @Override
    void send(T message) throws SenderException;
}
