package bankapp;

public class BankAccountApp {
    public static void main(String[] args) {

        CheckingAccount checking1 = new CheckingAccount("Thomas Edison", "123456789", 1500);
        checking1.showInfo();

        System.out.println("---");

        SavingAccount savings1 = new SavingAccount("Alison Cooper", "987654321", 3456);
        savings1.showInfo();

        //Read CSV and create new accounts corresponding that file

    }
}
