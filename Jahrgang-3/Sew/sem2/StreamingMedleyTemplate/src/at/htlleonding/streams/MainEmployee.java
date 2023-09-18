package at.htlleonding.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainEmployee {
    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        //Calculate the sum of salaries of the first 5 employees:
        double sumSalaries = -1; //TODO
        assertEquals(10650.0, sumSalaries);

        //Count the employees with a yearly ("14 months" in Austria!) wage of more than 50k:
        long countBetterPaid = -1; //TODO
        assertEquals(3L, countBetterPaid);

        //Calculate the mean age of all employees:
        double meanAge = -1; //TODO
        assertEquals(25.5, meanAge);

        //Create a list of full (i.e. "First Last") names of employees under 30:
        List<String> namesUnderThirty = null; //TODO
        assertEquals("[Doris Gruber, Walter Klein, Herbert Grün, Tamara Mayr, Otto Armann, Gunter Fobes, Astrid Gross]", namesUnderThirty.toString());

        //Find out if all employees are legally aged (15+ in Austria):
        boolean areAllOverage = true; //TODO
        assertEquals(false, areAllOverage);

        //Find out if there's someone older than 20 who earns less than 1000:
        boolean existsOldUnderpayed = false; //TODO
        assertEquals(true, existsOldUnderpayed);

        //Create a list of first names and ages (a la "Sepp (30)") of all employees who earn at least 2500, sorted descendingly by salary:
        List<String> sortedFirstNamesAndAges =  null; //TODO
        assertEquals("[Tamara (29), Sepp (31), Barbara (45), Fritz (42)]", sortedFirstNamesAndAges.toString());

        //Get the highest age of all employees _but_ the first 5:
        int maxAge = -1;//TODO
        assertEquals(42, maxAge);

        //Find the first employee who earns less than 800:
        Employee poorEmployee = null; //TODO
        assertEquals("Otto Armann", String.format("%s %s", poorEmployee.getFirstName(), poorEmployee.getLastName()));

        //Make everyone in the company one year older:
        //TODO
        assertEquals(32, employees.get(0).getAge());
        assertEquals(18, employees.get(1).getAge());
        assertEquals(21, employees.get(2).getAge());
        assertEquals(18, employees.get(7).getAge());
        assertEquals(23, employees.get(8).getAge());
        assertEquals(11, employees.get(9).getAge());

        //Give everyone earning not more than 1500 a special raise of 10 percent:
        //TODO
        assertEquals(3800.0, employees.get(0).getSalary());
        assertEquals(880.0, employees.get(1).getSalary());
        assertEquals(1650.0, employees.get(2).getSalary());
        assertEquals(3650.0, employees.get(3).getSalary());
        assertEquals(990.0, employees.get(4).getSalary());
        assertEquals(2500.0, employees.get(5).getSalary());
        assertEquals(3900.0, employees.get(6).getSalary());
        assertEquals(330.0, employees.get(7).getSalary());
        assertEquals(1900.0, employees.get(8).getSalary());
        assertEquals(110.0, employees.get(9).getSalary());

        //Create a string containing the 5 youngest employee's first names sorted by age:
        String youngestEmployees = "TODO";
        assertEquals("Astrid<Doris<Otto<Walter<Herbert", youngestEmployees);

        //Give everyone a raise of 7,5% and print out the three least earning employees (a la "Fritz 123.4$"):
        //TODO
        //Output:
        //Astrid 118.3$
        //Otto 354.8$
        //Doris 946.0$

        System.out.println("----------");

        //Use streams to create employees from the provided file. You can use EmployeeFactory:
        Stream<String> fileStream = null;
        try {
            fileStream = Files.lines(Paths.get("data/employees.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Employee> fileEmployees = null;//TODO
        assertEquals(1_000, fileEmployees.size());

        //Count the (file) employees who are below the age of 25 and earn more than 3200:
        long countRichAndYoung = -1; //TODO
        assertEquals(72L, countRichAndYoung);

        //Calculate the mean salary of all (file) employees:
        double meanSalary = -1; //TODO
        assertEquals(3051.855, meanSalary);

        //Print the last name and salary (a la "Huber 4500.0$") of the top 5 highest earning (file) employees:
        //TODO
        //Output:
        //Thoumasson 4496.0$
        //Bartoloma 4492.0$
        //Thornber 4486.0$
        //Eyrl 4483.0$
        //Manzell 4482.0$

        //Do the same as above using method reference. You need to create a method (e.g. getLastNameAndSalary) in Employee for that:
        //TODO
    }

    private static List<Employee> createEmployees() {
        List<Employee> result = new LinkedList<>();
        result.add(new Employee("Sepp","Huber",31,3800));
        result.add(new Employee("Doris","Gruber",17,800));
        result.add(new Employee("Walter","Klein",20,1500));
        result.add(new Employee("Barbara", "Gruber",45,3650));
        result.add(new Employee("Herbert","Grün",22,900));
        result.add(new Employee("Fritz","Muster",42,2500));
        result.add(new Employee("Tamara","Mayr",29,3900));
        result.add(new Employee("Otto","Armann",17,300));
        result.add(new Employee("Gunter","Fobes",22,1900));
        result.add(new Employee("Astrid","Gross",10,100));
        return result;
    }

    public static void assertEquals(Object expected, Object actual) {
        if(expected instanceof Double) {
            if((double)actual < (double)expected - 0.01 || (double)expected + 0.01 < (double)actual) {
                throw new RuntimeException(String.format("Expected \"%f\" but received \"%f\" instead!", expected, actual));
            }
        }
        else if(expected == null && actual != null) {
            throw new RuntimeException(String.format("Expected null but received \"%s\" instead!", actual));
        }
        else if(expected != null && !expected.equals(actual)) {
            throw new RuntimeException(String.format("Expected \"%s\" but received \"%s\" instead!", expected, actual));
        }
    }
}
