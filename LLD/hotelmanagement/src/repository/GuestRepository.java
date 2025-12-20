package repository;

import model.Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuestRepository {
    private List<Guest> guests = new ArrayList<>();

    public Optional<Guest> findById(String guestId) {
        return guests.stream()
                .filter(guest -> guest.getGuestId().equals(guestId))
                .findFirst();
    }

    public void save(Guest guest) {
        guests.add(guest);
    }
}
