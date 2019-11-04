package bankapp;

public class SavingAccount extends Account {
    // List properties specific for savings account
    int safetyDepositBoxId;
    int safetyDepositBoxKey;

    //List methods specific for savings acc

    //Constructor to initialize savings acc
    public SavingAccount(String name, String socSecurityNo, double startingBalance) {
        super(name, socSecurityNo, startingBalance);
        accountNo = 1 + accountNo;
        System.out.println("ACCOUNT NO: " + this.accountNo);
        System.out.println("NEW SAVINGS ACCOUNT");
    }
}
