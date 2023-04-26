package CourseWork;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Task {
    private final Random random = new Random();
    private static int idGenerator = 1;
    private String title;
    private final Type type;
    private int id;
    private LocalDateTime localDateTime;
    private String description;

    public Task(String title, String description, Type type) {
        this.title = title;
        this.type = type;
        this.id = idGenerator++;
        this.localDateTime = generateRandomDate();
        this.description = description;
    }

    public abstract boolean appearsIn(LocalDate localDate);

    private LocalDateTime generateRandomDate() {
        int month = ThreadLocalRandom.current().nextInt(LocalDate.now().getMonthValue(), 13);
        int day;
        switch (month) {
            case 2 -> day = ThreadLocalRandom.current().nextInt(1, 28);
            case 4, 6, 9, 11 -> day = ThreadLocalRandom.current().nextInt(1, 30);
            default -> day = ThreadLocalRandom.current().nextInt(1, 31);
        }
        return LocalDateTime.of(LocalDate.now().getYear(),
                month, day, ThreadLocalRandom.current().nextInt(1, 24),
                ThreadLocalRandom.current().nextInt(1, 60));
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(random, task.random) && Objects.equals(title, task.title) && type == task.type && Objects.equals(localDateTime, task.localDateTime) && Objects.equals(description, task.description);
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public LocalDate getLocalDate() {
        return localDateTime.toLocalDate();
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, localDateTime, description);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "id - " + getId() + ", дата - " + getLocalDateTime() +
                "\nТема: " + getTitle() +
                "\nОписание: " + getDescription() +
                "\nТип задачи: " + getType().getValues() + ", повторяемость: ";
    }
}
