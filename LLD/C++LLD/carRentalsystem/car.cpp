#ifndef CAR_H
#define CAR_H

#include "Vehicle.h"

class Car : public Vehicle{
    public:
    int seatNo;
    
    void setSeatNo(int setNo);
    int getSeatNo();
    
};

#endif