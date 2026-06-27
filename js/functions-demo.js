// Functions and Arrow Functions

const course = {
    courseId: "C001",
    title: "Fullstack Java with AI",
    durationHours: 120,
    level: "Intermediate",
    instructor: "John Doe"
}



// Normal function to display course details
function formatCourse(course) {
    return `${course.courseId} - ${course.title} - ${course.durationHours} hours - ${course.level} - Instructor: ${course.instructor}`;
}

// Arrow function to display course details
const formatCourseArrow = (course) => {
    return `${course.courseId} - ${course.title} - ${course.durationHours} hours - ${course.level} - Instructor: ${course.instructor}`;
}

// Short arrow function to display course details
const getCourseTitle = (course) => course.title;

console.log("=== Course Details using Normal Function ===");
console.log(formatCourse(course));

console.log("=== Course Details using Arrow Function ===");
console.log(formatCourseArrow(course));

console.log("=== Course Title using Short Arrow Function ===");
console.log(getCourseTitle(course));