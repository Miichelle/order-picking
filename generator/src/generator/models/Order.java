package generator.models;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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
    private Random random;
    private LocalDateTime timestamp;

    public Order(int customerId, List<Item> items, int orderId, int price, LocalDateTime timestamp) {
        random = new Random();
        this.items = items;
        this.customerId = customerId;
        this.orderId = 100000;
        this.price = price;
        this.timestamp = timestamp;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
