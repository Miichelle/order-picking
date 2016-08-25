package orderpicker;

import orderpicker.amqp.AMQPSender;
import orderpicker.amqp.rabbitmq.RabbitMQOrderReceiver;
import orderpicker.amqp.rabbitmq.RabbitMQOrderSender;
import orderpicker.connection.ConnectionException;
import orderpicker.consumation.Consumer;
import orderpicker.consumation.OrderSendingConsumer;
import orderpicker.models.domain.Order;
import orderpicker.models.dto.OrderDto;
import orderpicker.optimalization.NoOptimalization;
import orderpicker.orderpicking.OrderPicker;
import orderpicker.receiving.ReceiverException;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Michelle Beckers
 * Datum: 8-8-2016
 * Time: 22:42
 */

/**
 * This class functions as test entry point of the orderpicker
 */
public class OrderpickerTest {
    private final static Logger logger = Logger.getLogger(OrderpickerTest.class);

    public static void main(String[] args) {
        logger.info("Booting communications");

        final long cacheTimer =  2000000000;
        final long locationBufferTimer = 10000;
        final long orderBufferTimer = 5000;

        final AMQPSender<OrderDto> sender = new RabbitMQOrderSender("localhost", "orderpicker.sender.queue");
        final Consumer<Order> consumer = new OrderSendingConsumer(sender);
        final OrderPicker orderPicker = new OrderPicker(consumer,new NoOptimalization(),cacheTimer,locationBufferTimer);
        final RabbitMQOrderReceiver receiver = new RabbitMQOrderReceiver("localhost", "generator.sender.queue", orderPicker);


       try {
            receiver.open();
            sender.open();
        } catch (ConnectionException e) {
           logger.fatal(e.getMessage());
           System.exit(1);
        } catch (ReceiverException e) {
           logger.fatal(e.getMessage());
        }

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press any key to exit.");
            scanner.nextLine();
        } catch (Exception e) {
            // do nothing, you just ended the program manually
        }

        logger.info("Shutting down");
    }
}
