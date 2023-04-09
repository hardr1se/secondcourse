package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDateTime;
import java.util.List;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public void appearsIn() {
        List<Task> removeTask = taskService.getTaskMap().get(3).stream()
                .filter(x -> x.getLocalDateTime().isBefore(LocalDateTime.now()))
                .toList();
        taskService.correctTasks(3, removeTask);
    }

    @Override
    public String toString() {
        return super.toString() + "еженедельная";
    }
}
