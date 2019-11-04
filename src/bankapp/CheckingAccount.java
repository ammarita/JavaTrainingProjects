package bankapp;

public class CheckingAccount extends Account {
    // List properties specific for checking account
    int debitCardNo;
    int debitCardPin;

    //List methods specific for checking acc

    //Constructor to initialize checking acc
    public CheckingAccount(String name, String socSecurityNo, double startingBalance) {
        super(name, socSecurityNo, startingBalance);
        accountNo = 2 + accountNo;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: Checking");
    }
}
