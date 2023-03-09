package homework_2;

public class Car extends Vehicle implements CheckEngine {
    @Override
    void service() {
        checkEngine();
    }
}
