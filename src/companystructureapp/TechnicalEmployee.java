package companystructureapp;

public abstract class TechnicalEmployee extends Employee {

    private int checkIns;
    private boolean isManager;

    public TechnicalEmployee(String name) {
        super(name, 75000);
        this.checkIns = 0;
        this.isManager = false;
    }

    public int getCheckIns() {
        return checkIns;
    }

    @Override
    public String employeeStatus() {
        return getEmployeeID() + " " + getName() + "has a " + checkIns + " successful check ins";
    }
}
