package model;

import jdk.jshell.execution.Util;

import java.util.UUID;

public class Cab {
    String cabId;
    String cabNo;
    boolean isTripOnline;
    Location location;
    Double rating;
    Trip presentTrip;


    public Cab(String cabNo, Location location, Double rating) {
        this.cabId = UUID.randomUUID().toString();
        this.cabNo = cabNo;
        this.isTripOnline = false;
        this.location = location;
        this.rating = rating;
        this.presentTrip = null;
    }

    public String getCabId() {
        return cabId;
    }

    public String getCabNo() {
        return cabNo;
    }

    public void setCabNo(String cabNo) {
        this.cabNo = cabNo;
    }

    public boolean getTripOnline() {
        return isTripOnline;
    }

    public void setTripOnline(boolean tripOnline) {
        isTripOnline = tripOnline;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Trip getPresentTrip() {
        return presentTrip;
    }

    public void setPresentTrip(Trip presentTrip) {
        this.presentTrip = presentTrip;
    }
}
