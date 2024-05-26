package Repository;

import exception.OlaException;
import model.*;
import strategy.BookingStrategy;
import strategy.impl.bookedByRatings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TripRepository {
    HashMap<String, List<Trip>> tripList;
    CabRepository cabRepository;
    RiderRepository riderRepository;
    BookingStrategy bookingStrategy;

    public TripRepository(CabRepository cabRepository,RiderRepository riderRepository, BookingStrategy bookingStrategy ){
        this.tripList = new HashMap<>();
        this.cabRepository = cabRepository;
        this.riderRepository = riderRepository;
        this.bookingStrategy = bookingStrategy;
    }

    public String createTrip(Trip trip){
        Location riderSrcLocation = trip.getSrcLocation();
        List<Cab>availableCabs = cabRepository.getAvailableCabs(riderSrcLocation, 6);
        if(availableCabs.isEmpty()){
            throw new OlaException(ErrorCode.cab_does_not_exist, "TRY AGAIN");
        }

        Cab bookedCab = bookingStrategy.getCabForBooking(availableCabs);

        bookedCab.setTripOnline(true);
        bookedCab.setPresentTrip(trip);
        trip.setTripStatus(TripStatus.BOOKED);

        List<Trip>allTrips = tripList.get(trip.getRiderId());
        if(allTrips == null){
            allTrips = new ArrayList<>();
        }
        allTrips.add(trip);
        tripList.put(trip.getRiderId(), allTrips);

        return bookedCab.getCabId();
    }

    public void endTrip(String cabId){
        Cab cab = cabRepository.getCab(cabId);
        cab.setTripOnline(false);

        cab.getPresentTrip().setTripStatus(TripStatus.REACHED);
        cab.setPresentTrip(null);
    }

    public List<Trip> getAllTrips(String riderId){
        return tripList.get(riderId);
    }
}
