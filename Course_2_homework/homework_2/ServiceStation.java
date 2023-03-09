package homework_2;

public class ServiceStation {

    public void check(Vehicle vehicle) {
        if (vehicle != null) {
            System.out.println("\nОбслуживаем " + vehicle.getModelName());
            for (int i = 0; i < vehicle.getWheelsCount(); i++) {
                vehicle.updateTyre();
            }
            vehicle.service();
        }
    }
}
