package at.htlleonding.streams;

public class EmployeeFactory {
    public static Employee createFromString(String employeeRaw) {
        //Check out mockaroo.com!
        //Germaine,Gwilliams,29,3249
        String[] parts = employeeRaw.split(",");
        String firstName = parts[0];
        String lastName = parts[1];
        int age = Integer.valueOf(parts[2]);
        double salary = Double.valueOf(parts[3]);
        return new Employee(firstName, lastName, age, salary);
    }
}
