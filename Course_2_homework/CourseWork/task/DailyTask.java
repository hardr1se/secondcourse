package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDate;

public class DailyTask extends Task {
    public DailyTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "ежедневная";
    }
}
