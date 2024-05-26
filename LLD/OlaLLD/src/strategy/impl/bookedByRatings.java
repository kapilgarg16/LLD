package strategy.impl;

import model.Cab;
import strategy.BookingStrategy;

import java.util.List;

public class bookedByRatings implements BookingStrategy {

    @Override
    public Cab getCabForBooking(List<Cab> cabs) {
        Double max_rating = 0.0;
        Cab bookedCab = null;
        for(Cab cab : cabs){
            if(cab.getRating() >= max_rating){
                bookedCab = cab;
            }
        }
        return bookedCab;
    }
}
