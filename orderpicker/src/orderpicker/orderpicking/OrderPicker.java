package orderpicker.orderpicking;

import orderpicker.api.ApiServiceException;
import orderpicker.api.LocationService;
import orderpicker.consumation.Consumer;
import orderpicker.models.domain.Item;
import orderpicker.models.domain.Location;
import orderpicker.models.domain.Order;
import orderpicker.optimalization.Optimalization;
import org.apache.log4j.Logger;

import java.util.ArrayList;
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

    private List<Order> orders;

    public OrderPicker(Optimalization optimalization,long duration,long retryGetInterval) {
        this.locationService = new LocationService(duration,retryGetInterval);
        this.optimalization = optimalization;

        orders = new ArrayList<>();
    }

    //TODO:orderpicker consumes de locaties van items en steekt in cache
    @Override
    public void consume(Order order) {
        orders.add(order);

        Location location = null;

        for (Item item : order.getItems()) {
            try {
                location= this.locationService.get(item.getProductId());
            } catch (ApiServiceException e) {
                logger.error("Something went wrong while consuming the location in the orderPicker");
            }
            //TODO: DIT MAG NIET. MOET VIA CACHE GEBEUREN
            item.setLocation(location);
        }

         this.optimalization.apply(orders);
    }
}
