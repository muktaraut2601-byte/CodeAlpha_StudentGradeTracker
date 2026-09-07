package codealpha_studentgradetracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GradeTracker {

    private ArrayList<Student> students;
    private final String FILE_NAME = "students.txt";

    public GradeTracker() {
        students = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(Student student) {

        if (isDuplicateId(student.getId())) {
            System.out.println("Student ID already exists!");
            return;
        }

        students.add(student);
        saveToFile();

        System.out.println("Student Added Successfully!");
    }

    public boolean isDuplicateId(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }

        return false;
    }

    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo Student Records Found!");
            return;
        }

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                    STUDENT RECORDS");
        System.out.println("==============================================================");

        System.out.printf("%-10s %-20s %-12s %-10s%n",
                "ID", "NAME", "MARKS", "GRADE");

        System.out.println("--------------------------------------------------------------");

        for (Student student : students) {
            student.display();
        }

        System.out.println("==============================================================");
    }

    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("\nStudent Found");
                System.out.println("----------------------------------------");

                System.out.printf("%-10s %-20s %-12s %-10s%n",
                        "ID", "NAME", "MARKS", "GRADE");

                student.display();

                System.out.println("----------------------------------------");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public void updateStudentMarks(int id, double marks) {

        if (marks < 0 || marks > 100) {
            System.out.println("Marks should be between 0 and 100.");
            return;
        }

        for (Student student : students) {

            if (student.getId() == id) {

                student.setMarks(marks);
                saveToFile();

                System.out.println("Marks Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public void deleteStudent(int id) {

        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {

            Student student = iterator.next();

            if (student.getId() == id) {

                iterator.remove();
                saveToFile();

                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getMarks();
        }

        double average = total / students.size();

        System.out.printf("Average Marks : %.2f%n", average);
    }

    public void highestMarks() {

        if (students.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        Student highest = students.get(0);

        for (Student student : students) {

            if (student.getMarks() > highest.getMarks()) {
                highest = student;
            }
        }

        System.out.println("\nHighest Scorer");
        System.out.println("----------------------------------------");

        highest.display();

        System.out.println("----------------------------------------");
    }

    public void lowestMarks() {

        if (students.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        Student lowest = students.get(0);

        for (Student student : students) {

            if (student.getMarks() < lowest.getMarks()) {
                lowest = student;
            }
        }

        System.out.println("\nLowest Scorer");
        System.out.println("----------------------------------------");

        lowest.display();

        System.out.println("----------------------------------------");
    }

    public void totalStudents() {
        System.out.println("Total Students : " + students.size());
    }

    private void saveToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {
                writer.write(student.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error while saving student data.");
        }
    }

    private void loadFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double marks = Double.parseDouble(data[2]);

                    students.add(new Student(id, name, marks));
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error while loading student data.");
        }
    }
}
