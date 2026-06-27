/*
Java
List<Courses> courses = new ArrayList<>(); 

JS
const courses = [];
*/

const courses = [
    {
        id: "C001",
        title: "Java Fundamentals",
        durationHours: 10,
        level: "Beginner"
    },
    {
        id: "C002",
        title: "React Frontend Development",
        durationHours: 16,
        level: "Intermediate"
    },
    {
        id: "C003",
        title: "MongoDB Basics",
        durationHours: 8,
        level: "Advanced"
    }
];

console.log("=== Course Details ===");
// `` called backticks, used for template literals in JavaScript
// Enhanced for loop in Java is similar to for...of loop in JavaScript
for (const course of course) {
    console.log(`Course ID: ${course.id} - Title: ${course.title} - Duration: ${course.durationHours} hours - Level: ${course.level}`);
}

console.log("\nTotal Courses:" + courses.length); // .size() in Java is similar to .length in JavaScript