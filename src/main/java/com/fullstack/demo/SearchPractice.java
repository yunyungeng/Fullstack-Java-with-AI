package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;
import java.util.List;

public class SearchPractice {
    public static void main(String[] args) {
        CourseRepository repository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(repository);

        courseService.createCourse(new Course("C001", "Java Fundamentals", 14, "Beginner"));
        courseService.createCourse(new Course("C002", "React Frontend Development", 21, "Intermediate"));
        courseService.createCourse(new Course("C003", "MongoDB Basics", 10, "Beginner"));
        courseService.createCourse(new Course("C004", "Spring Boot API Development", 18, "Intermediate"));

        // Test Task C - Search via loop
        System.out.println("\n=== Beginner Courses (Using Loop) ===");
        List<Course> beginnerCoursesLoop = courseService.searchByLevelUsingLoop("Beginner");
        for (Course course : beginnerCoursesLoop) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        // Test Task D - Search via Stream
        System.out.println("\n=== Intermediate Courses (Using Stream) ===");
        List<Course> intermediateCoursesStream = courseService.searchByLevelUsingStream("Intermediate");
        for (Course course : intermediateCoursesStream) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        // Test Task E - Search by duration
        System.out.println("\n=== Courses with Duration >= 15 Hours ===");
        List<Course> longCourses = courseService.searchByMinimumDurationUsingLoop(15);
        for (Course course : longCourses) {
            System.out.println(course.getCourseId() + " - " + course.getTitle() + " (" + course.getDurationHours() + " hours)");
        }
    }
}
