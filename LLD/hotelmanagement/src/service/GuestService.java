package service;

import model.Guest;
import repository.GuestRepository;

import java.util.Optional;

public class GuestService {
    private GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Optional<Guest> findGuestById(String guestId) {
        return guestRepository.findById(guestId);
    }

    public void saveGuest(Guest guest) {
        guestRepository.save(guest);
    }
}
