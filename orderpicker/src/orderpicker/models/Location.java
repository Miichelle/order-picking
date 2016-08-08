package orderpicker.models;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 18:05
 */
public class Location {

    private int productId;
    private String storageRoom;
    private int hallway;
    private int rack;

    public Location(int productId, String storageRoom, int hallway, int rack) {
        this.productId = productId;
        this.storageRoom = storageRoom;
        this.hallway = hallway;
        this.rack = rack;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getStorageRoom() {
        return storageRoom;
    }

    public void setStorageRoom(String storageRoom) {
        this.storageRoom = storageRoom;
    }

    public int getHallway() {
        return hallway;
    }

    public void setHallway(int hallway) {
        this.hallway = hallway;
    }

    public int getRack() {
        return rack;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }
}
