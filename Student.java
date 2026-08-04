public class Student {

    private int id;
    private String name;
    private double marks;
    private String grade;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        calculateGrade();
    }

    // Calculate Grade Automatically
    private void calculateGrade() {

        if (marks >= 90)
            grade = "A+";
        else if (marks >= 80)
            grade = "A";
        else if (marks >= 70)
            grade = "B";
        else if (marks >= 60)
            grade = "C";
        else if (marks >= 50)
            grade = "D";
        else
            grade = "F";
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    // Update Marks
    public void setMarks(double marks) {
        this.marks = marks;
        calculateGrade();
    }

    // Display Student
    public void display() {

        System.out.printf("%-8d %-15s %-10.2f %-5s%n",
                id, name, marks, grade);
    }
}