package generator.generation;

import generator.consumation.Consumer;
import generator.models.domain.Item;
import generator.models.domain.Order;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 21:04
 */
public class RandomOrderGenerator implements Runnable {
    private final Logger logger = Logger.getLogger(RandomOrderGenerator.class);

    private Consumer<Order> consumer;

    private List<Integer> customerIds;

    private final int minimumDelay;
    private final int maximumDelay;

    private final int minimumItemsSize;
    private final int maximumItemsSize;

    private final int minimumPrice;
    private final int maximumPrice;

    private final int minimumItemAmount;
    private final int maximumItemAmount;

    private int nextOrderId;

    private List<Integer> productIds;

    private Random random;

    private volatile boolean generate;

    public RandomOrderGenerator(
            Consumer<Order> consumer,
            List<Integer> customerIds, List<Integer> productIds,
            int minimumDelay, int maximumDelay,
            int minimumItemsSize, int maximumItemsSize,
            int minimumPrice, int maximumPrice,
            int minimumItemAmount, int maximumItemAmount,
            int firstOrderId) {
        this.consumer = consumer;

        this.customerIds = customerIds;

        this.minimumDelay = minimumDelay;
        this.maximumDelay = maximumDelay;

        this.minimumItemsSize = minimumItemsSize;
        this.maximumItemsSize = maximumItemsSize;

        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;

        this.minimumItemAmount = minimumItemAmount;
        this.maximumItemAmount = maximumItemAmount;

        this.nextOrderId = firstOrderId;

        this.productIds = productIds;

        random = new Random();

        this.generate = true;

    }

    public void setGenerate(boolean generate) {
        this.generate = generate;
    }

    @Override
    public void run() {
        Order order = null;
        Item item = null;

        while (this.generate) {
            int orderId = this.nextOrderId++;
            LocalDateTime timestamp = LocalDateTime.now();
            int customerId =  this.random.nextInt(this.customerIds.size());
            int price = ThreadLocalRandom.current().nextInt(this.minimumPrice,this.maximumPrice);
            int listSize = ThreadLocalRandom.current().nextInt(this.minimumItemsSize,this.maximumItemsSize);

            List<Item> items = new ArrayList<>();
            for(int i = 0; i < listSize; i++){
                int productId =  this.random.nextInt(this.productIds.size());
                int amount =  ThreadLocalRandom.current().nextInt(this.minimumItemAmount,this.maximumItemAmount);
                item = new Item(productId,amount);
                items.add(item);
            }

            order = new Order(customerId,items,orderId,price,timestamp);
            System.out.println(order.toString());

            this.consumer.consume(order);

            try {
                int randomDelay = ThreadLocalRandom.current().nextInt(this.minimumDelay,this.maximumDelay);
                System.out.println("randomdelay: " + randomDelay);
                Thread.sleep(randomDelay);
            } catch (InterruptedException e) {
                logger.error("An interrupt has occured in the randomOrderGenerator while waiting to generate a new order");

            }
        }
    }
}
