package homework_2;

public class ServiceStation {

    public void check(Vehicle vehicle) {
        Car car = new Car(null, 0);
        Truck truck = new Truck(null, 0);
        if (vehicle != null) {
            System.out.println("\nОбслуживаем " + vehicle.getModelName());
            for (int i = 0; i < vehicle.getWheelsCount(); i++) {
                vehicle.updateTyre();
            }
            if (vehicle.getClass() == car.getClass()) {
                car.checkEngine();
            } else if (vehicle.getClass() == truck.getClass()) {
                truck.checkEngine();
                truck.checkTrailer();
            }
        }
    }
}
