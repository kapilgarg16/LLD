package Repository;

import exception.OlaException;
import model.ErrorCode;
import model.Rider;

import java.util.HashMap;

public class RiderRepository {
    HashMap<String, Rider> riders;
    public RiderRepository(){
        this.riders = new HashMap<>();
    }

    //add rider;
    public String addRider(Rider rider) throws OlaException {
        if(riders.get(rider.getRiderId()) != null){
            throw new OlaException(ErrorCode.Rider_already_exist, "don't add");
        }
        riders.put(rider.getRiderId(), rider);
        return rider.getRiderId();
    }

    public Rider getRider(String riderId) throws OlaException{
        if(riders.get(riderId) == null){
            throw new OlaException(ErrorCode.Rider_does_not_exist, "Rider_does_not_exist");
        }
        return riders.get(riderId);
    }
}
