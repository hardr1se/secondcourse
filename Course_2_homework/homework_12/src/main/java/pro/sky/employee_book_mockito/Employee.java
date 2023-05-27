package pro.sky.employee_book_mockito;

import java.util.random.RandomGenerator;

public class Employee {

    private static int idCalculator = 1;
    private int id;

    private String fullName;
    private int division;
    private int salary;

    public Employee(String fullName) {
        this.id = idCalculator++;
        this.fullName = fullName;
        this.division = RandomGenerator.getDefault().nextInt(1, 6);
        this.salary = RandomGenerator.getDefault().nextInt(60_000, 80_000);
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

    @Override
    public String toString() {
        return String.format("id = %d, ФИО работника: %s, отдел: %d, зарплата: %d%n",
                getId(), getFullName(), getDivision(), getSalary());
    }
}
