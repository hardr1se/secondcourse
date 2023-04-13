package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class YearlyTask extends Task {

    public YearlyTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public List<LocalDateTime> generateCalendar(LocalDateTime localDateTime) {
        return new ArrayList<>(List.of(localDateTime));
    }

    @Override
    public String toString() {
        return super.toString() + "ежегодная";
    }
}
