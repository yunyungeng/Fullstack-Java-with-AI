package com.fullstack.demo.model;

public class CourseOffering {
    private String offeringId;
    private String offeringName;
    private Course course;
    private Instructor instructor;
    private String startDate;
    private String endDate;
    private int capacity;

    // Extra field
    private String deliveryMode;

    // Constructor method
    public CourseOffering(String offeringId, String offeringName, Course course, Instructor instructor, String startDate, String endDate, int capacity, String deliveryMode) {
        this.offeringId = offeringId;
        this.offeringName = offeringName;
        this.course = course;
        this.instructor = instructor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
        this.deliveryMode = deliveryMode;
    }

    // Getter methods
    public String getOfferingId() {
        return offeringId;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public Course getCourse() {
        return course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public String getSummary() {
        return "Course Offering ID: " + offeringId + "\n" +
               "Offering Name: " + offeringName + "\n" +
               "Course: " + course.getTitle() + "\n" +
               "Instructor: " + instructor.getInstructorName() + "\n" +
               "Start Date: " + startDate + "\n" +
               "End Date: " + endDate + "\n" +
               "Capacity: " + capacity + "\n" +
               "Delivery Mode: " + deliveryMode;
    }

    // Print the summary of the course offering
    public void printOfferingSummary() {
        System.out.println("Course Offering ID: " + offeringId);
        System.out.println("Offering Name: " + offeringName);

        // Fetch the course title
        System.out.println("Course: " + course.getTitle());
        
        // Fetch the instructor name
        System.out.println("Instructor: " + instructor.getInstructorName());

        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Capacity: " + capacity);
        System.out.println("Delivery Mode: " + deliveryMode + "\n");
    }
}
