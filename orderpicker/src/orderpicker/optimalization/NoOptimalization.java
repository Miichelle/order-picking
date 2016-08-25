package orderpicker.optimalization;

import orderpicker.models.domain.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:07
 */

/**
 * This strategy provides no optimalization
 */
public class NoOptimalization implements Optimalization {

    @Override
    public List<Order> optimize(Order order) {
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        return orders;
    }
}
