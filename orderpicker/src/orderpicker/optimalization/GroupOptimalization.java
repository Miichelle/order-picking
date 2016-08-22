package orderpicker.optimalization;

import orderpicker.consumation.Consumer;
import orderpicker.models.domain.Item;
import orderpicker.models.domain.Location;
import orderpicker.models.domain.Order;

import java.util.List;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:06
 */
public class GroupOptimalization implements Optimalization {
    private Location location;
    private Consumer<Order> consumer;

    public GroupOptimalization(Consumer<Order> consumer) {
        this.consumer = consumer;
    }


    @Override
    public void apply(List<Order> orders) {
        for (Order order : orders) {
            for (Item item : order.getItems()) {

            }
        }
    }
}
