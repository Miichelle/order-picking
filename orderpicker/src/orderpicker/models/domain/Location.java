package orderpicker.models.domain;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 18:05
 */
public class Location {
    private int hallway;
    private int productId;
    private int rack;
    private String storageRoom;

    public Location(int productId, String storageRoom, int hallway, int rack) {
        this.productId = productId;
        this.storageRoom = storageRoom;
        this.hallway = hallway;
        this.rack = rack;
    }

    public int getHallway() {
        return hallway;
    }
    public int getProductId() {
        return productId;
    }
    public int getRack() {
        return rack;
    }
    public String getStorageRoom() {
        return storageRoom;
    }

    public void setHallway(int hallway) {
        this.hallway = hallway;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setRack(int rack) {
        this.rack = rack;
    }
    public void setStorageRoom(String storageRoom) {
        this.storageRoom = storageRoom;
    }

    @Override
    public String toString() {
        return "Location{" +
                "hallway=" + hallway +
                ", productId=" + productId +
                ", rack=" + rack +
                ", storageRoom='" + storageRoom + '\'' +
                '}';
    }
}
