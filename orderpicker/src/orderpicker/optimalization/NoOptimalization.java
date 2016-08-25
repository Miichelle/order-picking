package orderpicker.optimalization;

import orderpicker.models.domain.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:07
 */
public class NoOptimalization implements Optimalization {
    //TODO: IN LOGGER MEEGEVEN WELKE OPTIMALISATIE ( NO SINGLE GROUP)
    @Override
    public List<Order> apply(Order order) {
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        return orders;
    }
}
