package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, String description, Type type) {
        super(title, description, type);

    }

    @Override
    public List<LocalDateTime> generateCalendar(LocalDateTime localDateTime) {
        List<LocalDateTime> result = new ArrayList<>();
        Calendar date = Calendar.getInstance();
        date.set(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
        final int dateOfWeek = date.get(Calendar.DAY_OF_WEEK);
        for (int j = 1; j <= 12; j++) {
            date.set(Calendar.MONTH, j);
            for (int i = 1; i <= checkDayByMonth(date.get(Calendar.MONTH)); i++) {
                date.set(Calendar.DAY_OF_MONTH, i);
                if (date.get(Calendar.DAY_OF_WEEK) == dateOfWeek) {
                    LocalDate localDate = LocalDate.of(date.get(Calendar.YEAR), j, date.get(Calendar.DAY_OF_MONTH));
                    result.add(LocalDateTime.of(localDate, localDateTime.toLocalTime()));
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "еженедельная";
    }
}
