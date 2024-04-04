package CarRentalSystem;
import CarRentalSystem.Product.Vehicle;
import java.util.Date;
public class VehicleReservation {
        int reservationId;
        User user;
        Vehicle vehicle;
        Date bookingDate;
        Date dateBookedFrom;
        Date dateBookedTo;
        Long fromTimeStamp;
        Long toTimeStamp;
        Location pickUpLocation;
        Location dropLocation;
        ReservationType reservationType;
        ReservationStatus reservationStatus;
        Location location;

        public int createReserve(User user, Vehicle vehicle){

            //generate new id
            reservationId = 12232;
            this.user=user;
            this.vehicle=vehicle;
            reservationType = ReservationType.daily;
            reservationStatus = ReservationStatus.completed;

            return reservationId;
        }

    }
