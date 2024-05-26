package model;

import java.util.UUID;

public class Rider {
    String riderId;
    String riderName;

    public Rider(String riderName) {
        this.riderId = UUID.randomUUID().toString();
        this.riderName = riderName;
    }

    public String getRiderId() {
        return riderId;
    }

    public String getRiderName() {
        return riderName;
    }

}
