// JS does not require classes for simple data.
// We can represent a course as an object literal with properties.

/*
Java:
    1. Stricter type checking
    2. Class-based structure
    3. Private fields and methods (getter and setter)
    4. Compile-time errors
    5. More boilerplate code

JavaScript:
    1. Dynamic typing
    2. Prototype-based structure
    3. No private fields (ES6 introduced private fields with #)
    4. Runtime errors
    5. Less boilerplate code
    6. Object literals and functions can be used to create objects without classes
*/

// To run, type `node javascript-demo.js` in the terminal.
const course = {
    courseId: "C001",
    title: "Fullstack Java with AI",
    durationHours: 120,
    level: "Intermediate",
    instructor: "John Doe"
};

console.log("=== Course Details ===");
console.log("Course ID:", course.courseId);
console.log("Title:", course.title);
console.log("Duration (hours):", course.durationHours);
console.log("Level:", course.level);
console.log("Instructor:", course.instructor);

console.log(`=== Course Summary ===`);
console.log(`Course ID: ${course.courseId}`);
console.log(`Title: ${course.title}`);
console.log(`Duration (hours): ${course.durationHours} hours`);
console.log(`Level: ${course.level}`);
console.log(`Instructor: ${course.instructor}`);
