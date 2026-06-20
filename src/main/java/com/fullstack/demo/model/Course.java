package com.fullstack.demo.model;

public class Course {
    private String courseId;
    private String title;
    private int durationHours;
    private String level;
    private Instructor instructor;

    // Day 1 Exercise 02: Two new fields
    private String category;
    private boolean active;

    // Task 3: Contructor method
    public Course(String courseId, String title, int durationHours, String level, String category, boolean active) {
        setCourseId(courseId);
        setTitle(title);
        setDurationHours(durationHours);
        setLevel(level);
        setCategory(category);
        setActive(active);
    }

    // Task 5: Helper method for string validation
    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " is required.");
        }
        return value.trim();
    }

    // Task 4: Add getters and setters
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = requireText(courseId, "Course ID");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = requireText(title, "Title");
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        if (durationHours <= 0) {
            throw new IllegalArgumentException("Duration must be more than 0 hours.");
        }
        this.durationHours = durationHours;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = requireText(level, "Level");
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = requireText(category, "Category");
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    // get, set, is methods

    public String getSummary() {
        String instructorName = instructor == null ? "Not assigned yet" : instructor.getInstructorName();
        return "Course ID: " + courseId 
        + ", Title: " + title 
        + ", Duration: " + durationHours + " hours, " 
        + ", Level: " + level 
        + ", Category: " + category 
        + ", Status: " + (active ? "Active" : "Inactive")
        + ", Instructor: " + instructorName;
    }

    public void printSummary() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Duration: " + durationHours + " hours");
        System.out.println("Level: " + level);

        // Exercise 2: Print Category and Status
        System.out.println("Category: " + category);
        System.out.println("Status: " + (active ? "Active" : "Inactive"));

        if (instructor == null) {
            System.out.println("Instructor: Not assigned yet" + "\n");
        } else {
            System.out.println("Instructor: " + instructor.getInstructorName() + "\n");
        }
    }
}
