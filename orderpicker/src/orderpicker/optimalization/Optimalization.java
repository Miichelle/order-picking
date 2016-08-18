package orderpicker.optimalization;

import orderpicker.models.domain.Order;

import java.util.List;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:06
 */
public interface Optimalization {
    List<Order> apply(List<Order> orders);
}
