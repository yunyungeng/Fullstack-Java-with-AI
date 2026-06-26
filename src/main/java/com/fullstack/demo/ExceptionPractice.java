package com.fullstack.demo;

import com.fullstack.demo.exception.CourseNotFoundException;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;

public class ExceptionPractice {
    public static void main(String[] args) {
        // Task A - Set up CourseService
        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        // Task B - Add two courses
        Course course1 = new Course(
            "C001",
            "Java Fundamentals",
            15,
            "Beginner",
            "Programming",
            true
        );

        Course course2 = new Course(
            "C002",
            "React Frontend Development",
            20,
            "Intermediate",
            "Frontend",
            true
        );

        courseService.createCourse(course1);
        courseService.createCourse(course2);

        // Task C - Find an existing course
        System.out.println("Find Existing Course: ");
        Course course = courseService.getCourseById("C001");
        course.printSummary();

        // Task D - Find a missing course and catch the exception
        System.out.println("Find Course C999 and Catch Exception: ");
        try {
            Course missingCourse = courseService.getCourseById("C999");
            missingCourse.printSummary();
        } catch (CourseNotFoundException e) {
            System.out.println("Friendly message for user: " + e.getMessage());
        }

        System.out.println(); // New line

        // Task E - Add one more try/catch block
        System.out.println("Find Course C888 and Catch Exception: ");
        try {
            courseService.getCourseById("C888");
        } catch (CourseNotFoundException e) {
            System.out.println("Cannot display course details because the course does not exist.");
        }

    }
}
