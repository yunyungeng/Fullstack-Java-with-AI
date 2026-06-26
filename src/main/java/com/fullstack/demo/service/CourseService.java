package com.fullstack.demo.service;

import com.fullstack.demo.exception.CourseNotFoundException;
import com.fullstack.demo.exception.DuplicateCourseException;
import com.fullstack.demo.exception.InvalidCourseException;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.model.Instructor;
import com.fullstack.demo.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private final CourseRepository courseRepository;

    // Constructor to initialize the CourseService with a CourseRepository
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Method to create a new course with validation and duplicate check
    public Course createCourse(Course course) {
        // Check that the course object is not null
        // If it is null, throw InvalidCourseException
        if (course == null) {
            throw new InvalidCourseException("Course cannot be null.");
        }

        // Run the remaining field validations (ID, title, duration, level)
        validateCourse(course);

        // Check for duplicate course ID
        if (courseRepository.existsById(course.getCourseId())) {
            throw new DuplicateCourseException("Course with ID " + course.getCourseId() + " already exists.");
        }

        // Save the course to the repository
        return courseRepository.save(course);
    }

    // Method to retrieve a course by its ID, throwing an exception if not found
    public Course getCourseById(String courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));
    }

    // Method to retrieve all courses from the repository
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Method to search courses by title keyword
    public List<Course> searchByTitle(String keyword) {
        String safeKeyword = (keyword == null) ? "" : keyword.trim().toLowerCase();

        // String safeKeyword;

        // if (keyword == null) {
        //     safeKeyword = "";
        // } else {
        //     safeKeyword = keyword.trim().toLowerCase();
        // }

        return courseRepository.findAll().stream()
                .filter(course -> course.getTitle().toLowerCase().contains(safeKeyword))
                .toList();
    }

    // Method to search courses by title using Loop
    public List<Course> searchByTitleUsingLoop(String keyword) {
        String safeKeyword = keyword == null ? "" : keyword.trim().toLowerCase();
        List<Course> results = new ArrayList<>();

        for (Course course : courseRepository.findAll()) {
            if (course.getTitle().toLowerCase().contains(safeKeyword)) {
                results.add(course);
            }
        }
        return results;
    } 

    // Day 3 Exercise 05 - Search by level using Loop
    public List<Course> searchByLevelUsingLoop(String level) {
        String safeLevel = level == null ? "" : level.trim();
        List<Course> results = new ArrayList<>();

        for (Course course : courseRepository.findAll()) {
            if (course.getLevel().equalsIgnoreCase(safeLevel)) {
                results.add(course);
            }
        }
        return results;
    }

    // Day 3 Exercise 05 - Search by level using Stream
    public List<Course> searchByLevelUsingStream(String level) {
        String safeLevel = level == null ? "" : level.trim();

        return courseRepository.findAll().stream()
                .filter(course -> course.getLevel().equalsIgnoreCase(safeLevel))
                .toList();
    }

    // Method to filter courses by level
    public List<Course> filterByLevel(String level) {
        String safeLevel = (level == null) ? "" : level.trim().toLowerCase();

        return courseRepository.findAll().stream()
                .filter(course -> course.getLevel().toLowerCase().equalsIgnoreCase(safeLevel))
                .toList();
    }

    // Method to filter courses by Instructor name
    public List<Course> searchByInstructorName(String instructorName) {
        String safeInstructorName = (instructorName == null) ? "" : instructorName.trim().toLowerCase();

        return courseRepository.findAll().stream()
                .filter(course -> course.getInstructor() != null)
                .filter(course -> course.getInstructor().getInstructorName().toLowerCase().contains(safeInstructorName))
                .toList();
    }

    // Method to assign an instructor to a course by course ID
    public Course assignInstructor(String courseId, Instructor instructor) {
        Course course = getCourseById(courseId);
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

    public String deleteCourse(String courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new CourseNotFoundException(courseId);
        }
        courseRepository.deleteById(courseId);
        return courseId; // Return the deleted course ID for confirmation
    }

    public Course updateDuration(String courseId, int newDurationHours) {
        if (newDurationHours <= 0) {
            throw new InvalidCourseException("Duration must be greater than zero.");
        }
        Course course = getCourseById(courseId);
        course.setDurationHours(newDurationHours);
        return courseRepository.save(course);
    }

    // Day 3 Exercise 05 - Add search by duration
    public List<Course> searchByMinimumDurationUsingLoop(int minimumHours) {
        List<Course> results = new ArrayList<>();

        for (Course course : courseRepository.findAll()) {
            if (course.getDurationHours() >= minimumHours) {
                results.add(course);
            }
        }
        return results;
    }

    // Method to validate the course fields
    private void validateCourse(Course course) {
        if (course == null) {
            throw new InvalidCourseException("Course cannot be null.");
        }
        if (isBlank(course.getCourseId())) {
            throw new InvalidCourseException("Course ID cannot be null or empty.");
        }
        if (isBlank(course.getTitle())) {
            throw new InvalidCourseException("Course title cannot be null or empty.");
        }
        if (course.getDurationHours() <= 0) {
            throw new InvalidCourseException("Course duration must be greater than zero.");
        }
        if (isBlank(course.getLevel())) {
            throw new InvalidCourseException("Course level cannot be null or empty.");
        }
        if (isBlank(course.getCategory())) {
            throw new InvalidCourseException("Course category cannot be null or empty.");
        }
    }

    // Helper method to check if a string is blank
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
