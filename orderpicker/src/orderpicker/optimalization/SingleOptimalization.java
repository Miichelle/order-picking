package orderpicker.optimalization;

import orderpicker.models.domain.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:06
 */
public class SingleOptimalization implements Optimalization {
    @Override
    public List<Order> apply(Order order) {
        Collections.shuffle(order.getItems());

        List<Order> orders = new ArrayList<>();
        orders.add(order);

        return orders;
    }
}
