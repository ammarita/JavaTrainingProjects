package bankapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<>();
        String file = "C:\\Users\\marita.lasmane\\Downloads\\NewBankAccounts.csv";
        List<String[]> newClients = utilities.CSV.read(file);

        for(String[] client : newClients ) {
            String name = client[0];
            String socSecurityNo = client[1];
            String accountType = client[2];
            double startingBalance = Double.parseDouble(client[3]);
            System.out.println(name + " " + socSecurityNo + " " + accountType + " EUR " + startingBalance);

            if(accountType.equals("Savings")) {
                accounts.add(new SavingAccount(name, socSecurityNo, startingBalance));
            } else if (accountType.equals("Checking")) {
                accounts.add(new CheckingAccount(name, socSecurityNo, startingBalance));
            } else {
                System.out.println("Error Reading Account Type");
            }
        }

        for (Account acc : accounts) {
            System.out.println("- - -");
            acc.showInfo();
        }
    }
}
