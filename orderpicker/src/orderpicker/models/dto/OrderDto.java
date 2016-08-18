package orderpicker.models.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:47
 */
public class OrderDto {
    private int customerid;
    private List<ItemDto> items;
    private int orderid;
    private int price;
    private LocalDateTime timestamp;

    public OrderDto() {}

    public int getCustomerid() {
        return customerid;
    }
    public List<ItemDto> getItems() {
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
    public void setItems(List<ItemDto> items) {
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
}
