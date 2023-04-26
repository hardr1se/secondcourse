package CourseWork;

import CourseWork.exceptions.IncorrectArgumentException;
import CourseWork.exceptions.TaskNotFoundException;
import CourseWork.task.*;

import java.time.LocalDate;
import java.util.*;

import static CourseWork.Type.PERSONAL;
import static CourseWork.Type.WORK;

public class TaskService {
    private final Map<Integer, List<Task>> taskMap = new HashMap<>(Map.of(
            1, new ArrayList<>(List.of(
                    new OneTimeTask("Напечатать отчет", "Нужно написать отчет о продажах за месяц и отнести начальнику",
                            WORK),
                    new OneTimeTask("Выгулять собаку", "Нужно выгулять собаку до 18:00, иначе ей становится плохо",
                            PERSONAL))),
            2, new ArrayList<>(List.of(
                    new DailyTask("Визит домой", "Нужно навестить всех родных дома",
                            PERSONAL))),
            3, new ArrayList<>(List.of(
                    new WeeklyTask("Подготовить отчет", "Нужно написать маленький отчет о исправности приложения",
                            WORK))),
            4, new ArrayList<>(List.of(
                    new MonthlyTask("Доделать приложение", "Дописать код приложения и подготовить маленькое представление для него",
                            WORK))),
            5, new ArrayList<>(List.of(
                    new YearlyTask("Купить покушать", "Купить яйца, хлеб, молоко и йогурт",
                            PERSONAL)))
    ));

    public void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите заголовок задачи");
        String title = scanner.nextLine();
        System.out.println("Введите описание задачи");
        String description = scanner.nextLine();
        CourseWork.Type typeOfTask = null;
        System.out.println("""
                Введите какой тип задачи
                1 - личная
                2 - рабочая""");
        int type = scanner.nextInt();
        if (type == 1) typeOfTask = CourseWork.Type.PERSONAL;
        else if (type == 2) typeOfTask = CourseWork.Type.WORK;
        System.out.println("""
                Введите какая повторяемость задачи:
                1 - однократная,
                2 - ежедневная,
                3 - еженедельная,
                4 - ежемесячная,
                5 - ежегодная""");
        int repeatability = scanner.nextInt();
        Task task;
        switch (repeatability) {
            case 1 -> task = new OneTimeTask(title, description, typeOfTask);
            case 2 -> task = new DailyTask(title, description, typeOfTask);
            case 3 -> task = new WeeklyTask(title, description, typeOfTask);
            case 4 -> task = new MonthlyTask(title, description, typeOfTask);
            case 5 -> task = new YearlyTask(title, description, typeOfTask);
            default -> throw new IncorrectArgumentException("Не верно введено значение");
        }
        if (task.getClass().equals(OneTimeTask.class)) {
            taskMap.get(1).add(task);
        } else if (task.getClass().equals(DailyTask.class)) {
            taskMap.get(2).add(task);
        } else if (task.getClass().equals(WeeklyTask.class)) {
            taskMap.get(3).add(task);
        } else if (task.getClass().equals(MonthlyTask.class)) {
            taskMap.get(4).add(task);
        } else if (task.getClass().equals(YearlyTask.class)) {
            taskMap.get(5).add(task);
        } else {
            throw new TaskNotFoundException("Не корректный объект направлен в метод");
        }
    }

    public void printTodayPlans() {
        List<Task> todayPlan = new ArrayList<>();
        taskMap.values().stream()
                .flatMap(List::stream)
                .toList()
                .forEach(task -> {
                    if (task.appearsIn(task.getLocalDate())) {
                        todayPlan.add(task);
                    }
                });
        todayPlan.stream()
                .sorted(Comparator.comparing(Task::getLocalDateTime))
                .forEach(System.out::println);
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Какой повторяемости задачу вы хотите удалить:
                1 - однократную
                2 - ежедневную
                3 - еженедельную
                4 - ежемесячную
                5 - ежегодную
                ---------------------------------------------
                Введите число: 
                """);
        int choice1 = scanner.nextInt();
        if (choice1 > 5 || choice1 < 1) {
            throw new TaskNotFoundException("Ввели не корректное число");
        } else {
            taskMap.get(choice1).forEach(System.out::println);
        }
        System.out.println("""
                Напишите id задачи которую вы хотите удалить:  
                """);
        int choice2 = scanner.nextInt();
        try {
            taskMap.get(choice1).removeIf(x -> x.getId() == choice2);
            System.out.println("Задача удалена");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверный индекс");
            remove();
        }
    }

    public void getAllByDate() {
        System.out.println("Введите дату на которую хотите получить задания, например 06.04.2023");
        Scanner scanner = new Scanner(System.in);
        String check = scanner.nextLine();
        String[] checkArr = check.split("\\.");
        if (checkArr.length != 3) {
            throw new IncorrectArgumentException("Неприльно введено значение даты");
        }
        LocalDate localDate = LocalDate.of(Integer.parseInt(checkArr[2]), Integer.parseInt(checkArr[1]), Integer.parseInt(checkArr[0]));
        List<Task> result = new ArrayList<>();
        taskMap.values().stream()
                .flatMap(List::stream)
                .toList()
                .forEach(task -> {
                    if (task.appearsIn(localDate)) {
                        result.add(task);
                    }
                });
        if (result.isEmpty()) {
            System.out.println("Сегодня у вас свободный день");
        } else {
            result.stream()
                    .sorted(Comparator.comparing(Task::getLocalDateTime))
                    .forEach(System.out::println);
        }
    }

    public void printAll() {
        for (List<Task> arr : taskMap.values()) {
            arr.forEach(System.out::println);
        }
    }
}
