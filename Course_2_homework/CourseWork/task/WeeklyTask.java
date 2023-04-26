package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDate;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfWeek().equals(LocalDate.now().getDayOfWeek());
    }

    @Override
    public String toString() {
        return super.toString() + "еженедельная";
    }
}
