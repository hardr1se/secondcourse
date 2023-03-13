package homework_2;

public interface CheckEngine {
    default void checkEngine() {
        System.out.println("Проверяем двигатель");
    }
}
