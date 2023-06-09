import java.util.Scanner;
import java.util.*;

public class employeemanagementsystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to the Employee Management System\n");
            System.out.println("1. Add employee");
            System.out.println("2. Remove employee");
            System.out.println("3. View all employees");
            System.out.println("4. Exit\n");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("How many employee you want to add? ");
                    int add = scanner.nextInt();
                    for (int i = 1; i <= add; i++) {
                        addEmployee();
                    }
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    viewEmployees();
                    break;
                case 4:
                    System.out.println("Thank you for using the Employee Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        } while (choice != 4);
    }
    private static void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter employee name: ");
        String name = scanner.next();
        System.out.print("Enter employee department: ");
        String department = scanner.next();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, department, salary); 
        EmployeeDatabase.addEmployee(employee);

        System.out.println("Employee added successfully.\n");
    }
    private static void removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID to remove: ");
        int id = scanner.nextInt();

        EmployeeDatabase.removeEmployee(id);
    }
    private static void viewEmployees() {
        System.out.println("Employee List:");
        EmployeeDatabase.getAllEmployees();
        System.out.println();
    }
}
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class EmployeeDatabase {
    private static Employee[] employees = new Employee[10];
    private static int currentIndex = 0;
    public static void addEmployee(Employee employee) {
        employees[currentIndex] = employee;
        currentIndex++;
    }

    public static void getAllEmployees() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(employees[i]);
        }
    }
    public static void removeEmployee(int id) {
        for (int i = 0; i < currentIndex; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                currentIndex--;
                for (int j = i; j < currentIndex; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[currentIndex] = null;
                System.out.println("Employee removed successfully.\n");
                return;
            }
        }
        System.out.println("Employee not found.\n");
    }
}