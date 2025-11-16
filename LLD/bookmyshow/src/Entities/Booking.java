package Entities;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    Show show;
    List<Seats> bookingSeat = new ArrayList<>();
    Payment payment;

    public Show getShow() {
        return show;
    }

    public void     setShow(Show show) {
        this.show = show;
    }

    public List<Seats> getBookingSeat() {
        return bookingSeat;
    }

    public void setBookingSeat(List<Seats> bookingSeat) {
        this.bookingSeat = bookingSeat;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
