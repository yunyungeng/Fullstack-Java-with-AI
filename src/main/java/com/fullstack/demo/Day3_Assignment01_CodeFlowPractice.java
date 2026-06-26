package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;

public class Day3_Assignment01_CodeFlowPractice {
    public static void main(String[] args) {
        /* 
        Task A - Create the repository and service

        Why do we create the repository first?
        - We create repository first because it is responsible for managing the data storage and retrieval of course information.
        - The repository is responsible for the actual reading and writing of raw data to an internal list or data store.

        Why does CourseService need CourseRepository?
        - CourseService needs CourseRepository to perform data operations related to courses, such as adding, retrieving, updating, or deleting course information.
        - It does not handle the storage or retrieval of data directly, but instead relies on the repository to do so.
        */
        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        // Task B - Create one new course
        // Create a new course object
        Course newCourse = new Course(
            "C004",
            "Spring Boot API Development",
            18,
            "Intermediate",
            "Programming",
            true
        );

        // Task C - Retrieve the course by ID

        // Add the new course to the repository using the service
        // The service class validates the course data and delegates the actual saving of the course to the repository.
        courseService.createCourse(newCourse);

        // Retrieve the course by its ID (returns the course object if found, or throws an exception if not found)
        Course retrievedCourse = courseService.getCourseById("C004");

        // Print the course summary
        retrievedCourse.printSummary();

        /* README reflection
        When getCourseById("C004") is called, which file does the request go to first, second, and third?
        1. The request goes to the CourseService class first, which handles the business logic and validation.
        2. The request then goes to the InMemoryCourseRepository class, which is responsible for managing the data storage and retrieval of course information.
        3. Finally, the request goes to the Course class, which represents the course entity and contains the course data.
        */
    }
}
