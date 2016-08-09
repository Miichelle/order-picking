package orderpicker.amqp.dto;

import orderpicker.models.Location;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 17:37
 */
public class OrderItemLocationDto {
    private int customerId;
    private List<ItemDto> items;
    private Location location;
    private int orderId;
    private int price;
    private LocalDateTime timestamp;

    public OrderItemLocationDto(int customerId, List<ItemDto> items, Location location, int orderId, int price, LocalDateTime timestamp) {
        this.customerId = customerId;
        this.items = items;
        this.location = location;
        this.orderId = orderId;
        this.price = price;
        this.timestamp = timestamp;
    }

    public int getCustomerId() {
        return customerId;
    }
    public List<ItemDto> getItems() {
        return items;
    }
    public Location getLocation() {
        return location;
    }
    public int getOrderId() {
        return orderId;
    }
    public int getPrice() {
        return price;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
