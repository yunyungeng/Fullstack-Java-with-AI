package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.CourseOffering;
import com.fullstack.demo.model.Instructor;

public class Day3_Assignment04_ObjectRelationshipPractice {
    public static void main(String[] args) {
        // Task A - Create two instructors
        Instructor instructor1 = new Instructor("I001", "Aina Rahman", "Java and Spring Boot");
        Instructor instructor2 = new Instructor("I002", "Marcus Lee", "React and Frontend Development");

        // Task B - Create two courses
        Course course1 = new Course("C001", "Java Fundamentals", 14, "Beginner", "Programming", false);
        Course course2 = new Course("C002", "React Frontend Development", 21, "Intermediate", "Frontend", true);

        // Task C - Assign instructors to courses
        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);

        // Print summaries for both courses
        System.out.println("=== Courses ===");
        course1.printSummary();
        course2.printSummary();

        /* 
        Task F - Add comments explaining Composition
        - CourseOffering uses composition because it has a Course and has an Instructor.
        - Rather than copying strings like courseTitle or instructorName, it stores references to the entire live object structures.
        */

        // Task D - Create two course offerings
        CourseOffering offering1 = new CourseOffering(
            "OFF001", 
            "Java Fundamentals June Intake", 
            course1, 
            instructor1, 
            "2026-06-29", 
            "2026-06-30", 
            25, 
            "Physical"
        );

        CourseOffering offering2 = new CourseOffering(
            "OFF002", 
            "React Frontend July Intake", 
            course2, 
            instructor2, 
            "2026-07-01", 
            "2026-07-03", 
            20, 
            "Hybrid"
        );

        // Print the summary for both course offerings
        System.out.println("=== Course Offerings ===");
        offering1.printOfferingSummary();
        offering2.printOfferingSummary();

        // Extension task
        // Create a third course offering that reuses the same course but uses a different date
        CourseOffering offering3 = new CourseOffering(
            "OFF003", 
            "Java Fundamentals July Weekend Intake", 
            course1, 
            instructor1, 
            "2026-10-15", 
            "2026-10-20", 
            30, 
            "Online"
        );

        System.err.println("=== Extension Task: Reusing Course Profile ===");
        offering3.printOfferingSummary();
    }

}
