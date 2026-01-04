package Entities;

import java.util.List;

public class Screen {
    int id;
    List<Seats>seatsList;

    public Screen(int id, List<Seats> seatsList) {
        this.id = id;
        this.seatsList = seatsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seats> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seats> seatsList) {
        this.seatsList = seatsList;
    }
}
