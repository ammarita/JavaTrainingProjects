package databaseapp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private String courses = "";
    private String studentId;
    private int classLevel;
    private int tuitionBalance = 0;
    private static int id = 1000;
    private static int courseCost = 600;

    //Constructor asks for name and year
    public Student() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's first name: ");
        this.firstName = sc.nextLine();
        System.out.print("Enter student's last name: ");
        this.lastName = sc.nextLine();
        System.out.print("Enter student's class level\n(1 - Freshmen; 2 - Sophomore; 3 - Junior; 4 - Senior): ");
        this.classLevel = sc.nextInt();
        setStudentId();

        System.out.println(firstName + " " + lastName + " " + classLevel + " " + studentId);
    }

    //generate id that contains class level and 4 more digits
    private void setStudentId() {
        id++;
        this.studentId = classLevel + "" + id;
    }

    //enroll in courses
    public void enroll() {
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner sc = new Scanner(System.in);
            String course = sc.nextLine();
            if(!course.equals("Q")) {
                courses += course + "\n";
                tuitionBalance += courseCost;
            } else {
                break;
            }
        } while(true);

        System.out.println("ENROLLED IN:\n" + courses);
        //System.out.println("TUITION BALANCE: $ " + tuitionBalance);
    }

    //view balance
    public void viewBalance() {
        System.out.println("Your balance is: $ " + tuitionBalance);
    }

    //pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("How much do you want to pay?");
        Scanner sc = new Scanner(System.in);
        int payment = sc.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment $ " + payment);
        viewBalance();
    }

    //show status
}
