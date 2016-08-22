package orderpicker.models.mapping;

import orderpicker.models.domain.Item;
import orderpicker.models.domain.Location;
import orderpicker.models.domain.Order;
import orderpicker.models.dto.ItemDto;
import orderpicker.models.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 22-8-2016
 * Time: 19:07
 */
public class MapToDTO {
    public static OrderDto map(Order order) {
        final int customerId = order.getCustomerId();
        final List<ItemDto> items = map(order.getItems());
        final int orderId = order.getOrderId();
        final int price = order.getPrice();
        final LocalDateTime timestamp = order.getTimestamp();

        return new OrderDto(orderId,customerId, items, price, timestamp);
    }

    public static ItemDto map(Item item) {
        final int productId = item.getProductId();
        final int amount = item.getAmount();
        final Location location = item.getLocation();

        return new ItemDto(productId, amount,location);
    }

    public static List<ItemDto> map(List<Item> items) {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();

        items.forEach((item) -> itemDtos.add(map(item)));

        return itemDtos;
    }

}
