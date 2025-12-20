import model.*;
import repository.*;
import service.*;

import java.util.*;

public class HotelManagementApp {
    public static void main(String[] args) {
        // Repositories
        HotelRepository hotelRepository = new HotelRepository();
        GuestRepository guestRepository = new GuestRepository();
        BookingRepository bookingRepository = new BookingRepository();

        // Services
        HotelService hotelService = new HotelService(hotelRepository);
        GuestService guestService = new GuestService(guestRepository);
        BookingService bookingService = new BookingService(bookingRepository, hotelRepository);

        // Data Initialization
        Hotel hotel = new Hotel("H001", "The Grand", "New Delhi", 4.5);
        Room room1 = new Room("R101", "Single", 2000);
        Room room2 = new Room("R102", "Double", 3000);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotelRepository.save(hotel);

        Guest guest = new Guest("G001", "Kapil Garg", "9876543210", "kapil@example.com");
        guestService.saveGuest(guest);

        // Fetch and display all hotels
        System.out.println("All Hotels: ");
        List<Hotel> hotels = hotelService.getAllHotels();
        for (Hotel h : hotels) {
            System.out.println(h);
        }

        // Search hotels by location
        System.out.println("Hotels in 'New Delhi': ");
        List<Hotel> delhiHotels = hotelService.searchHotelsByLocation("New Delhi");
        for (Hotel h : delhiHotels) {
            System.out.println(h);
        }

        // Book a room
        Booking booking = bookingService.createBooking(guest, "H001", "R101", new Date(), new Date());
        System.out.println("Booking created: " + booking);
    }
}
