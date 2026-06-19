# Day 1 Exercise 01

## Tasks
### 1. What is the purpose of `Course.java`?
It acts as the blueprint to model a specific training course or class. It stores course details such as the ID, title, length, difficulty, and the instructor who teaches the course. It also has a `printSummary()` method prints the summary of the course information.

### 2. What is the purpose of `Instructor.java`?
It acts as the blueprint to model a teacher or instructor. It stores the instructor's details such as their ID, name, and their field of expertise. It also has a `printProfile()` method to print the instructor's information. It is used so a `Course` object can reference who is the instructor for that course.

### 3. What is the purpose of `Student.java`?
It acts as the blueprint to model a student in your application. It stores the information of the students such as their ID, names, and emails. It has a `printProfile()` method to print the student's information.

### 4. What does the constructor do?
A method that initializes a new object the moment it is created. For example:
```
Student student1 = new Student("S001", "Alice Johnson", "alice.johnson@example.com");
```
It takes in the values you pass and assigns them to the object's field, so the object is ready to use instead of having empty fields.

### 5. Why are the fields marked as `private`?
It is to protect the data, also called **Encapsulation**. It is to prevent outside classes from reading or modifying them directly. If an outside class needs to see the data, they must used the public getter/setter methods (e.g., `getName()`).

### 6. What does `course1.assignInstructor(instructor1);` mean?
This calls a method on the `course1` object, passing in an `instructor1` object, to link that instructor to that course. It basically means assigning `instructor1` (John Doe) to be the teacher of `course1` (Introduction to Computer Science). The `printSummary()` would then show the instructor's name instead of "Not assigned yet."

### 7. What does `student1.printProfile();` do?
It calls a method on the `student1` object which prints their student ID, name and email to the console. For example, for `student1` it would print:

```
Student ID: S001
Name: Alice Johnson
Email: alice.johnson@example.com
```

## AI-Assisted Task
**Prompt:** Explain this Java class to someone who already knows Python or C++.

**1. One explanation from AI that helped you.**

The AI explained that a Java class is similar to a class in Python or C++. It described how fields (variables) store an object's data, while methods (functions) define the actions the object can perform.

**2. One part you still needed the trainer or your own reading to understand.**


The use of `this` inside the constructor. I understood that the constructor was setting up the object's fields, but I didn't immediately get why lines like `this.courseId = courseId;` needed the this part at all, since the parameter and the field have the same name. 