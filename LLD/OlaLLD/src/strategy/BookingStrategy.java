package strategy;

import model.Cab;

import java.util.List;

public interface BookingStrategy {
    Cab getCabForBooking(List<Cab>cabs);
}
