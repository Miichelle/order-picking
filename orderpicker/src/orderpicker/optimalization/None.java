package orderpicker.optimalization;

import orderpicker.api.LocationService;
import orderpicker.models.domain.Order;

import java.util.List;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:07
 */
public class None implements Optimalization {
    private LocationService locationService;


    public None() {
        //this.locationService = new LocationService(None.class);
    }

    @Override
    public List<Order> apply(List<Order> orders) {
        return null;
    }
}
