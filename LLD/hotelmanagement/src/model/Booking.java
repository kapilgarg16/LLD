package model;

import java.util.Date;

public class Booking {
    private String bookingId;
    private Guest guest;
    private Hotel hotel;
    Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private String status; // Active, Cancelled, Completed

    public Booking(String bookingId, Guest guest, Hotel hotel, Room room, Date checkInDate, Date checkOutDate) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.hotel = hotel;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = "Active";
        room.bookRoom();
    }

    public void cancelBooking() {
        this.status = "Cancelled";
        room.releaseRoom();
    }

    @Override
    public String toString() {
        return "Booking [id=" + bookingId + ", guest=" + guest + ", hotel=" + hotel + ", room=" + room + ", status=" + status + "]";
    }
}
