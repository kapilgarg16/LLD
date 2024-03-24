#ifndef VEHICLEINVENTORY_H
#define VEHICLEINVENTORY_H

#include<list>
#include "Vehicle.h"

class VehicleInventory {
    
    public:
    list<Vehicle> vehicleList;
    
    void addVehicle(Vehicle vehicle);
    list<Vehicle> getVehicleList();
    void deleteVehicle(int id);
    
};


#endif