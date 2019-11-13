package companystructureapp;

public class Accountant extends BusinessEmployee {
    public Accountant(String name) {
        super(name);
    }

    @Override
    public double getBonusBudget() {
        return 0;
    }

    @Override
    public Employee getManager() {
        return null;
    }
}
