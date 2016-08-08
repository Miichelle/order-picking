package orderpicker.models;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 17:22
 */
public class Item {
    private int productId;
    private int amount;

    public Item(int productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
