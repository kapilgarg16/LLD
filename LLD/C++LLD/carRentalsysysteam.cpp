#include<bits/stdc++.h>
using namespace std;

//---------------------------------
enum class Status {
    Active,
    Inactive
};
//---------------------------------
enum class VehicleType {
    Bike,
    Car
};
//--------------------------------------

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

int Vehicle::getVehicleID(){
    return vehicleID;
} 
void Vehicle::setVehicleID(int id){
        vehicleID = id;
}
void Vehicle :: setVehicleNumber(string no){
    vehicleNumber = no;
}
string Vehicle :: getVehicleNumber(){
    return vehicleNumber;
}
void Vehicle :: setStatus(Status status){
    this->status = status;
}
Status Vehicle :: getStatus(){
    return status;
}

//----------------------------------------

class Car : public Vehicle{
    public:
    int seatNo;
    
    void setSeatNo(int setNo);
    int getSeatNo();
    
};

class Bike : public Vehicle{
    
};

//------------------------------------------
class Location {
    
    public:
    string address;
    int pinCode;
    
    public:
    Location(){
        address = "";
        pinCode = 0;
    }
    Location(string address, int pinCode);
};

Location :: Location(string address, int pinCode){
    this->address = address;
    this->pinCode = pinCode;
}

//-------------------------------------

class VehicleInventory {
    
    public:
    list<Vehicle> vehicleList;
    
    void addVehicle(Vehicle &vehicle);
    list<Vehicle> getVehicleList();
    void deleteVehicle(int id);
    
};

void VehicleInventory :: addVehicle(Vehicle &vehicle){
    vehicleList.push_back(vehicle);
}

list<Vehicle> VehicleInventory ::  getVehicleList(){
    return vehicleList;
}

void VehicleInventory :: deleteVehicle(int id){
    list<Vehicle>::iterator it;
    for(it = vehicleList.begin() ; it!= vehicleList.end() ; ++it){
        if(it->vehicleID == id){
            vehicleList.erase(it);
            break;
        }
    }
}
//------------------------------

class Store{
    public:
    int storeId;
    VehicleInventory inventory;
    Location location;

    public:
    Store(int , Location);
    void setVehicleInInventory(Vehicle &);
    list<Vehicle> getVehicleList();
};

Store :: Store(int storeId, Location location){
    this->storeId = storeId;
    this->location = location;
    // inventory = new VehicleInventory;
}

void Store :: setVehicleInInventory(Vehicle &vehicle){
        inventory.addVehicle(vehicle);
    }

list<Vehicle> Store :: getVehicleList(){
    list<Vehicle> vehicleList = inventory.getVehicleList();
    return vehicleList;
}

int main(){
    //vehicle1;
    Vehicle v1, v2;

    v1.setVehicleID(1);
    v1.setVehicleNumber("1234");
    v1.setStatus(Status::Active);

    v2.setVehicleID(2);
    v2.setVehicleNumber("5678");
    v2.setStatus(Status::Active);

    // sett
    // Location sl1("xyz", 328022);
    Store s1(12, {"xyz", 328022}), s2(13, {"pqr", 302050});
    // cout << s1.location.address << s1.location.pinCode << endl;
    s1.setVehicleInInventory(v1);
    s1.setVehicleInInventory(v2);

    s2.setVehicleInInventory(v2);
    s2.setVehicleInInventory(v1);

    list<Vehicle> vl1 = s1.getVehicleList();
    list<Vehicle>::iterator it = vl1.begin();

    cout << it->vehicleID << " " << it->vehicleNumber;


    


}
