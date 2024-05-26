package Repository;
import model.Cab;
import model.ErrorCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exception.OlaException;
import model.Location;

public class CabRepository {
    HashMap<String, Cab> cabs;

    public CabRepository(){
        cabs = new HashMap<>();
    }

    public String addCab(Cab cab) throws OlaException {
        if(cabs.get(cab.getCabId()) != null){
            throw new OlaException(ErrorCode.Cab_already_exist, "don't add");
        }
        cabs.put(cab.getCabId(), cab);
        return cab.getCabId();
    }

    public Cab getCab(String cabId) throws OlaException {
        if(cabs.get(cabId) == null){
            throw new OlaException(ErrorCode.Rider_does_not_exist, "Rider_does_not_exist");
        }
        return cabs.get(cabId);
    }

    public List<Cab> getAvailableCabs(Location riderSrcLocation, int max_dist){
        List<Cab>availAbleCabs = new ArrayList<>();
        //requesting a cab
        for(String cabId : cabs.keySet()){
            Cab cab = getCab(cabId);
            Location cabLocation = cab.getLocation();
            //checking distance between cabs
            int distance =  riderSrcLocation.getDistance(cabLocation);
            if(distance <= max_dist && !cab.getTripOnline()){
                availAbleCabs.add(cab);
            }
        }
        return availAbleCabs;
    }

}
