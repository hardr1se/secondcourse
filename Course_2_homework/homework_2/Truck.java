package homework_2;

public class Truck extends MotorVehicle {
    public void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }

    @Override
    public void service() {
        checkEngine();
        checkTrailer();
    }
}
