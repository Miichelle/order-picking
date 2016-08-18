package generator.generation;

import generator.consumation.Consumer;
import generator.models.domain.Item;
import generator.models.domain.Order;

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
    private Consumer<Order> consumer;

    private final int minimumDelay;
    private final int maximumDelay;

    private final int minimumPrice;
    private final int maximumPrice;

    private final int minimumItemAmount;
    private final int maximumItemAmount;

    private int nextOrderId;

    private volatile boolean generate;

    //todo: op volgorde zetten
    private Random random;

    private List<Integer> customerIds;
    private List<Integer> productIds;

    public RandomOrderGenerator(
            Consumer<Order> consumer,
            List<Integer> customerIds, List<Integer> productIds,
            int minimumDelay, int maximumDelay,
            int minimumPrice, int maximumPrice,
            int minimumItemAmount, int maximumItemAmount,
            int firstOrderId) {
        this.consumer = consumer;

        this.minimumDelay = minimumDelay;
        this.maximumDelay = maximumDelay;

        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;

        this.minimumItemAmount = minimumItemAmount;
        this.maximumItemAmount = maximumItemAmount;

        this.nextOrderId = firstOrderId;

        //TODO: mooi zetten
        this.generate = true;
        random = new Random();

        this.customerIds = customerIds;
        this.productIds = productIds;
    }

    public void setGenerate(boolean generate) {
        this.generate = generate;
    }

    public void generateOrder(){
    }

    @Override
    public void run() {
        Order order = null;
        Item item = null;

        while (this.generate) {
            System.out.println("hi");

            int orderId = this.nextOrderId++;
            LocalDateTime timestamp = LocalDateTime.now();
            int customerId =  this.random.nextInt(this.customerIds.size());
            int price = ThreadLocalRandom.current().nextInt(this.minimumPrice,this.maximumPrice);

            //items
            int listSize = this.random.nextInt(5) + 1;
            List<Item> items = new ArrayList<>();
            for(int i = 0; i < listSize; i++){
                int productId =  this.random.nextInt(this.productIds.size());
                int amount =  ThreadLocalRandom.current().nextInt(this.minimumItemAmount,this.maximumItemAmount);
                item = new Item(productId,amount);
                items.add(item);
            }

            order = new Order(customerId,items,orderId,price,timestamp);

            this.consumer.consume(order);

            System.out.println(order.toString());
            try {
                int randomDelay = ThreadLocalRandom.current().nextInt(this.minimumDelay,this.maximumDelay);
                System.out.println("randomdelay: " + randomDelay);
                Thread.sleep(randomDelay);
            } catch (InterruptedException e) {
                // log
            }
        }
    }
}
