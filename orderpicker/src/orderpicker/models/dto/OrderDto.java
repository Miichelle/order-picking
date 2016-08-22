package orderpicker.models.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:47
 */
public class OrderDto {
    private int customerId;
    private List<ItemDto> items;
    private int orderId;
    private int price;
    private LocalDateTime timestamp;

    public OrderDto() {}

    public OrderDto(int orderId, int customerId, List<ItemDto> items, int price, LocalDateTime timestamp) {
        this.customerId = customerId;
        this.items = items;
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
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "customerId=" + customerId +
                ", items=" + items +
                ", orderId=" + orderId +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}
