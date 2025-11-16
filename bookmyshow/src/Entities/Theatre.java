package Entities;

import Enums.TheatreType;

import java.util.List;

public class Theatre {
    int id;
    List<Show> show;
    List<Screen> screens;
    TheatreLocation theatreLocation;
    TheatreType theatreType;

    public int getId() {
        return id;
    }

    public TheatreLocation getTheatreLocation() {
        return theatreLocation;
    }

    public void setTheatreLocation(TheatreLocation theatreLocation) {
        this.theatreLocation = theatreLocation;
    }

    public TheatreType getTheatreType() {
        return theatreType;
    }

    public void setTheatreType(TheatreType theatreType) {
        this.theatreType = theatreType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Show> getShow() {
        return show;
    }

    public void setShow(List<Show> show) {
        this.show = show;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

}
