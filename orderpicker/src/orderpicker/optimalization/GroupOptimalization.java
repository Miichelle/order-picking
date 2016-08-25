package orderpicker.optimalization;

import orderpicker.buffer.Buffer;
import orderpicker.buffer.OrderBuffer;
import orderpicker.models.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:06
 */

/**
 * This strategy provides a group optimalization: it buffers orders and groups them randomly
 */
public class GroupOptimalization implements Optimalization {
    private Buffer<Order> orderBuffer;
    private Random random;

    public GroupOptimalization(long orderBufferTimer) {
        this.orderBuffer = new OrderBuffer(orderBufferTimer);
        random = new Random();
    }

    @Override
    public List<Order> optimize(Order order) {
        orderBuffer.buffer(order);

        List<Order> orders = orderBuffer.getBufferedItems();

        if (orders.isEmpty()) { return orders; }

        int chosenOrderAmount = random.nextInt(orders.size());
        List<Order> chosenOrders =  new ArrayList<>();

        for(int i = chosenOrderAmount-1; i >= 0; i--){
            chosenOrders.add(orders.get(i));
            orders.remove(i);
        }

        for (Order leftover : orders) {
            this.orderBuffer.buffer(leftover);
        }

        return chosenOrders;
    }
}
