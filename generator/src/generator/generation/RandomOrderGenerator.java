package generator.generation;

import generator.consumation.Consumer;
import generator.models.domain.Order;

import java.util.List;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 21:04
 */
public class RandomOrderGenerator implements Runnable {
    private Consumer<Order> consumer;

    private final double minimumDelay;
    private final double maximumDelay;

    private final double minimumPrice;
    private final double maximumPrice;

    private final int minimumItemAmount;
    private final int maximumItemAmount;

    private final int nextOrderId;

    private volatile boolean generate;

    public RandomOrderGenerator(
            Consumer<Order> consumer,
            List<Integer> customerIds, List<Integer> productIds,
            double minimumDelay, double maximumDelay,
            double minimumPrice, double maximumPrice,
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

        this.generate = true;
    }

    public void setGenerate(boolean generate) {
        this.generate = generate;
    }

    @Override
    public void run() {
        while (generate) {
            System.out.println("hi");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // log
            }
        }
    }
}
