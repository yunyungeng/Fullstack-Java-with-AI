package src.main.java.com.fullstack;

public class Main {
    public static void main(String[] args) {
        // Syntax for creating an object of the Course class
        // ClassName objectName = new ClassName(constructorParameters);
        // ClassName and Constructor usually match

        Instructor instructor1 = new Instructor("I001", "John Doe", "Computer Science");
        Instructor instructor2 = new Instructor("I002", "Jane Smith", "Data Science");

        Course course1 = new Course("C001", "Introduction to Computer Science", 40, "Beginner");
        Course course2 = new Course("C002", "Data Structures and Algorithms", 60, "Intermediate");
        
        Student student1 = new Student("S001", "Alice Johnson", "alice.johnson@example.com");
        Student student2 = new Student("S002", "Bob Williams", "bob.williams@example.com");

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);

        System.out.println("Instructor Profiles:");
        instructor1.printProfile();
        instructor2.printProfile();

        System.out.println("Course Summaries:");
        course1.printSummary();
        course2.printSummary();

        System.out.println("Student Profiles:");
        student1.printProfile();
        student2.printProfile();
    }
}
