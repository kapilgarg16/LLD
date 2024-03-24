#ifndef STORE_H
#define STORE_H

#include<bits/stdc++.h>
using namespace std;
#include "VehicleInventory.h"
#include "Location.h"

class Store{
    public:
    int storeId;
    VehicleInventory *inventory;
    Location location;
    
    
    Store(int , Location );
    void setVehicleInInventory(Vehicle);
    list<Vehicle> getVehicleList();
};


#endif