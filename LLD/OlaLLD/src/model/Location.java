package model;

import static java.lang.Math.abs;

public class Location {
    int src;
    int dest;

    public Location(int src, int dest){
        this.src = src;
        this.dest = dest;
    }

    public int getDistance(Location location){
        int distance = abs(location.dest - dest) * abs(location.dest - dest) + abs(location.src - src)*abs(location.src - src);
        distance = (int)Math.sqrt(distance);
        return distance;
    }
}
