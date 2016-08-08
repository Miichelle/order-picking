package orderpicker.adapters.in;

import orderpicker.exceptions.CommunicationException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import orderpicker.interfaces.MessageBrokerService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 15:37
 */
public class RabbitMQReceiver implements MessageBrokerService {

    private String host;
    private String queue;

    private final Channel channel;
    private final Connection connection;
    private final Logger logger = Logger.getLogger(this.getClass());

    public RabbitMQReceiver(String host, String queue) throws CommunicationException {
        this.host = host;
        this.queue = queue;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(this.host);

        try {
            this.connection = factory.newConnection();
        } catch (IOException | TimeoutException e) {
            String message = "Error trying to setup the connection with RabbitMQ";
            this.logger.error(message);
            throw new CommunicationException(message, e);
        }

        try {
            this.channel = this.connection.createChannel();
        } catch (IOException e) {
            String message = "Error trying to setup the channel with RabbitMQ";
            this.logger.error(message);
            throw new CommunicationException(message, e);
        }
    }

    @Override
    public void close() throws CommunicationException {

    }

    @Override
    public void open() throws CommunicationException {

    }
}
