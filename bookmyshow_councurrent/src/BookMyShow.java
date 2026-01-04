import Entities.*;
import Enums.*;
import Controller.*;
import Billing.*;
import Payment.*;
import Ticket.*;
import SeatLock.*;

import java.util.*;

public class BookMyShow {
    TheatreContoller theatreContoller;
    MovieController movieController;
    Billing billing;
    SeatLockManager seatLockManager;

    public BookMyShow(){
        theatreContoller = new TheatreContoller();
        movieController = new MovieController();
        billing = new Billing();
        seatLockManager = new SeatLockManager();
    }
    
    void bookSeat(Show interestedShow, int seat, PaymentStrategy paymentStrategy, String userId){
        //5. select the seat
        int seatNumber = seat;
        int showId = interestedShow.getId();
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        
        // Step 1: Try to acquire seat lock
        System.out.println("\n========== SEAT LOCK ACQUISITION ==========");
        System.out.println("User: " + userId);
        System.out.println("Attempting to lock seat " + seatNumber + " for show " + showId + "...");
        
        if (!seatLockManager.lockSeat(showId, seatNumber, userId)) {
            System.out.println("❌ Failed to acquire lock. Seat may be locked by another user.");
            System.out.println("==========================================\n");
            return;
        }
        System.out.println("==========================================\n");
        
        // Step 2: Check if seat is already booked in the show's booked list
        if(bookedSeats.contains(seatNumber)){
            System.out.println("\n❌ ERROR: Seat " + seatNumber + " is already booked for this show!");
            System.out.println("Releasing lock...");
            seatLockManager.unlockSeat(showId, seatNumber, userId);
            System.out.println("Please select a different seat.\n");
            return;
        }
        
        // Step 3: Find the actual seat object and check its booked status
        Seats selectedSeat = null;
        for(Seats screenSeat : interestedShow.getScreen().getSeatsList()) {
            if(screenSeat.getId() == seatNumber) {
                selectedSeat = screenSeat;
                break;
            }
        }
        
        // Validate seat exists
        if(selectedSeat == null) {
            System.out.println("\n❌ ERROR: Seat " + seatNumber + " does not exist in this screen!");
            seatLockManager.unlockSeat(showId, seatNumber, userId);
            return;
        }
        
        // Step 4: Double-check: Verify seat is not already booked (check both list and seat status)
        if(selectedSeat.isSeatBooked()) {
            System.out.println("\n❌ ERROR: Seat " + seatNumber + " is already booked!");
            System.out.println("Releasing lock...");
            seatLockManager.unlockSeat(showId, seatNumber, userId);
            System.out.println("Please select a different seat.\n");
            return;
        }
        
        // Step 5: Reserve the seat (add to booked list) - will be confirmed after payment
        bookedSeats.add(seatNumber);
        selectedSeat.setSeatBooked(true);
        
        // Create booking
        Booking booking = new Booking();
        List<Seats> myBookedSeats = new ArrayList<>();
        myBookedSeats.add(selectedSeat);
        booking.setBookingSeat(myBookedSeats);
        booking.setShow(interestedShow);
        
        System.out.println("\n========== SEAT BOOKING ==========");
        System.out.println("Seat " + seatNumber + " selected successfully!");
        System.out.println("Movie: " + interestedShow.getMovie().getMovieName());
        System.out.println("Show Time: " + interestedShow.getLocalTime());
        System.out.println("===================================\n");
        
        // Calculate billing
        double totalAmount = billing.calculateTotalAmount(myBookedSeats);
        
        // Process payment
        Payment payment = billing.processPayment(totalAmount, paymentStrategy);
        booking.setPayment(payment);
        
        // Generate and print ticket only if payment is successful
        if(payment.isPaymentSuccessful()) {
            Ticket ticket = new Ticket(booking, payment);
            ticket.printTicket();
            System.out.println("✅ BOOKING SUCCESSFUL");
            // Release lock after successful booking
            seatLockManager.unlockSeat(showId, seatNumber, userId);
            System.out.println("🔓 Seat lock released after successful booking.\n");
        } else {
            // Rollback: Payment failed, release the seat and lock
            System.out.println("\n❌ Payment failed. Booking cancelled.");
            System.out.println("Releasing seat " + seatNumber + "...");
            bookedSeats.remove(Integer.valueOf(seatNumber));
            selectedSeat.setSeatBooked(false);
            seatLockManager.unlockSeat(showId, seatNumber, userId);
            System.out.println();
            return;
        }
    }
    Show createBooking(City city, String movieName)
    {
        //1. search movie by my location
        List<Movies> movies = movieController.getMoviesByCity(city);

        //2. select the movie which you want to see. i want to see Baahubali
        Movies interestedMovie = null;
        for (Movies movie : movies) {

            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreContoller.getAllShow(interestedMovie, city);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        return interestedShow;

    }
    //create movie and add movie in the controller
    void intialize() {
        addMovie();
        addTheatre();
    }

    void addMovie()
    {
        Movies movie1 = new Movies(1, "Dangal", Genres.ACTION, Languages.HINDI, 220);
        Movies movie2 = new Movies(2, "Bahubali", Genres.DRAMA, Languages.TAMIL, 310);
        movieController.addMovieInController(City.JAIPUR, movie1);
        movieController.addMovieInController(City.JAIPUR, movie2);
        movieController.addMovieInController(City.DELHI, movie1);
        movieController.addMovieInController(City.DELHI, movie2);
    }

    void addTheatre() {

        Movies movie1 = movieController.getMovieByName("Bahubali");
        Movies movie2 = movieController.getMovieByName("Dangal");

        //theatre1
        Theatre theatre1 = new Theatre();
        theatre1.setId(1);
        theatre1.setTheatreType(TheatreType.INOX);
        theatre1.setTheatreLocation(new TheatreLocation(328022, "GarudaMall"));
        theatre1.setScreens(createScreen());
        Show show1  = new Show(1, movie1, "12:30", createScreen().get(0));
        Show show2  = new Show(2, movie2, "11:30", createScreen().get(1));
        List<Show>showList1 = new ArrayList<>();

        showList1.add(show1);
        showList1.add(show2);
        theatre1.setShow(showList1);

        //theatre2------
        Theatre theatre2 = new Theatre();
        theatre2.setId(2);
        theatre2.setTheatreType(TheatreType.PVR);
        theatre2.setTheatreLocation(new TheatreLocation(302022, "CITYMALL"));
        theatre2.setScreens(createScreen());
        Show show3  = new Show(1, movie1, "01:30", createScreen().get(2));
        Show show4  = new Show(2, movie2, "03:30", createScreen().get(3));
        List<Show>showList2 = new ArrayList<>();
        showList2.add(show3);
        showList2.add(show4);
        theatre2.setShow(showList2);

        theatreContoller.addTheatreInController(theatre1, City.JAIPUR);
        theatreContoller.addTheatreInController(theatre2, City.DELHI);
    }
    List<Screen> createScreen()
    {
        List<Screen> screenList = new ArrayList<>();
        for(int i = 1 ; i <= 5 ; i++) {
            Screen screen1 = new Screen(i, createSeats());
            screenList.add(screen1);
        }
        return screenList;
    }
    List<Seats> createSeats()
    {
        List<Seats> seatsList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Seats seat = new Seats(i, SeatType.NORMAL, 100, false);
            seatsList.add(seat);
        }
        for (int i = 21; i <= 40; i++) {
            Seats seat = new Seats(i, SeatType.RECLINER, 500, false);
            seatsList.add(seat);
        }
        return seatsList;
    }
}
