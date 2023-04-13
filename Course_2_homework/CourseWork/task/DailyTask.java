package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DailyTask extends Task {
    public DailyTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public List<LocalDateTime> generateCalendar(LocalDateTime localDateTime) {
        List<LocalDateTime> result = new ArrayList<>();
        localDateTime = LocalDateTime.of(LocalDate.of(localDateTime.getYear(), 1, 1),
                localDateTime.toLocalTime());
        for (int i = 0; i < 365; i++) {
            result.add(localDateTime);
            localDateTime = localDateTime.plusDays(1);
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "ежедневная";
    }
}
