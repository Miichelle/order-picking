package generator;

import generator.amqp.AMQPSender;
import generator.amqp.rabbitmq.RabbitMQOrderSender;
import generator.connection.ConnectionException;
import generator.consumation.Consumer;
import generator.consumation.OrderSendingConsumer;
import generator.generation.RandomOrderGenerator;
import generator.models.domain.Order;
import generator.models.dto.OrderDto;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Michelle Beckers
 * Datum: 8-8-2016
 * Time: 22:43
 */
public class GeneratorTest {
    private final static Logger logger = Logger.getLogger(GeneratorTest.class);

    public static void main(String[] args) {
        logger.info("Booting communications");

        final AMQPProperties properties = new AMQPProperties("properties/amqp.properties", "rabbitmq");

        final List<Integer> customerIds = Arrays.asList(1000000,1000001,1000003,1000004,1000005,1000006,1000007,1000008,1000010);
        final List<Integer> productIds = Arrays.asList(1000045, 1000074, 1000655, 1000041, 1025601);

        final double minimumDelay = 500.0;
        final double maximumDelay = 1500.0;

        final double minimumPrice = 1.5;
        final double maximumPrice = 10.0;

        final int minimumItemAmount = 1;
        final int maximumItemAmount = 8;

        final int firstOrderId = 1000000;

        final AMQPSender<OrderDto> sender = new RabbitMQOrderSender(properties.getHost(), properties.getQueue());

        try {
            sender.open();
        } catch (ConnectionException e) {
            logger.fatal(e.getMessage());
            System.exit(1);
        }

        final Consumer<Order> consumer = new OrderSendingConsumer(sender);

        final RandomOrderGenerator generator = new RandomOrderGenerator(
                consumer,
                customerIds, productIds,
                minimumDelay, maximumDelay,
                minimumPrice, maximumPrice,
                minimumItemAmount, maximumItemAmount,
                firstOrderId
        );

        Thread thread = new Thread(generator);
        System.out.println("Press any key to exit.");
        thread.start();

        try {
            final Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        } catch (Exception e) {
            // do nothing, you just ended the program manually
        }

        generator.setGenerate(false);
        logger.info("Shutting down");

        try {
            sender.close();
        } catch (ConnectionException e) {
            logger.fatal(e.getMessage());
            System.exit(1);
        }
    }
}
