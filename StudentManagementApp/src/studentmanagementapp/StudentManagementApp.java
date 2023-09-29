/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementapp;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private final String studentName;
    private final int studentAge;
    final String studentID;

    // Constructor
    public Student(String name, int age, String id) {
        this.studentName = name;
        this.studentAge = age;
        this.studentID = id;
    }

    // Getters and setters for student attributes

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Age: " + studentAge);
    }
}

public class StudentManagementApp {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static int studentCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. View student report");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> captureStudent(scanner);
                case 2 -> searchStudent(scanner);
                case 3 -> deleteStudent(scanner);
                case 4 -> studentReport();
                case 5 -> {
                    exitStudentApplication();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void captureStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        int age;
        do {
            System.out.print("Enter student age: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid age. Please enter a valid number.");
                scanner.next();
            }
            age = scanner.nextInt();
        } while (age < 16);

        String studentID = "S" + studentCounter++;
        Student student = new Student(name, age, studentID);
        students.add(student);
        System.out.println("Student details successfully saved.");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student ID to search: ");
        String searchID = scanner.nextLine();

        for (Student student : students) {
            if (student.studentID.equals(searchID)) {
                student.displayStudentDetails();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        String deleteID = scanner.nextLine();

        for (Student student : students) {
            if (student.studentID.equals(deleteID)) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void studentReport() {
        if (students.isEmpty()) {
            System.out.println("No students to display in the report.");
        } else {
            System.out.println("Student Report:");
            for (Student student : students) {
                student.displayStudentDetails();
            }
        }
    }

    private static void exitStudentApplication() {
        System.out.println("Exiting the application. Goodbye!");
    }
}