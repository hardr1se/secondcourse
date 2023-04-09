package CourseWork.task;

import CourseWork.Task;
import CourseWork.Type;

import java.time.LocalDateTime;
import java.util.List;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, String description, Type type) {
        super(title, description, type);
    }

    @Override
    public void appearsIn() {
        List<Task> removeTask = taskService.getTaskMap().get(1).stream()
                .filter(x -> x.getLocalDateTime().isBefore(LocalDateTime.now()))
                .toList();
        taskService.correctTasks(1, removeTask);
    }

    @Override
    public String toString() {
        return super.toString() + "одноразовая";
    }
}
