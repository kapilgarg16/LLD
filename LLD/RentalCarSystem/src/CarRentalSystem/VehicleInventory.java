package CarRentalSystem;
import CarRentalSystem.Product.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {
    List<Vehicle> vehicleList = new ArrayList<>();;

//    public VehicleInventory(List<Vehicle> vehicleList){
//        this.vehicleList = vehicleList;
//    }
//    public void setVehicleList(List<Vehicle> vehicleList) {
//        this.vehicleList = vehicleList;
//    }
    public void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }
    public void deleteVehicle(int vehicleID){
        for(int i  = 0 ; i < vehicleList.size() ; i++){
            if((vehicleList.get(i)).vehicleID == vehicleID){
                vehicleList.remove(vehicleList.get(i));
            }
        }
    }
    public List<Vehicle> getVehicleList(){
        return vehicleList;
    }
}
