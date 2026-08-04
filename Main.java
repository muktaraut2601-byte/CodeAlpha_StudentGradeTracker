import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        while (true) {

            System.out.println("\n========================================");
            System.out.println("      STUDENT GRADE TRACKER SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Average");
            System.out.println("7. Highest Marks");
            System.out.println("8. Lowest Marks");
            System.out.println("9. Total Students");
            System.out.println("10. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Marks: ");
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

                    System.out.print("Enter Student ID to Search: ");
                    id = sc.nextInt();
                    tracker.searchStudent(id);
                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    marks = sc.nextDouble();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks should be between 0 and 100.");
                        break;
                    }

                    tracker.updateStudentMarks(id, marks);
                    break;

                case 5:

                    System.out.print("Enter Student ID to Delete: ");
                    id = sc.nextInt();

                    tracker.deleteStudent(id);
                    break;

                case 6:
                    tracker.calculateAverage();
                    break;

                case 7:
                    tracker.highestMarks();
                    break;

                case 8:
                    tracker.lowestMarks();
                    break;

                case 9:
                    tracker.totalStudents();
                    break;

                case 10:

                    System.out.println("\nThank You!");
                    System.out.println("Exiting Student Grade Tracker...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice! Please Try Again.");
            }
        }
    }
}