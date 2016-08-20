package generator.amqp.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import generator.connection.ConnectionException;
import generator.connection.ConnectionHandler;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:12
 */
public class RabbitMQConnectionHandler implements ConnectionHandler {
    private final String host;
    private final String queue;

    private Channel channel;
    private Connection connection;

    public RabbitMQConnectionHandler(String host, String queue) {
        this.host = host;
        this.queue = queue;
    }

    public final Channel getChannel() { return this.channel; }
    public final Connection getConnection() { return this.connection; }
    public final String getHost() { return this.host; }
    public final String getQueue() { return this.queue; }

    //TODO:specifiek connectie openen en sluiten voor RABBITMQ
    @Override
    public void close() throws ConnectionException {
        try {
            this.channel.close();
        } catch (IOException e) {
            String msg = "Something went wrong while closing the channel with RabbitMQ host=%s";
            msg = String.format(msg, this.host);
            throw new ConnectionException(msg, e);
        } catch (TimeoutException e) {
            String msg = "The connection has timed out while closing the channel with RabbitMQ host=%s";
            msg =  String.format(msg, this.host);
            throw new ConnectionException(msg, e);
        }

        try {
            this.connection.close();
        } catch (IOException e) {
            String msg = "Something went wrong while closing the connection with RabbitMQ host=%s";
            msg = String.format(msg, this.host);
            throw new ConnectionException(msg, e);
        }
    }

    @Override
    public void open() throws ConnectionException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(this.host);

        try {
            this.connection = factory.newConnection();
        } catch (IOException e) {
            String msg = "Something went wrong during the setup of the connection with RabbitMQ host=%s";
            msg = String.format(msg, this.host);
            throw new ConnectionException(msg, e);
        } catch (TimeoutException e) {
            String msg = "The connection timed out during the setup with RabbitMQ host=%s";
            msg =  String.format(msg, this.host);
            throw new ConnectionException(msg, e);
        }

        try {
            this.channel = this.connection.createChannel();
        } catch (IOException e) {
            String msg = "Something went wrong during the setup of the channel with RabbitMQ host=%s";
            msg = String.format(msg, this.host);
            throw new ConnectionException(msg, e);
        }
    }
}
