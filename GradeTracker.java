import java.util.ArrayList;

public class GradeTracker {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {

        if (isDuplicateId(student.getId())) {
            System.out.println("Student ID already exists!");
            return;
        }

        students.add(student);
        System.out.println("Student Added Successfully!");
    }

    // Check Duplicate ID
    public boolean isDuplicateId(int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Display All Students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo Student Records Found!");
            return;
        }

        System.out.println("\n=====================================================");
        System.out.printf("%-8s %-15s %-10s %-8s%n",
                "ID", "NAME", "MARKS", "GRADE");
        System.out.println("-----------------------------------------------------");

        for (Student s : students) {
            s.display();
        }

        System.out.println("=====================================================");
    }

    // Search Student
    public void searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {

                System.out.println("\nStudent Found");
                System.out.println("----------------------------------------");
                System.out.printf("%-8s %-15s %-10s %-8s%n",
                        "ID", "NAME", "MARKS", "GRADE");
                s.display();
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Update Marks
    public void updateStudentMarks(int id, double marks) {

        for (Student s : students) {

            if (s.getId() == id) {

                s.setMarks(marks);
                System.out.println("Marks Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Delete Student
    public void deleteStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {

                students.remove(s);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Average Marks
    public void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        double total = 0;

        for (Student s : students) {
            total += s.getMarks();
        }

        System.out.printf("Average Marks : %.2f%n",
                total / students.size());
    }

    // Highest Marks
    public void highestMarks() {

        if (students.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        Student highest = students.get(0);

        for (Student s : students) {

            if (s.getMarks() > highest.getMarks()) {
                highest = s;
            }
        }

        System.out.println("\nHighest Scorer");
        System.out.println("----------------------------------------");
        System.out.printf("%-8s %-15s %-10s %-8s%n",
                "ID", "NAME", "MARKS", "GRADE");
        highest.display();
    }

    // Lowest Marks
    public void lowestMarks() {

        if (students.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        Student lowest = students.get(0);

        for (Student s : students) {

            if (s.getMarks() < lowest.getMarks()) {
                lowest = s;
            }
        }

        System.out.println("\nLowest Scorer");
        System.out.println("----------------------------------------");
        System.out.printf("%-8s %-15s %-10s %-8s%n",
                "ID", "NAME", "MARKS", "GRADE");
        lowest.display();
    }

    // Total Students
    public void totalStudents() {

        System.out.println("Total Students : " + students.size());
    }
}