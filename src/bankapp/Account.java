package bankapp;

public abstract class Account implements IBaseRate {
    //List common properties for all accounts
    String name;
    String socSecurityNo;
    String accountNo;

    double balance;
    double rate;

    static int index = 10000;

    //Constructor to set base properties an initialize account
    public Account(String name, String socSecurityNo, double startingBalance) {
        this.name = name;
        this.socSecurityNo = socSecurityNo;
        balance = startingBalance;

        //Set Acc No
        index++;
        this.accountNo = setAccountNo();
    }

    private String setAccountNo() {
        //11 digit No - starts with 1 for savings or with 2 for checking, two last digits from SSN, 5 digit unique id and 3 random digits
        String lastTwoOfSsn = socSecurityNo.substring(socSecurityNo.length() - 2, socSecurityNo.length());
        int uniqueId = index;
        int randomNum = (int) (Math.random() * Math.pow(10, 3));

        return lastTwoOfSsn + uniqueId + randomNum;
    }

    //List common methods
    public void showInfo() {
        System.out.println("NAME: " + name +
                "\nACCOUNT NO: " + accountNo +
                "\nBALANCE: EUR " + balance);
    }
}
