package homework_2;

public class ServiceStation {

    public void check(Car car) {
        if (car != null) {
            System.out.println("\nОбслуживаем " + car.getModelName());
            for (int i = 0; i < car.getWheelsCount(); i++) {
                car.updateTyre();
            }
            car.checkEngine();
        }
    }

    public void check(Bicycle bicycle) {
        if (bicycle != null) {
            System.out.println("\nОбслуживаем " + bicycle.getModelName());
            for (int i = 0; i < bicycle.getWheelsCount(); i++) {
                bicycle.updateTyre();
            }
        }
    }

    public void check(Truck truck) {
        if (truck != null) {
            System.out.println("\nОбслуживаем " + truck.getModelName());
            for (int i = 0; i < truck.getWheelsCount(); i++) {
                truck.updateTyre();
            }
            truck.checkEngine();
            truck.checkTrailer();
        }
    }
}
