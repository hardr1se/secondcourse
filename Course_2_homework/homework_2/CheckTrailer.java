package homework_2;

public interface CheckTrailer {
    default void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }
}
