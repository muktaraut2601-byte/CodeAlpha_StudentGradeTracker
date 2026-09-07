package codealpha_studentgradetracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        int choice;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       STUDENT GRADE TRACKER");
            System.out.println("========================================");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Calculate Average Marks");
            System.out.println("4. Find Highest Marks");
            System.out.println("5. Find Lowest Marks");
            System.out.println("6. Search Student");
            System.out.println("7. Update Student Marks");
            System.out.println("8. Delete Student");
            System.out.println("9. Total Students");
            System.out.println("10. Exit");

            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks should be between 0 and 100.");
                        break;
                    }

                    Student student = new Student(id, name, marks);
                    tracker.addStudent(student);

                    break;

                case 2:
                    tracker.displayStudents();
                    break;

                case 3:
                    tracker.calculateAverage();
                    break;

                case 4:
                    tracker.highestMarks();
                    break;

                case 5:
                    tracker.lowestMarks();
                    break;

                case 6:

                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    tracker.searchStudent(searchId);

                    break;

                case 7:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    double newMarks = sc.nextDouble();

                    tracker.updateStudentMarks(updateId, newMarks);

                    break;

                case 8:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    tracker.deleteStudent(deleteId);

                    break;

                case 9:
                    tracker.totalStudents();
                    break;

                case 10:

                    System.out.println();
                    System.out.println(
                            "Thank you for using Student Grade Tracker!");

                    break;

                default:

                    System.out.println(
                            "Invalid choice! Please try again.");
            }

        } while (choice != 10);

        sc.close();
    }
}
}
