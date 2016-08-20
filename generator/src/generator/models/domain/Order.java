package generator.models.domain;


import java.time.LocalDateTime;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 18:10
 */
public class Order {
    private int customerid;
    private List<Item> items;
    private int orderid;
    private int price;
    private LocalDateTime timestamp;

    public Order(int customerId, List<Item> items, int orderId, int price, LocalDateTime timestamp) {
        this.customerid = customerId;
        this.items = items;
        this.orderid = orderId;
        this.price = price;
        this.timestamp = timestamp;
    }

    public int getCustomerid() {
        return customerid;
    }
    public List<Item> getItems() {
        return items;
    }
    public int getOrderid() {
        return orderid;
    }
    public int getPrice() {
        return price;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Order:  " +
                "customerid=" + customerid +
                ", items=" + items.size() + " " + items +
                ", orderid=" + orderid +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}
