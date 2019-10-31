package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private int mailboxSize;
    private int defaultPasswordLength = 10;

    //Constructor to receive first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("E-MAIL CREATED FOR: " + this.firstName + " " + this.lastName);

        //Call a method that asks for the department and returns department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //Call a method that generates a password
        this.password = generatePassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
    }
    //Ask for department
    private String setDepartment() {
        System.out.println("DEPARTMENT CODES:\n1 - Sales; 2 - Development; 3 - Accounting' 0 - none\nEnter department code: ");
        Scanner sc = new Scanner(System.in);
        int departmentChoice = sc.nextInt();
        if(departmentChoice == 1) {
            return "Sales";
        } else if(departmentChoice == 2) {
            return "Development";
        } else if(departmentChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    //Generate a password
    private String generatePassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&";
        char[] password = new char[length];
        for(int i = 0; i < length; i++) {
            int randomNum = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomNum);
        }
        return new String(password);
    }

    //Set the mailbox size

    //Set the alternate email

    //Change the password

}
