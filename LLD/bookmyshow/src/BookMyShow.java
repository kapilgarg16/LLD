import Entities.*;
import Enums.*;

import java.util.*;

public class BookMyShow {
    TheatreContoller theatreContoller;
    MovieController movieController;

    public BookMyShow(){
        theatreContoller = new TheatreContoller();
        movieController = new MovieController();
    }
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.intialize();

        bookMyShow.createBooking(City.DELHI, "Bahubali");
        bookMyShow.createBooking(City.DELHI, "Bahubali");
    }

    void createBooking(City city, String movieName)
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

        //5. select the seat
        int seatNumber = 31;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
//            //startPayment
            Booking booking = new Booking();
            List<Seats> myBookedSeats = new ArrayList<>();
            for(Seats screenSeat : interestedShow.getScreen().getSeatsList()) {
                if(screenSeat.getId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookingSeat(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");

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
