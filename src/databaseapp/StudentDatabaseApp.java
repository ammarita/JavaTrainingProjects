package databaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {
        //Ask how many students to add
        System.out.print("Enter number of student count to be added: ");
        Scanner sc = new Scanner(System.in);
        int studentCount = sc.nextInt();
        Student[] students = new Student[studentCount];

        //Create new students
        for(int i = 0; i < studentCount; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            System.out.println("-----");
        }

        for(Student student : students) {
            System.out.println(student.showInfo() + "\n");
        }
    }
}
