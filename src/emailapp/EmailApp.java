package emailapp;

public class EmailApp {

    public static void main(String[] args) {
        Email email1 = new Email("Arthur", "Dent");

        email1.setMailboxSize(1000);
        email1.setAlternateEmail("a.dent@earth.com");
        email1.changePassword("Trillian");

        System.out.println("Your mailbox size is: " + email1.getMailboxSize() + ", your alternate e-mail is: " + email1.getAlternateEmail() + " and your password is: " + email1.getPassword());
    }
}
