package homework_2;

public class ServiceStation {
    public void check(Bicycle bicycle) {
        checkWheels(bicycle);
    }

    public void check(Car car) {
        checkWheels(car);
        checkEngine(car);
    }

    public void check(Truck truck) {
        checkWheels(truck);
        checkEngine(truck);
        checkTruck(truck);
    }

    public void checkWheels(Vehicle vehicle) {
        if (vehicle != null) {
            System.out.println("\nОбслуживаем " + vehicle.getModelName());
            for (int i = 0; i < vehicle.getWheelsCount(); i++) {
                vehicle.updateTyre();
            }
        }
    }
    public void checkEngine(Engineable engineable) {
        engineable.checkEngine();
    }

    public void checkTruck(Trailerable trailerable) {
        trailerable.checkTrailer();
    }
}
