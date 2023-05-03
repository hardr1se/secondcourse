package pro.sky.libraries;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Employee employee = (Employee)o;
            return Objects.equals(this.firstName, employee.firstName) && Objects.equals(this.lastName, employee.lastName);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.firstName, this.lastName});
    }

    public String toString() {
        return "ФИ: " + this.lastName + " " + this.firstName + "\n";
    }
}