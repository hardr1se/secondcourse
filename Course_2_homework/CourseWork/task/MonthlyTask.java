package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDate;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == LocalDate.now().getDayOfMonth();
    }

    @Override
    public String toString() {
        return super.toString() + "ежемесячная";
    }
}
