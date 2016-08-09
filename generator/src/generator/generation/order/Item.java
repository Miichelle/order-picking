package generator.generation.order;

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

    public int getAmount() {
        return this.amount;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
