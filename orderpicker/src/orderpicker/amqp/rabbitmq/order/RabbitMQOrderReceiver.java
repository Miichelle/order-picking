package orderpicker.amqp.rabbitmq.order;


import com.rabbitmq.client.Channel;
import orderpicker.amqp.AMQPReceiver;
import orderpicker.amqp.dto.OrderDto;
import orderpicker.amqp.rabbitmq.RabbitMQConnectionHandler;
import orderpicker.connection.ConnectionException;
import orderpicker.receiving.ReceiverException;

import java.io.IOException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:46
 */
public class RabbitMQOrderReceiver implements AMQPReceiver<OrderDto> {
    private RabbitMQConnectionHandler connectionHandler;

    public RabbitMQOrderReceiver(String host, String queue) {
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
    public void receive(OrderDto message) throws ReceiverException {
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

        //TODO add consumer

    }
}
