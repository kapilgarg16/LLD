package Entities;

public class TheatreLocation {
    int pincode;
    String address;

    public TheatreLocation(int pincode, String address) {
        this.pincode = pincode;
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
