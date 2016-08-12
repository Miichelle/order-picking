package generator.models.dto;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 00:51
 */
//TODO: Dto voor seperation of concerns. model -> puur om code intern te houden, order voor enkel wat naar buiten moet
public class ItemDto {
    private int productId;
    private int amount;

    public ItemDto(int productId, int amount) {
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