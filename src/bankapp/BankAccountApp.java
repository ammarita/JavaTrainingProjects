package bankapp;

public class BankAccountApp {
    public static void main(String[] args) {

        CheckingAccount checking1 = new CheckingAccount("Thomas Edison", "123456789", 1500);
        SavingAccount savings1 = new SavingAccount("Alison Cooper", "987654321", 3456);

        checking1.showInfo();
        System.out.println("---");
        savings1.showInfo();

        savings1.deposit(2000);
        savings1.withdraw(100);
        savings1.transfer("Film Studio", 3000);

        //Read CSV and create new accounts corresponding that file

    }
}
