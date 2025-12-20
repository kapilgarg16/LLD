package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String hotelId;
    private String name;
    private String location;
    private double rating;
    private List<Room> rooms;

    public Hotel(String hotelId, String name, String location, double rating) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.rooms = new ArrayList<>();
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getLocation() {
        return location;
    }

    public List<Room> getAvailableRooms(String roomType) {
        return rooms.stream()
                .filter(room -> room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable())
                .collect(Collectors.toList());
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(String roomId) {
        rooms.removeIf(room -> room.getRoomId().equals(roomId));
    }

    @Override
    public String toString() {
        return "Hotel [id=" + hotelId + ", name=" + name + ", location=" + location + ", rating=" + rating + "]";
    }
}
