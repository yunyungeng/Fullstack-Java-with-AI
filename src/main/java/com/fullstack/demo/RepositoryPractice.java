package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import java.util.List;
import java.util.Optional;

public class RepositoryPractice {
    public static void main(String[] args) {

        // Task A - Create the repository using the interface type
        // The variable type is CourseRepository, but the actual object is InMemoryCourseRepository.
        CourseRepository courseRepository = new InMemoryCourseRepository();

        // Task B - Save three courses directly through the repository
        // Create three new course objects
        Course course1 = new Course(
            "C005",
            "API Documentation",
            7,
            "Beginner");

        Course course2 = new Course(
            "C006",
            "Java Collections Practice",
            12,
            "Beginner");

        Course course3 = new Course(
            "C007",
            "Clean Code Basics",
            8,
            "Intermediate");

        // Save the courses to the repository
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        // Task C - Print all courses
        // Find all courses in the repository and print their summaries
        System.out.println("All Courses:");
        List<Course> allCourses = courseRepository.findAll();
        for (Course course : allCourses) {
            course.printSummary();
        }

        // Task D - Find one course using Optional
        System.out.println("Finding Course:");
        Optional<Course> optionalCourse = courseRepository.findById("C006");
        if (optionalCourse.isPresent()) {
            Course foundCourse = optionalCourse.get();
            foundCourse.printSummary();
        } else {
            System.out.println("Course not found.");
        }

        // Task E - Check if a course exists
        System.out.println("Check if Course exists: ");
        boolean exists = courseRepository.existsById("C007");
        System.out.println("C007 exists: " + exists);
    }
}
