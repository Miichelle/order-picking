package orderpicker.amqp.rabbitmq;

import com.rabbitmq.client.Channel;
import orderpicker.amqp.AMQPSender;
import orderpicker.connection.ConnectionException;
import orderpicker.models.dto.OrderDto;
import orderpicker.sending.SenderException;
import orderpicker.serialization.JSONSerializer;
import orderpicker.serialization.SerializationException;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:46
 */

/***
 * This class sends order messages
 */
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
            String msg = "While declaring the queue, something has went wrong for channel=%s with RabbitMQ host=%s";
            msg = String.format(msg, host, channel);
            throw new SenderException(msg, e);
        }

        JSONSerializer<OrderDto> orderDtoJSONSerializer = new JSONSerializer(OrderDto.class);
        String json = "";
        try {
            json = orderDtoJSONSerializer.serialize(message);
        } catch (SerializationException e) {
            logger.error("An error has occured during the conversion from an object to XML");
        }

        try {
            channel.basicPublish("", queue, null, json.getBytes());
            logger.info("Message sent");
        } catch (IOException e) {
            String msg = "Something went wrong when trying to send a message to the queue for channel=%s " +
                    "with RabbitMQ host=%s";
            msg = String.format(msg, host, channel);
            throw new SenderException(msg, e);
        }
    }
}
