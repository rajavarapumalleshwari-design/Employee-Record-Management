import java.util.*;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", Salary: " + salary;
    }
}

public class EmployeeRecordManagement {

    // Map provides fast employee lookup using ID
    private static Map<Integer, Employee> employees = new HashMap<>();

    // Set stores unique department names
    private static Set<String> departments = new HashSet<>();

    // List maintains employee records in insertion order
    private static List<Employee> employeeList = new ArrayList<>();

    // Add employee
    public static void addEmployee(Employee employee) {

        if (employees.containsKey(employee.getId())) {
            System.out.println("Employee ID already exists.");
            return;
        }

        employees.put(employee.getId(), employee);
        employeeList.add(employee);
        departments.add(employee.getDepartment());

        System.out.println("Employee added successfully.");
    }

    // Update employee
    public static void updateEmployee(int id, String name,
                                      String department, double salary) {

        Employee employee = employees.get(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);

        departments.add(department);

        System.out.println("Employee updated successfully.");
    }

    // Delete employee
    public static void deleteEmployee(int id) {

        Employee employee = employees.remove(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        employeeList.remove(employee);

        System.out.println("Employee deleted successfully.");
    }

    // Search employee
    public static void searchEmployee(int id) {

        Employee employee = employees.get(id);

        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Display all employees
    public static void displayEmployees() {

        if (employeeList.isEmpty()) {
            System.out.println("No employee records available.");
            return;
        }

        System.out.println("\n--- Employee Records ---");

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    // Display unique departments
    public static void displayDepartments() {

        System.out.println("\n--- Departments ---");

        for (String department : departments) {
            System.out.println(department);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Employee Record Management =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Display Departments");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee employee =
                            new Employee(id, name, department, salary);

                    addEmployee(employee);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();

                    updateEmployee(
                            updateId,
                            newName,
                            newDepartment,
                            newSalary
                    );
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();

                    deleteEmployee(deleteId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();

                    searchEmployee(searchId);
                    break;

                case 5:
                    displayEmployees();
                    break;

                case 6:
                    displayDepartments();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}