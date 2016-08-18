package orderpicker.models.dto;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:51
 */
//TODO: Dto voor seperation of concerns. model -> puur om code intern te houden, Order voor enkel wat naar buiten moet
public class ItemDto {
    private int productid;
    private int amount;

    public ItemDto() { }

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
