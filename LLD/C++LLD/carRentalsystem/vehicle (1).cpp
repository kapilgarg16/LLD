#ifndef VEHICLE_H
#define VEHICLE_H

#include "Status.h"
#include "VehicleType.h"
#include <bits/stdc++.h>
using namespace std;

class Vehicle
{
    public:
    int vehicleID;
    string color;
    Status status;
    VehicleType vehicleType;
    string vehicleNumber;
    int kmDriven;
    int average;
    int cc;
    int model;

    void setVehicleID(int id);
    int getVehicleID();
    
    void setVehicleNumber(string no);
    string getVehicleNumber();
    
    void setStatus(Status status);
    Status getStatus();
    
};
#endif