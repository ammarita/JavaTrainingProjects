package bankapp;

import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {

        String file = "C:\\Users\\marita.lasmane\\Downloads\\NewBankAccounts.csv";

//        CheckingAccount checking1 = new CheckingAccount("Thomas Edison", "123456789", 1500);
//        SavingAccount savings1 = new SavingAccount("Alison Cooper", "987654321", 3456);
//
//        checking1.showInfo();
//        System.out.println("---");
//        savings1.showInfo();
//
//        savings1.compound();

        //Read CSV and create new accounts corresponding that file
        List<String[]> newClients = utilities.CSV.read(file);

        for(String[] client : newClients ) {
            System.out.println("NEW ACCOUNT");
            System.out.println(client[0]);
            System.out.println(client[1]);
            System.out.println(client[2]);
            System.out.println(client[3]);
        }

    }
}
