package model;

public class Bill {
    private String billId;
    private Booking booking;
    private double totalAmount;
    private boolean isPaid;

    public Bill(String billId, Booking booking) {
        this.billId = billId;
        this.booking = booking;
        this.totalAmount = booking.room.getPrice();
        this.isPaid = false;
    }

    public void markPaid() {
        this.isPaid = true;
    }

    @Override
    public String toString() {
        return "Bill [id=" + billId + ", booking=" + booking + ", totalAmount=" + totalAmount + ", isPaid=" + isPaid + "]";
    }
}
