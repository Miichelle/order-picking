package generator.amqp.rabbitmq.order;

import generator.amqp.AMQPSender;
import generator.amqp.order.dto.OrderDto;
import generator.amqp.rabbitmq.RabbitMQConnectionHandler;
import generator.connection.ConnectionException;
import generator.sending.SenderException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:46
 */
public class RabbitMQOrderSender implements AMQPSender<OrderDto> {
    private RabbitMQConnectionHandler connectionHandler;

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
        // TODO fill in
    }
}
