package CarRentalSystem;

public class User {
    String name;
    String drivingLicenseNumber;
    int age;
    String homeAddress;

    public User(String name, int age, String drivingLicenseNumber, String homeAddress){
        this.name = name;
        this.age = age;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.homeAddress = homeAddress;
    }


}
