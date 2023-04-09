package homework_7;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeBook {
    private static int idCalculator = 1;
    private final Random random = new Random();
    private final int id;
    private String fullName;
    private int division;
    private int salary;

    public EmployeeBook(String fullName) {
        this.id = idCalculator++;
        this.fullName = fullName;
        this.division = random.nextInt(1, 7);
        this.salary = random.nextInt(60_000, 80_000);
    }

    private static String generateFullName() {
        List<String> name = List.of("Петр", "Василий", "Савелий", "Александр", "Виталий");
        List<String> surname = List.of("Соловьев", "Симонов", "Магомедов", "Кудряшин", "Красноперов");
        List<String> middleName = List.of("Николаев", "Сергеевич", "Витальевич", "Анатольевич", "Васильевич");
        Random random1 = new Random();
        return surname.get(random1.nextInt(0, surname.size() - 1)) + " " +
                name.get(random1.nextInt(0, name.size() - 1)) + " " +
                middleName.get(random1.nextInt(0, middleName.size() - 1));
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

    private static final int SIZE = 10;

    private final static Map<String, EmployeeBook> people = new HashMap<>();

    static  {
        EmployeeBook person1 = new EmployeeBook(generateFullName());
        EmployeeBook person2 = new EmployeeBook(generateFullName());
        EmployeeBook person3 = new EmployeeBook(generateFullName());
        EmployeeBook person4 = new EmployeeBook(generateFullName());
        EmployeeBook person5 = new EmployeeBook(generateFullName());
        EmployeeBook person6 = new EmployeeBook(generateFullName());
        EmployeeBook person7 = new EmployeeBook(generateFullName());
        EmployeeBook person8 = new EmployeeBook(generateFullName());
        EmployeeBook person9 = new EmployeeBook(generateFullName());
        EmployeeBook person10 = new EmployeeBook(generateFullName());

        people.put(person1.getFullName(), person1);
        people.put(person2.getFullName(), person2);
        people.put(person3.getFullName(), person3);
        people.put(person4.getFullName(), person4);
        people.put(person5.getFullName(), person5);
        people.put(person6.getFullName(), person6);
        people.put(person7.getFullName(), person7);
        people.put(person8.getFullName(), person8);
        people.put(person9.getFullName(), person9);
        people.put(person10.getFullName(), person10);
    }

    public static Map<String, EmployeeBook> getPeople() {
        return people;
    }

    public void addEmployeeToArray(EmployeeBook employee) {
        if (people.size() >= SIZE) {
            System.out.println("Штат заполнен, не хватает места");
        } else if (people.containsKey(employee.getFullName())) {
            System.out.println("Данный сотрудник уже занесен в список, невозможно добавить его еще раз");
        } else {
            people.put(employee.getFullName(), employee);
        }
    }

    public void deleteEmployeeFromArrayFullName(String employeeToDelete) {
        if (people.remove(employeeToDelete, people.get(employeeToDelete))) {
            System.out.println("Сотрудник удален из списка");
        } else {
            System.out.println("Такой сотрудник не найден");
        }
    }

    public void deleteEmployeeFromArrayId(int idToDelete) {
        for (EmployeeBook employee : people.values()) {
            if (employee.getId() == idToDelete) {
                people.remove(employee.getFullName());
                return;
            }
        }
        System.out.println("Такой сотрудник не найден");
    }

    public void makeSomeCorrectionsSalary(String fullNameEmployee, int newSalary) {
        if (people.containsKey(fullNameEmployee)) {
            people.get(fullNameEmployee).setSalary(newSalary);
        } else {
            System.out.println("Такой сотрудник не найден");
        }
    }

    public void makeSomeCorrectionsDivision(String fullNameOfEmployee, int newDivision) {
        if (people.containsKey(fullNameOfEmployee)) {
            people.get(fullNameOfEmployee).setDivision(newDivision);
        } else {
            System.out.println("Такой сотрудник не найден");
        }
    }

    public void printAllSortedByDivisions() {
        Map<Integer, List<EmployeeBook>> arr = new HashMap<>();
        int max = people.values().stream().mapToInt(EmployeeBook::getDivision).max().getAsInt();
        for (int i = 1; i <= max; i++) {
            int count = i;
            arr.put(i, people.values().stream().filter(x -> x.getDivision() == count).collect(Collectors.toList()));
            System.out.println("\nСотрудники " + i + " отдела");
            arr.get(i).forEach(System.out::println);
        }
    }

    public void printAll() {
        people.values().forEach(System.out::println);
    }

    public int monthlyExpenses() {
        return people.values().stream()
                .mapToInt(EmployeeBook::getSalary)
                .sum();
    }

    public EmployeeBook minSalaryEmployeeBook() {
        return people.values().stream()
                .min(Comparator.comparing(EmployeeBook::getSalary))
                .get();
    }

    public EmployeeBook maxSalaryEmployeeBook() {
        return people.values().stream()
                .max(Comparator.comparing(EmployeeBook::getSalary))
                .get();
    }

    public float middleSalary() {
        return (float) monthlyExpenses() / people.size();
    }

    public void printTheFullNameOfEveryEmployeeBook() {
        people.keySet().forEach(System.out::println);
    }

    public void indexOfSalaryEveryone(int indexPercent) {
        for (EmployeeBook employee : people.values()) {
            employee.setSalary(employee.getSalary() * (100 + indexPercent) / 100);
        }
    }

    public EmployeeBook minSalaryEmployeeBook(int certainDivision) {
        return people.values().stream()
                .filter(x -> x.getDivision() == certainDivision)
                .min(Comparator.comparing(EmployeeBook::getSalary))
                .get();
    }

    public EmployeeBook maxSalaryEmployeeBook(int certainDivision) {
        return people.values().stream()
                .filter(x -> x.getDivision() == certainDivision)
                .max(Comparator.comparing(EmployeeBook::getSalary))
                .get();
    }

    public int monthlyExpenses(int certainDivision) {
        return people.values().stream()
                .filter(x -> x.getDivision() == certainDivision)
                .mapToInt(EmployeeBook::getSalary)
                .sum();
    }

    public double middleSalary(int certainDivision) {
        return people.values().stream()
                .filter(x -> x.getDivision() == certainDivision)
                .mapToInt(EmployeeBook::getSalary)
                .average()
                .getAsDouble();
    }

    public void indexOfEmployeeBookSalaryCertainDivision(int indexPercentForCertainDivision, int certainDivision) {
        for (EmployeeBook employee : people.values()) {
            if (employee.getDivision() == certainDivision) {
                employee.setSalary(employee.getSalary() * (100 + indexPercentForCertainDivision) / 100);
            }
        }
    }

    public void printAllCertainDivision(int certainDivision) {
        people.values().stream()
                .filter(x -> x.getDivision() == certainDivision)
                .forEach(System.out::println);
    }

    public void printEmployeeBookBiggerSalary(int certainSalary) {
        for (EmployeeBook employee : people.values()) {
            if (employee.getSalary() > certainSalary) {
                System.out.printf("id = %d, ФИО работника: %s, зарплата: %d%n",
                        employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public void printEmployeeBookLowerSalary(int certainSalary) {
        for (EmployeeBook employee : people.values()) {
            if (employee.getSalary() < certainSalary) {
                System.out.printf("id = %d, ФИО работника: %s, зарплата: %d%n",
                        employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("id = %d, ФИО работника: %s, отдел: %d, зарплата: %d",
                getId(), getFullName(), getDivision(), getSalary());
    }
}
