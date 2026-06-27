const student = {
    studentId: "S001",
    studentName: "Aina Rahman",
    email: "ainan@example.com",
    status: "Active"
}

// Normal function
function formatStudent(student) {
    return `${student.studentId} - ${student.studentName} (${student.status})`;
}

// Arrow function
const getEmail = (student) => {
    return student.email;
};

// Short arrow function
const getStudentStatus = (student) => student.status;

console.log("=== Student Details ===");
console.log(formatStudent(student));
console.log(getEmail(student));
console.log(getStudentStatus(student));