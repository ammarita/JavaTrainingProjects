package bankapp;

public class SavingAccount extends Account {
    // List properties specific for savings account
    private int safetyDepositBoxId; //3 digits
    private int safetyDepositBoxKey; //4 digits

    //List methods specific for savings acc

    //Constructor to initialize savings acc
    public SavingAccount(String name, String socSecurityNo, double startingBalance) {
        super(name, socSecurityNo, startingBalance);
        accountNo = 1 + accountNo;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Saving");
        super.showInfo();
        System.out.println("Safety Deposit Box ID: " + safetyDepositBoxId +
                "\nSafety Deposit Box Key: " + safetyDepositBoxKey);
    }
}
