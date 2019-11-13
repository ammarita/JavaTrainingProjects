package companystructureapp;

public abstract class BusinessEmployee extends Employee {
    private double bonusBudget;

    public BusinessEmployee(String name) {
        super(name, 50000);
        this.bonusBudget = 0;
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    @Override
    public String employeeStatus() {
        return getEmployeeID() + " " + getName() + " with a budget of " + getBonusBudget();
    }
}
