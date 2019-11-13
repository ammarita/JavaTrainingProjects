package companystructureapp;

public class TechnicalLead extends TechnicalEmployee {
    public TechnicalLead(String name) {
        super(name);
    }

    @Override
    public Employee getManager() {
        return null;
    }
}
