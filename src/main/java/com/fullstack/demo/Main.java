package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.CourseOffering;
import com.fullstack.demo.model.Instructor;
import com.fullstack.demo.model.Student;
import java.util.ArrayList; 

public class Main {
    public static void main(String[] args) {
        // Syntax for creating an object of the Course class
        // ClassName objectName = new ClassName(constructorParameters);
        // ClassName and Constructor usually match

        // Create Instructor objects
        Instructor instructor1 = new Instructor("I001", "John Doe", "Computer Science");
        Instructor instructor2 = new Instructor("I002", "Jane Smith", "Data Science");
        Instructor instructor3 = new Instructor("I003", "Emily Johnson", "Software Engineering");
        Instructor instructor4 = new Instructor("I004", "Michael Brown", "Artificial Intelligence");

        // Create Course objects
        Course course1 = new Course("C001", "Introduction to Computer Science", 40, "Beginner", "Programming", true);
        Course course2 = new Course("C002", "Data Structures and Algorithms", 60, "Intermediate", "Programming", false);
        Course course3 = new Course("C003", "Java Fundamentals", 50, "Advanced", "Data Science", false);
        Course course4 = new Course("C004", "Data Science", 45, "Intermediate", "Programming", true);

        // Create Student objects
        Student student1 = new Student("S001", "Alice Johnson", "alice.johnson@example.com");
        Student student2 = new Student("S002", "Bob Williams", "bob.williams@example.com");
        Student student3 = new Student("S003", "Charlie Davis", "charlie.davis@example.com");

        // Create CourseOffering objects
        CourseOffering offering1 = new CourseOffering("OFF001", "Java Fundamentals - June 2026 Intake", course3, instructor3, "2026-06-19", "2026-06-20", 25, "Hybrid");
        CourseOffering offering2 = new CourseOffering("OFF002", "Data Science Bootcamp - July 2026 Intake", course4, instructor2, "2026-07-01", "2026-07-15", 30, "Online");

        // Set instructors for courses
        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);
        course4.setInstructor(instructor4);

        // Store objects in ArrayLists (reporsitories)
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Instructor> instructors = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<CourseOffering> offerings = new ArrayList<>();
        
        courses.add(new Course("C001", "Introduction to Computer Science", 40, "Beginner", "Programming", true));
        courses.add(new Course("C002", "Data Structures and Algorithms", 60, "Intermediate", "Data Structures", false));
        courses.add(new Course("C003", "Java Fundamentals", 50, "Advanced", "Java Fundamentals", false));
        courses.add(new Course("C004", "Data Science", 45, "Intermediate", "Data Science", true));

        instructors.add(new Instructor("I001", "John Doe", "Computer Science"));
        instructors.add(new Instructor("I002", "Jane Smith", "Data Science"));
        instructors.add(new Instructor("I003", "Alice Johnson", "Programming"));
        instructors.add(new Instructor("I004", "Bob Williams", "Data Science"));

        students.add(new Student("S001", "Charlie Davis", "charlie.davis@example.com"));
        students.add(new Student("S002", "Diana Miller", "diana.miller@example.com"));
        students.add(new Student("S003", "Eve Wilson", "eve.wilson@example.com"));

        offerings.add(new CourseOffering("OFF001", "Java Fundamentals - June 2026 Intake", courses.get(2), instructors.get(2), "2026-06-19", "2026-06-20", 25, "Hybrid"));
        offerings.add(new CourseOffering("OFF002", "Data Science Bootcamp - July 2026 Intake", courses.get(3), instructors.get(1), "2026-07-01", "2026-07-15", 30, "Online"));

        System.out.println("COURSE SUMMARIES:");
        for (Course course : courses) { // enhanced for loop
            course.printSummary();
        }

        System.out.println("-----------------------------------\n");

        System.out.println("INSTRUCTOR PROFILES:");
        for (Instructor instructor : instructors) {
            instructor.printProfile();
        }

        System.out.println("-----------------------------------\n");

        System.out.println("STUDENT PROFILES:");
        for (Student student : students) {
            student.printProfile();
        }

        System.out.println("-----------------------------------\n");

        System.out.println("COURSE OFFERING SUMMARIES:");
        for (CourseOffering offering : offerings) {
            offering.printOfferingSummary();
        }

        // Print profiles and summaries
        /* 
        System.out.println("INSTRUCTOR PROFILES:");
        instructor1.printProfile();
        instructor2.printProfile();
        instructor3.printProfile();
        instructor4.printProfile();

        System.out.println("------------------------------\n");

        System.out.println("COURSE SUMMARIES:");
        course1.printSummary();
        course2.printSummary();
        course3.printSummary();
        course4.printSummary();

        System.out.println("------------------------------\n");

        System.out.println("STUDENT PROFILES:");
        student1.printProfile();
        student2.printProfile();
        student3.printProfile();
        System.out.println("------------------------------\n");

        System.out.println("COURSE OFFERING SUMMARIES:");
        offering1.printOfferingSummary();
        offering2.printOfferingSummary(); */
    }
}
