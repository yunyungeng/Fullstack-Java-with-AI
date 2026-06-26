package com.fullstack.demo;

import com.fullstack.demo.exception.StudentNotFoundException;
import com.fullstack.demo.model.Student;
import com.fullstack.demo.repository.InMemoryStudentRepository;
import com.fullstack.demo.repository.StudentRepository;
import com.fullstack.demo.service.StudentService;
import java.util.List;

public class Day3_Assignment06_StudentServicePractice {
    public static void main(String[] args) {
        // Create Repository and Service
        StudentRepository studentRepository = new InMemoryStudentRepository();
        StudentService studentService = new StudentService(studentRepository);

        // Register at least 3 students
        System.out.println("=== Register Students ===");
        studentService.registerStudent(new Student("S001", "Roberto Chan", "roberto@example.com"));
        studentService.registerStudent(new Student("S002", "Priya Nair", "priya@example.com"));
        studentService.registerStudent(new Student("S003", "Lee Salazae", "lee@example.com"));
        System.out.println("Registered 3 students successfully.\n");

        // Print all students
        System.out.println("=== All Students ===");
        List<Student> allStudents = studentService.getAllStudents();
        for (Student student : allStudents) {
            student.printProfile();
        }

        // Find one student by ID
        System.out.println("=== Find Student By ID (S002) ===");
        Student priya = studentService.getStudentById("S002");
        priya.printProfile();

        // Search students by name using loop
        System.out.println("=== Search Student By Name Using Loop ('Lee') ===");
        List<Student> loopResults = studentService.searchByNameUsingLoop("Lee");
        for (Student s : loopResults) {
            System.out.println(s.getStudentId() + " - " + s.getStudentName());
        }
        System.out.println();

        // Search using stream
        System.out.println("=== Search Student By Name Using Stream ('Chan') ===");
        List<Student> streamResults = studentService.searchByNameUsingStream("Chan");
        for (Student s : streamResults) {
            System.out.println(s.getStudentId() + " - " + s.getStudentName());
        }
        System.out.println();


        // Missing Student Test with try/catch
        System.out.println("=== Missing Student Test ===");
        try {
            studentService.getStudentById("S999");
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

    }
}
