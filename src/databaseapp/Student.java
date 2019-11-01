package databaseapp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private String courses;
    private int classLevel;
    private int studentId;
    private int courseCost = 600;
    private int tuitionBalance;

    //Constructor asks for name and year
    public Student() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's first name: ");
        this.firstName = sc.nextLine();
        System.out.print("Enter student's last name: ");
        this.lastName = sc.nextLine();
        System.out.print("Enter student's class level\n(1 - Freshmen; 2 - Sophomore; 3 - Junior; 4 - Senior): ");
        this.classLevel = sc.nextInt();

        System.out.println(firstName + " " + lastName + " " + classLevel);
    }

    //generate id

    //enroll in courses

    //view balance

    //pay tuition

    //show status
}
