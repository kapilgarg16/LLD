package repository;

import model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelRepository {
    private List<Hotel> hotels = new ArrayList<>();

    public List<Hotel> findAll() {
        return hotels;
    }

    public Optional<Hotel> findById(String hotelId) {
        return hotels.stream()
                .filter(hotel -> hotel.getHotelId().equals(hotelId))
                .findFirst();
    }

    public List<Hotel> findByLocation(String location) {
        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getLocation().equalsIgnoreCase(location)) {
                result.add(hotel);
            }
        }
        return result;
    }

    public void save(Hotel hotel) {
        hotels.add(hotel);
    }
}
