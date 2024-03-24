#include<bits/stdc++.h>
using namespace std;


#include "VehicleInventory.h"
#include "Store.h"
#include "Location.h"


Store :: Store(int storeId, Location location){
    this->storeId = storeId;
    this->location = location;
    inventory = new VehicleInventory;
}

void Store :: setVehicleInInventory(Vehicle vehicle){
        inventory->addVehicle(vehicle);
    }

list<Vehicle> Store :: getVehicleList(){
    list<Vehicle> vehicleList = inventory->getVehicleList();
    return vehicleList;
}

    
    
    
    
    
