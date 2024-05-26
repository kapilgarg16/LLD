package model;

import java.util.UUID;

public class Trip {
    String tripId;
    String riderId;
    Location srcLocation;
    Location destLocation;
    TripStatus tripStatus;

    public Trip(String riderId, Location srcLocation, Location destLocation) {
        this.tripId = UUID.randomUUID().toString();
        this.riderId = riderId;
        this.srcLocation = srcLocation;
        this.destLocation = destLocation;
        this.tripStatus = TripStatus.TRYING;
    }

    public String getTripId() {
        return tripId;
    }

    public String getRiderId() {
        return riderId;
    }

    public Location getSrcLocation() {
        return srcLocation;
    }

    public void setSrcLocation(Location srcLocation) {
        this.srcLocation = srcLocation;
    }

    public Location getDestLocation() {
        return destLocation;
    }

    public void setDestLocation(Location destLocation) {
        this.destLocation = destLocation;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }
}
