package orderpicker.optimalization;

import orderpicker.consumation.Consumer;
import orderpicker.models.domain.Item;
import orderpicker.models.domain.Order;

import java.util.List;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 16:07
 */
public class NoOptimalization implements Optimalization {
    private Consumer<Order> consumer;

    public NoOptimalization(orderpicker.consumation.Consumer<Order> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void apply(List<Order> orders) {
        for (Order order : orders) {
            for (Item item : order.getItems()) {
                   //TODO: via cache locatie ophalen
                /*if(this.locationCache.isCached(item.getProductId())){
                    item.setLocation(locationCache.get(item.getProductId()));
                }*/
            }
            this.consumer.consume(order);
        }
    }
}
