package bankapp;

public abstract class Account implements IBaseRate {
    //List common properties for all accounts

    //Constructor to set base properties an initialize account
    public Account(String name) {
        System.out.println("CLIENT: " + name);
        System.out.print("NEW ACCOUNT: ");
    }

    //List common methods
}
