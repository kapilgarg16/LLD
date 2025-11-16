package Entities;

import Enums.SeatType;

public class Seats {
    int id;
    SeatType seatType;
    float priceForSeat;
    boolean isSeatBooked;

    public Seats(int id, SeatType seatType, float priceForSeat, boolean isSeatBooked) {
        this.id = id;
        this.seatType = seatType;
        this.priceForSeat = priceForSeat;
        this.isSeatBooked = isSeatBooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public float getPriceForSeat() {
        return priceForSeat;
    }

    public void setPriceForSeat(float priceForSeat) {
        this.priceForSeat = priceForSeat;
    }

    public boolean isSeatBooked() {
        return isSeatBooked;
    }

    public void setSeatBooked(boolean seatBooked) {
        isSeatBooked = seatBooked;
    }
}
