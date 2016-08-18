package orderpicker.amqp.rabbitmq.order;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import orderpicker.amqp.AMQPReceiver;
import orderpicker.amqp.rabbitmq.RabbitMQConnectionHandler;
import orderpicker.connection.ConnectionException;
import orderpicker.consumation.Consumer;
import orderpicker.models.domain.Order;
import orderpicker.models.dto.OrderDto;
import orderpicker.models.mapping.Mapper;
import orderpicker.receiving.ReceiverException;
import orderpicker.serialization.OrderDtoJSONSerializer;
import orderpicker.serialization.SerializationException;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:46
 */
public class RabbitMQOrderReceiver implements AMQPReceiver<OrderDto> {
    private Consumer<Order> consumer;

    private final static Logger logger = Logger.getLogger(RabbitMQOrderReceiver.class);

    private RabbitMQConnectionHandler connectionHandler;

    public RabbitMQOrderReceiver(String host, String queue, Consumer consumer) {
        this.connectionHandler = new RabbitMQConnectionHandler(host, queue);
        this.consumer = consumer;
    }

    @Override
    public void close() throws ConnectionException {
        this.connectionHandler.close();
    }

    @Override
    public void open() throws ConnectionException, ReceiverException {
         this.connectionHandler.open();
         receive();
    }

    @Override
    public void receive() throws ReceiverException {
        Channel channel = this.connectionHandler.getChannel();
        String host = this.connectionHandler.getHost();
        String queue = this.connectionHandler.getQueue();

        try {
            // make sure the queue exists
            channel.queueDeclare(queue, false, false, false, null);
        } catch (IOException e) {
            String msg = "Something went wrong trying to declare the queue for channel=%s with RabbitMQ host=%s";
            msg = String.format(msg, host, channel);
            throw new ReceiverException(msg, e);
        }

        // will buffer the asynchronously delivered calls until we're ready to use them
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                OrderDtoJSONSerializer orderDtoJSONSerializer = new OrderDtoJSONSerializer();
                OrderDto orderDto = null;
                try {
                    orderDto = orderDtoJSONSerializer.deserialize(new String(body, "UTF-8"));
                } catch (SerializationException e) {
                    e.printStackTrace();
                    //TODO errorafhandeling
                }

                logger.info("Received message");

                Order order = Mapper.map(orderDto);

                RabbitMQOrderReceiver.this.consumer.consume(order);
                // maybe for log: System.out.println(" [x] Received '" + message + "'");
            }
        };

        try {
            channel.basicConsume(queue, true, consumer);
        } catch (IOException e) {
            String msg = "Something went wrong trying to consume a message from the queue for channel=%s " +
                    "with RabbitMQ host=%s";
            msg = String.format(msg, host, channel);
            throw new ReceiverException(msg, e);
        }

    }
}
