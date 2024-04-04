package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList = new ArrayList<>();
    List<User> users = new ArrayList<>();

    public Store getStoreBasedOnLocation(Location location){
        return storeList.get(0);
    }
    public void addStore(Store s){
        storeList.add(s);
    }
}

//create 4 vehicle ---> v1, v2, v3, v4;
//  s1 = Store(1, location1)
//  s2 = Store(2, locatoin2)

//s1.addvehicle(v1), s1.addvehicle(v2)
//s2.addvehicle(v1), s2.addvehicle(v2)

// User --> location

//VehicleRentalSystem (location)

//store (user)

// user --> create reservation (add the resevation)

// use

