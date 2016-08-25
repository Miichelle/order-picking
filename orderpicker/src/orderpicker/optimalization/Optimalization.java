package orderpicker.optimalization;

import orderpicker.models.domain.Order;

import java.util.List;

/* Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:06
 */

/**
 * Defines a an optimalization of orders
 */
public interface Optimalization {

    /**
     * This method defines optimizing functionality.
     * @param order The order to optimize
     * @return list of orders
     */
    List<Order> optimize(Order order);
}
