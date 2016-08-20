package orderpicker.orderpicking;

import orderpicker.consumation.Consumer;
import orderpicker.api.ApiServiceException;
import orderpicker.api.LocationService;
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

    public OrderPicker(Optimalization optimalization) {
        this.locationService = new LocationService();
        this.optimalization = optimalization;
    }

    @Override
    public void consume(Order target) {
        List<Location> locations = new ArrayList<>();

        for (Item item : target.getItems()) {
            Location location = null;

            try {
                location = this.locationService.get(item.getProductid());
            } catch (ApiServiceException e) {
                logger.error("Something went wrong while consuming the location in the orderPicker");
            }
            locations.add(location);
        }

        System.out.println(locations.toString());
      //locations = this.optimalization.apply();
    }

    public void start() {
    }
}
