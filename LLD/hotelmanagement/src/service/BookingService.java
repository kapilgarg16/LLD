package service;

import model.*;
import repository.BookingRepository;
import repository.HotelRepository;

import java.util.Date;

public class BookingService {
    private BookingRepository bookingRepository;
    private HotelRepository hotelRepository;

    public BookingService(BookingRepository bookingRepository, HotelRepository hotelRepository) {
        this.bookingRepository = bookingRepository;
        this.hotelRepository = hotelRepository;
    }

    public Booking createBooking(Guest guest, String hotelId, String roomId, Date checkInDate, Date checkOutDate) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        Room room = hotel.getAvailableRooms("").stream()
                .filter(r -> r.getRoomId().equals(roomId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Room not available"));

        room.setAvailable(false); // Mark room as booked
        Booking booking = new Booking("B" + System.currentTimeMillis(), guest, hotel, room, checkInDate, checkOutDate);
        bookingRepository.save(booking);
        return booking;
    }
}
