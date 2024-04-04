package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Store {
    VehicleInventory vehicleInventory;
    Location location;
    int id;
    List<VehicleReservation> vehicleReservation = new ArrayList<>();

    public Store(int id, Location location){
        vehicleInventory = new VehicleInventory();
        this.id = id;
        this.location = location;
    }
    public void setVehicleInventory(Vehicle vehicle){
        vehicleInventory.addVehicle(vehicle);
    }

    public List<Vehicle> getVehicleList(){
        return vehicleInventory.getVehicleList();
    }

    public VehicleReservation createReservation(Vehicle vehicle, User user){
        VehicleReservation reservation = new VehicleReservation();
        reservation.createReserve(user,vehicle);
        vehicleReservation.add(reservation);
        return reservation;
    }


//    public void setLocation(Location location) {
//        this.location = location;
//    }
//    public Location getLocation(){
//        return location;
//    }
//
//    public void setId(int id){
//        this.id = id;
//    }
//    public int getId(){
//        return id;
//    }
}
