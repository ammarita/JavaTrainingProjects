package bankapp;

public class CheckingAccount extends Account {
    // List properties specific for checking account
    int debitCardNo; //12 digits
    int debitCardPin; // 4 digits

    //List methods specific for checking acc

    //Constructor to initialize checking acc
    public CheckingAccount(String name, String socSecurityNo, double startingBalance) {
        super(name, socSecurityNo, startingBalance);
        accountNo = 2 + accountNo;
        setDebitCard();
    }

    private void setDebitCard() {
        debitCardNo = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();
        System.out.println("Debit Card No: " + debitCardNo +
                "\nDebit Card Pin: " + debitCardPin);

    }
}
