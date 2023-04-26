package CourseWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private final TaskService taskService = new TaskService();

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    JMenuItem printTasksOnDay;
    JMenuItem printTodayTasks;
    JMenuItem addTask;
    JMenuItem removeTask;
    JMenuItem refreshTasks;
    JMenuItem refreshOneTimeTasks;
    JMenuItem refreshDailyTasks;
    JMenuItem refreshWeeklyTasks;
    JMenuItem refreshMonthlyTasks;
    JMenuItem refreshYearlyTasks;
    JMenuItem printAll;
    JMenuItem exitMenu;
    Menu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar();
        fileMenu = new JMenu("Datebook");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        printTasksOnDay = new JMenuItem("Today tasks");
        printTodayTasks = new JMenuItem("Other day tasks");
        addTask = new JMenuItem("Add");
        removeTask = new JMenuItem("Delete");
        refreshTasks = new JMenuItem("Refresh");
        printAll = new JMenuItem("Print all");
        exitMenu = new JMenuItem("Exit");

        refreshOneTimeTasks = new JMenuItem("One time");
        refreshDailyTasks = new JMenuItem("Daily");
        refreshWeeklyTasks = new JMenuItem("Weekly");
        refreshMonthlyTasks = new JMenuItem("Monthly");
        refreshYearlyTasks = new JMenuItem("Yearly");

        fileMenu.add(printAll);
        fileMenu.add(printTasksOnDay);
        fileMenu.add(printTodayTasks);
        editMenu.add(addTask);
        editMenu.add(removeTask);
        editMenu.add(refreshTasks);

        printTasksOnDay.addActionListener(this);
        printTodayTasks.addActionListener(this);
        addTask.addActionListener(this);
        removeTask.addActionListener(this);
        refreshTasks.addActionListener(this);
        printAll.addActionListener(this);
        exitMenu.addActionListener(this);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        menuBar.add(exitMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == printTodayTasks) {
            taskService.printTodayPlans();
        } else if (actionEvent.getSource() == printTasksOnDay) {
            taskService.getAllByDate();
        } else if (actionEvent.getSource() == addTask) {
            taskService.addTask();
        } else if (actionEvent.getSource() == removeTask) {
            taskService.remove();
        } else if (actionEvent.getSource() == printAll) {
            taskService.printAll();
        } else if (actionEvent.getSource() == exitMenu) {
            System.exit(0);
        }
    }
}
