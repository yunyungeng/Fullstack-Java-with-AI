package com.fullstack;

public class Course {
    private String courseId;
    private String title;
    private int durationHours;
    private String level;
    private Instructor instructor;

    // Exercise 2: Two new fields
    private String category;
    private boolean active;

    // Contructor method
    public Course(String courseId, String title, int durationHours, String level, String category, boolean active) {
        this.courseId = courseId;
        this.title = title;
        this.durationHours = durationHours;
        this.level = level;
        this.category = category;
        this.active = active;
    }

    // Getter method
    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public String getLevel() {
        return level;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getCategory() {
        return category;
    }

    public boolean isActive() {
        return active;
    }

    // Setter method
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void printCourseSummary() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Duration " + durationHours + "hours");
        System.out.println("Level: " + level);

        // Exercise 2: Print Category and Status
        System.out.println("Category: " + category);
        System.out.println("Status: " + (active ? "Active" : "Inactive"));

        if (instructor == null) {
            System.out.println("Instructor: Not assigned yet");
        } else {
            System.out.println("Instructor: " + instructor.getInstructorName() + "\n");
        }
    }

}
