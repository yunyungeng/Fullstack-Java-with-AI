// Array of four students
const students = [
    { studentId: "S001", studentName: "Roberto Chan", email: "roberto@example.com", status: "Active" },
    { studentId: "S002", studentName: "Priya Nair", email: "priya@example.com", status: "Active" },
    { studentId: "S003", studentName: "Lee Salazae", email: "lee@example.com", status: "Inactive" },
    { studentId: "S004", studentName: "Ben Tan", email: "ben@example.com", status: "Active" }
]

// Select student-list div using document.getElementById
const studentList = document.getElementById("student-list");

// Loop through the students array using forEach
students.forEach(student => {
    // Create a card for each student using document.createElement
    const card = document.createElement("div");

    // Use innerHTML to place student details inside the card
    card.innerHTML = `
        <h3>${student.studentName}</h3>
        <p><strong>ID:</strong> ${student.studentId}</p>
        <p><strong>Email:</strong> ${student.email}</p>
        <p><strong>Status:</strong> ${student.status}</p>
    `;

    // Use appendChild to add the card to the page container
    studentList.appendChild(card);
});