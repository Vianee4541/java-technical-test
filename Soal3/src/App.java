import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class App {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", 5500));
        employees.add(new Employee(2, "Charlie", 7000));
        employees.add(new Employee(3, "Bob", 6200));

        // sort by salary
        List<Employee> bySalary = new ArrayList<>(employees);
        bySalary.sort(Comparator.comparingDouble(e -> -e.salary)); // desc
        // bySalary = bySalary.reversed(); // asc
        System.out.println("A) Sorted by salary:");
        bySalary.forEach(System.out::println);

        // sort by name
        List<Employee> byName = new ArrayList<>(employees);
        byName.sort(Comparator.comparing(e -> e.name)); // asc
        // byName = byName.reversed(); // desc
        System.out.println("\nB) Sorted by name:");
        byName.forEach(System.out::println);
    }
}
