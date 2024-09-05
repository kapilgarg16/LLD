//factory

// Step 1: Create an interface for Vehicle
interface Vehicle {
    void drive();
}

// Step 2: Create concrete classes implementing the Vehicle interface
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a car");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Riding a bike");
    }
}

class Truck implements Vehicle {
    public void drive() {
        System.out.println("Driving a truck");
    }
}

// Step 3: Create a factory to generate objects of Vehicle type
class VehicleFactory {
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        if (vehicleType.equalsIgnoreCase("CAR")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("BIKE")) {
            return new Bike();
        } else if (vehicleType.equalsIgnoreCase("TRUCK")) {
            return new Truck();
        }
        return null;
    }
}

// Step 4: Use the factory to get the object of a specific type
public class FactoryPatternDemo {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        // Get a Car object and call its drive method
        Vehicle vehicle1 = vehicleFactory.getVehicle("CAR");
        vehicle1.drive();

        // Get a Bike object and call its drive method
        Vehicle vehicle2 = vehicleFactory.getVehicle("BIKE");
        vehicle2.drive();

        // Get a Truck object and call its drive method
        Vehicle vehicle3 = vehicleFactory.getVehicle("TRUCK");
        vehicle3.drive();
    }
}


//abstract factory
// Step 1: Create interfaces for Vehicle and VehicleFactory
interface Vehicle {
    void drive();
}

interface VehicleFactory {
    Vehicle createVehicle();
}

// Step 2: Create concrete classes implementing the Vehicle interface
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a car");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Riding a bike");
    }
}

// Step 3: Create concrete factories implementing the VehicleFactory interface
class CarFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Bike();
    }
}

// Step 4: Create a FactoryProducer class to generate the factories
class FactoryProducer {
    public static VehicleFactory getFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("CAR")) {
            return new CarFactory();
        } else if (factoryType.equalsIgnoreCase("BIKE")) {
            return new BikeFactory();
        }
        return null;
    }
}

// Step 5: Use the FactoryProducer to get the factory and create the objects
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // Get a CarFactory and create a Car object
        VehicleFactory carFactory = FactoryProducer.getFactory("CAR");
        Vehicle vehicle1 = carFactory.createVehicle();
        vehicle1.drive();

        // Get a BikeFactory and create a Bike object
        VehicleFactory bikeFactory = FactoryProducer.getFactory("BIKE");
        Vehicle vehicle2 = bikeFactory.createVehicle();
        vehicle2.drive();
    }
}
