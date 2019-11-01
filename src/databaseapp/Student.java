package databaseapp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private String courses;
    private String studentId;
    private int classLevel;
    private int tuitionBalance;
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

    //view balance

    //pay tuition

    //show status
}
