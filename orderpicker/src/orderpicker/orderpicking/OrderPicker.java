package orderpicker.orderpicking;

import orderpicker.api.ApiServiceException;
import orderpicker.api.LocationService;
import orderpicker.buffer.Buffer;
import orderpicker.buffer.OrderBuffer;
import orderpicker.consumation.Consumer;
import orderpicker.models.domain.Item;
import orderpicker.models.domain.Location;
import orderpicker.models.domain.Order;
import orderpicker.optimalization.Optimalization;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 19:56
 */
public class OrderPicker implements Consumer<Order> {
    private final Logger logger = Logger.getLogger(OrderPicker.class);

    private LocationService locationService;
    private Optimalization optimalization;
    private Consumer<Order> consumer;
    private Buffer<Order> orderBuffer;

    public OrderPicker(Consumer<Order> consumer, Optimalization optimalization, long duration) {
        this.consumer = consumer;
        this.locationService = new LocationService(duration);
        this.optimalization = optimalization;
        this.orderBuffer = new OrderBuffer(10000);
    }

    //TODO:orderpicker consumes de locaties van items en steekt in cache
    @Override
    public void consume(Order order) {
        Location location = null;

        for (Item item : order.getItems()) {
            try {
                location= this.locationService.get(item.getProductId());
            } catch (ApiServiceException e) {
                logger.error("Something went wrong while consuming the location in the orderPicker");
                this.orderBuffer.buffer(order);
            }

            item.setLocation(location);
        }

        List<Order> optimizedOrders = this.optimalization.apply(order);

        for (Order optimizedOrder : optimizedOrders) {
            this.consumer.consume(optimizedOrder);
        }

        List<Order> uncompletedOrders = this.orderBuffer.getBufferedItems();

        for (Order uncompletedOrder : uncompletedOrders) {
            this.consume(uncompletedOrder);
        }
    }
}
