package orderpicker.models.domain;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 17:22
 */
public class Item {
    private int productid;
    private int amount;

    public Item(int productId, int amount) {
        this.productid = productId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{   " +
                "productid=" + productid +
                ", amount=" + amount +
                '}';
    }

    public int getAmount() {
        return this.amount;
    }
    public int getProductid() {
        return this.productid;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setProductid(int productid) {
        this.productid = productid;
    }
}
