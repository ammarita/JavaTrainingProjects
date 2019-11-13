package companystructureapp;

public abstract class Employee {
    private double baseSalary;
    private String name;
    private int employeeID;
    private static int employeeCount = 1;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.employeeID = employeeCount++;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    //Should return a reference to the Employee object that represents this employee's manager
    public abstract Employee getManager();

    //Should return true if the two employee IDs are the same, false otherwise
    public boolean equals(Employee other) {
        return this.employeeID == other.employeeID;
    }

    @Override
    public String toString() {
        return employeeID + " " + name;
    }

    //Should return a String representation of that Employee's current status. This will be different for every subclass of Employee
    public abstract String employeeStatus();
}
