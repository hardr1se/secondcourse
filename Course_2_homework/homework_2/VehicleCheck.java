package homework_2;

interface VehicleCheck {
    default void updateTyre() {
        System.out.println("Для данного вида транспорта это действие не предусмотрено");
    }

    default void checkEngine() {
        System.out.println("Для данного вида транспорта это действие не предусмотрено");
    }

    default void checkTrailer() {
        System.out.println("Для данного вида транспорта это действие не предусмотрено");
    }
}
