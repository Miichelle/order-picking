package orderpicker.models.dto;

import orderpicker.models.domain.Location;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:51
 */
//TODO: Dto voor seperation of concerns. model -> puur om code intern te houden, Order voor enkel wat naar buiten moet
public class ItemDto {
    private int productId;
    private int amount;
    private Location location;

    public ItemDto() { }

    public ItemDto(int productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public ItemDto(int amount, int productId, Location location) {
        this.amount = amount;
        this.productId = productId;
        this.location = location;
    }

    public int getAmount() {
        return this.amount;
    }
    public Location getLocation() {
        return location;
    }
    public int getProductId() {
        return this.productId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "productId=" + productId +
                ", amount=" + amount +
                ", location=" + location +
                '}';
    }
}
