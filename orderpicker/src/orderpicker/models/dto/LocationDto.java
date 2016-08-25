package orderpicker.models.dto;

/**
 * Michelle Beckers
 * Datum: 16-8-2016
 * Time: 13:54
 */

/**
 * This class represents an location
 */
public class LocationDto {
    private int hallway;
    private int productId;
    private int rack;
    private String storageRoom;

    public LocationDto(){}

    public LocationDto(int productId,int hallway, int rack, String storageRoom) {
        this.hallway = hallway;
        this.productId = productId;
        this.rack = rack;
        this.storageRoom = storageRoom;
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
}
