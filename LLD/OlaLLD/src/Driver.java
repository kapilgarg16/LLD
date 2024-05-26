import Repository.CabRepository;
import Repository.RiderRepository;
import Repository.TripRepository;
import exception.OlaException;
import model.*;
import strategy.BookingStrategy;
import strategy.impl.bookedByRatings;

public class Driver {
    public static void main(String[] args) {

        CabRepository cabRepository = new CabRepository();
        RiderRepository riderRepository = new RiderRepository();
        BookingStrategy bookingStrategy = new bookedByRatings();
        TripRepository tripRepository = new TripRepository(cabRepository, riderRepository, bookingStrategy);

        Location riderSrc = new Location(0, 0);
        Location riderDest = new Location(6, 8);
        Location cabSrc1 = new Location(3, 4);
        Location cabSrc2 = new Location(3, 4);

        Cab cab1 = new Cab("123", cabSrc1, 4.0);
        Cab cab2 = new Cab("2323",cabSrc2, 5.0 );

        String cabId1 = cabRepository.addCab(cab1);
        String cabId2 = cabRepository.addCab(cab2);

        Rider rider1 = new Rider("kapil");
        String riderId = riderRepository.addRider(rider1);

        Trip trip = new Trip(riderId, riderSrc, riderDest);

        try {
            String cabId = tripRepository.createTrip(trip);
            System.out.println("trip is booked");
//            tripRepository.endTrip(cabId);
        }
        catch (OlaException e){
            System.out.println(e.errorCode + " " + e.message);
        }

        try {
            String cabId = tripRepository.createTrip(trip);
            System.out.println("trip is booked");
//            tripRepository.endTrip(cabId);
        }
        catch (OlaException e){
            System.out.println(e.errorCode + " " + e.message);
        }

}}
