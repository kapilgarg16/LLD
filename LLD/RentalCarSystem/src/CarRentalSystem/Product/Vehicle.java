package CarRentalSystem.Product;
import java.util.Date;
public class Vehicle {
    public int vehicleID;
    public String model;
    public String vehicleNumber;
    public String companyName;
    public int cc;
    public int kmDriven;
    public Date mnfDate;
    public int average;
    public int dailyRentalCost;
    public int hourlyRentalCost;
    public int noOfSeat;
    public Status status;
    public VehicleType vehicleType;


    public int getVehicleID() {
        return vehicleID;
    }
    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getModelName() {
        return model;
    }
    public void setModelName(String modelName) {
        this.model = modelName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getKmDriven() {
        return kmDriven;
    }
    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public Date getManufacturingDate() {
        return mnfDate;
    }
    public void setManufacturingDate(Date mnfDate) {
        this.mnfDate = mnfDate;
    }

    public int getAverage() {
        return average;
    }
    public void setAverage(int average) {
        this.average = average;
    }

    public int getDailyRentalCost() {
        return dailyRentalCost;
    }
    public void setDailyRentalCost(int dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public int getHourlyRentalCost() {
        return hourlyRentalCost;
    }
    public void setHourlyRentalCost(int hourlyRentalCost) {
        this.hourlyRentalCost = hourlyRentalCost;
    }

    public int getNoOfSeat() {
        return noOfSeat;
    }
    public void setNoOfSeat(int noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }

}
