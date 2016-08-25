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

/**
 * This class consumes the locations of the order items
 */
public class OrderPicker implements Consumer<Order> {
    private final Logger logger = Logger.getLogger(OrderPicker.class);

    private LocationService locationService;
    private Optimalization optimalization;
    private Consumer<Order> consumer;
    private Buffer<Order> orderBuffer;

    public OrderPicker(Consumer<Order> consumer, Optimalization optimalization, long cacheInterval,long locationBufferInterval) {
        this.consumer = consumer;
        this.locationService = new LocationService(cacheInterval);
        this.optimalization = optimalization;
        this.orderBuffer = new OrderBuffer(locationBufferInterval);
    }

    @Override
    public void consume(Order order) {
        Location location = null;

        for (Item item : order.getItems()) {
            try {
                location= this.locationService.get(item.getProductId());
            } catch (ApiServiceException e) {
                logger.warn("Something went wrong while consuming the location");
                this.orderBuffer.buffer(order);
            }

            item.setLocation(location);
        }

        List<Order> optimizedOrders = this.optimalization.optimize(order);

        for (Order optimizedOrder : optimizedOrders) {
            this.consumer.consume(optimizedOrder);
        }

        List<Order> uncompletedOrders =  this.orderBuffer.getBufferedItems();

        for (Order uncompletedOrder : uncompletedOrders) {
                logger.info("Retrying to consume location");
                this.consume(uncompletedOrder);
        }
    }
}
