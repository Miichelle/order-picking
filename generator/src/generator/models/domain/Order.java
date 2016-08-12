package generator.models.domain;


import java.time.LocalDateTime;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 18:10
 */
public class Order {
    private int customerId;
    private List<Item> items;
    private int orderId;
    private int price;
    private LocalDateTime timestamp;

    public Order(int customerId, List<Item> items, int orderId, int price, LocalDateTime timestamp) {
        this.customerId = customerId;
        this.items = items;
        this.orderId = orderId;
        this.price = price;
        this.timestamp = timestamp;
    }

    public int getCustomerId() {
        return customerId;
    }
    public List<Item> getItems() {
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
    public void setItems(List<Item> items) {
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
}
