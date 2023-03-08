package homework_2;

interface CheckEngine {
    default void checkEngine() {
        System.out.println("Проверяем двигатель");
    }
}

interface CheckTrailer {
    default void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }
}

