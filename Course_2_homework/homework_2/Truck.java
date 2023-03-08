package homework_2;

public class Truck extends Vehicle implements CheckEngine, CheckTrailer {

    public Truck(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }
}
