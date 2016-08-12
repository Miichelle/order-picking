package generator.models.mapping;

import generator.models.domain.Item;
import generator.models.domain.Order;
import generator.models.dto.ItemDto;
import generator.models.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 22:36
 */
public class Mapper {
    public static OrderDto map(Order order) {
        final int customerId = order.getCustomerId();
        final List<ItemDto> items = map(order.getItems());
        final int orderId = order.getOrderId();
        final int price = order.getPrice();
        final LocalDateTime timestamp = order.getTimestamp();

        return new OrderDto(customerId, items, orderId, price, timestamp);
    }

    public static ItemDto map(Item item) {
        final int productId = item.getProductId();
        final int amount = item.getAmount();

        return new ItemDto(productId, amount);
    }

    public static List<ItemDto> map(List<Item> items) {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();

        items.forEach((item) -> itemDtos.add(map(item)));

        return itemDtos;
    }
}
