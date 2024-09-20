
package factorypatterndemo;

/**
 *
 * @author sanja
 */
interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car...");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike...");
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equals("Car")) {
            return new Car();
        } else if (type.equals("Bike")) {
            return new Bike();
        }
        return null;
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("Car");
        car.drive();

        Vehicle bike = VehicleFactory.createVehicle("Bike");
        bike.drive();
    }
}
