package strategy.impl;

import model.Cab;
import strategy.BookingStrategy;

import java.util.List;

public class getFirstCab implements BookingStrategy {
    @Override
    public Cab getCabForBooking(List<Cab> cabs) {
        return cabs.get(0);
    }
}
