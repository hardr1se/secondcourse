package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDate;

public class OneTimeTask extends Task{

    public OneTimeTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(LocalDate.now());
    }

    @Override
    public String toString() {
        return super.toString() + "одноразовая";
    }
}
