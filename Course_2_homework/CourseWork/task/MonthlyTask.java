package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public List<LocalDateTime> generateCalendar(LocalDateTime localDateTime) {
        List<LocalDateTime> result = new ArrayList<>();
        LocalDate counter = LocalDate.of(localDateTime.getYear(), 1, localDateTime.getDayOfMonth());
        for (int i = 1; i <= 12; i++) {
            result.add(LocalDateTime.of(counter, localDateTime.toLocalTime()));
            counter = counter.plusMonths(1);
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "ежемесячная";
    }
}
