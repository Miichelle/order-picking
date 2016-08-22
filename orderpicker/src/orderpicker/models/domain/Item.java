package orderpicker.models.domain;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 17:22
 */
public class Item {
    private int productId;
    private int amount;
    private Location location;

    public Item(int productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public Item(int productId, int amount, Location location) {
        this.productId = productId;
        this.amount = amount;
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
        return "Item{" +
                "productId=" + productId +
                ", amount=" + amount +
                ", location=" + location +
                '}';
    }
}
