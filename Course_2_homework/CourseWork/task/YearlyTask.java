package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDate;

public class YearlyTask extends Task {

    public YearlyTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == LocalDate.now().getDayOfMonth()
                && localDate.getMonthValue() == LocalDate.now().getMonthValue();
    }

    @Override
    public String toString() {
        return super.toString() + "ежегодная";
    }
}
