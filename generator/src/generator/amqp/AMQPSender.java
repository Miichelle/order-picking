package generator.amqp;

import generator.connection.ConnectionException;
import generator.sending.SenderException;
import generator.connection.ConnectionHandler;
import generator.sending.Sender;

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

    @Override
    void send(T message) throws SenderException;
}
