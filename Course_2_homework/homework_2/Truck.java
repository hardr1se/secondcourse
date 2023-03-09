package homework_2;

public class Truck extends Vehicle implements CheckTrailer, CheckEngine {

    @Override
    void service() {
        checkEngine();
        checkTrailer();
    }
}
