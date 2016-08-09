package generator.amqp.rabbitmq.order;

import com.rabbitmq.client.Channel;
import generator.amqp.AMQPSender;
import generator.amqp.order.dto.OrderDto;
import generator.amqp.rabbitmq.RabbitMQConnectionHandler;
import generator.connection.ConnectionException;
import generator.sending.SenderException;
import generator.serialization.SerializationException;
import generator.serialization.XMLSerializer;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:46
 */
//TODO: 1 sender per model ivm type (in dit geval maar 1 nodig nl enkel order)
public class RabbitMQOrderSender implements AMQPSender<OrderDto> {
    private RabbitMQConnectionHandler connectionHandler;
    private final Logger logger = Logger.getLogger(RabbitMQOrderSender.class);

    public RabbitMQOrderSender(String host, String queue) {
        this.connectionHandler = new RabbitMQConnectionHandler(host, queue);
    }

    @Override
    public void close() throws ConnectionException {
        this.connectionHandler.close();
    }

    @Override
    public void open() throws ConnectionException {
        this.connectionHandler.open();
    }

    @Override
    public void send(OrderDto message) throws SenderException {
        Channel channel = this.connectionHandler.getChannel();
        String host = this.connectionHandler.getHost();
        String queue = this.connectionHandler.getQueue();

        try {
            // make sure the queue exists
            channel.queueDeclare(queue, false, false, false, null);
        } catch (IOException e) {
            String msg = "Something went wrong trying to declare the queue for channel=%s with RabbitMQ host=%s";
            msg = String.format(msg, host, channel);
            throw new SenderException(msg, e);
        }

        XMLSerializer xmlSerializer = new XMLSerializer();
        String xml = "";
        try {
            xml = xmlSerializer.serialize(message);
        } catch (SerializationException e) {
            logger.error("Error during conversion from object to XML");
        }

        try {
            channel.basicPublish("", queue, null, xml.getBytes());
            logger.info("Message sent");
        } catch (IOException e) {
            String msg = "Something went wrong trying to send a message to the queue for channel=%s " +
                    "with RabbitMQ host=%s";
            msg = String.format(msg, host, channel);
            throw new SenderException(msg, e);
        }
    }
}
