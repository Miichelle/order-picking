package orderpicker.optimalization;

import orderpicker.consumation.Consumer;
import orderpicker.models.domain.Order;

import java.util.Collections;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:06
 */
public class SingleOptimalization implements Optimalization {
    private Consumer<Order> consumer;

    public SingleOptimalization(Consumer<Order> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void apply(List<Order> orders) {
        for (Order order : orders) {
            Collections.shuffle(order.getItems());
            this.consumer.consume(order);
        }
    }
}
