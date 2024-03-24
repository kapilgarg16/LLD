
#include<bits/stdc++.h>
using namespace std;
#include "VehicleInventory.h"
    
void addVehicle(Vehicle vehicle){
    vehicleList.add(vehicle);
}

list<Vehicle> getVehicleList(){
    return vehicleList;
}

void deleteVehicle(int id){
    list<Vehicle>::iterator it;
    for(it = vehicleList.begin() ; it!= vehicleList.end() ; ++it){
        if(it->id == id){
            vehicleList.erase(it);
            break;
        }
    }
}
    
    
    
    
}