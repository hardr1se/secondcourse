package pro.sky.employee;

import java.util.Random;

public class Employee {

    private static int idCalculator = 1;
    private Random random = new Random();

    private int id;
    private String fullName;
    private int division;
    private int salary;

    public Employee() {
        this.id = idCalculator++;
        this.fullName = generateFullName();
        this.division = random.nextInt(1, 6);
        this.salary = random.nextInt(60_000, 80_000);
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDivision() {
        return division;
    }

    public int getSalary() {
        return salary;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private String generateFullName() {
        String[] surname = {"Красноперов", "Костин", "Терешев", "Петрушин", "Воронихин"};
        String[] name = {"Петр", "Василий", "Маским", "Виталий", "Кирил"};
        String[] patronymicName = {"Петрович", "Витальевич", "Сергеевич", "Александрович", "Алексеевич"};
        return surname[random.nextInt(0, surname.length)] + " " +
                name[random.nextInt(0, name.length)] + " " +
                patronymicName[random.nextInt(0, patronymicName.length)];
    }

    @Override
    public String toString() {
        return String.format("id = %d, ФИО работника: %s, отдел: %d, зарплата: %d%n",
                getId(), getFullName(), getDivision(), getSalary());
    }
}
