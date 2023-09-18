package at.htlleonding.streams;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary=salary;
    }

    public void raiseSalary(double percent) {
        double raise = this.salary * (percent/100);
        this.salary += raise;
    }

    public void celebrateBirthday() {
        this.age++;
    }
}