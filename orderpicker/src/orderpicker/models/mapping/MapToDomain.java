package orderpicker.models.mapping;

import orderpicker.models.domain.Item;
import orderpicker.models.domain.Location;
import orderpicker.models.domain.Order;
import orderpicker.models.dto.ItemDto;
import orderpicker.models.dto.LocationDto;
import orderpicker.models.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 22:36
 */

/**
 * This class provides model mapping
 */
public class MapToDomain {
    public static Order map(OrderDto orderDto) {
        final int customerId = orderDto.getCustomerId();
        final List<Item> items = map(orderDto.getItems());
        final int orderId = orderDto.getOrderId();
        final int price = orderDto.getPrice();
        final LocalDateTime timestamp = orderDto.getTimestamp();

        return new Order(orderId,customerId, items,  price, timestamp);
    }

    public static Item map(ItemDto itemDto) {
        final int productId = itemDto.getProductId();
        final int amount = itemDto.getAmount();

        return new Item(productId, amount);
    }

    public static List<Item> map(List<ItemDto> itemDtos) {
        ArrayList<Item> items = new ArrayList<>();

        itemDtos.forEach((itemDto) -> items.add(map(itemDto)));

        return items;
    }

    public static Location map(LocationDto dto) {
        final int productId = dto.getProductId();
        final int hallway = dto.getHallway();
        final int rack = dto.getRack();
        final String storageRoom = dto.getStorageRoom();

        return new Location(productId, storageRoom, hallway, rack);
    }
}
