package model;

public class Room {
    private String roomId;
    private String roomType;
    private double price;
    private boolean isAvailable;

    public Room(String roomId, String roomType, double price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        this.isAvailable = false;
    }

    public void releaseRoom() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room [id=" + roomId + ", type=" + roomType + ", price=" + price + ", available=" + isAvailable + "]";
    }
}
