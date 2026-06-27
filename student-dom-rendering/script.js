// Array of four students
const students = [
  { studentId: "S001", studentName: "Ignacio de Paul", email: "ignacio@example.com", status: "Active" },
  { studentId: "S002", studentName: "Ben Tan", email: "ben@example.com", status: "Inactive" },
  { studentId: "S003", studentName: "Chong Mei", email: "mei@example.com", status: "Active" },
  { studentId: "S004", studentName: "Danish Nawaz", email: "danish@example.com", status: "Active" }
];

// Select student-list div using document.getElementById
const studentList = document.getElementById("student-list");
const searchInput = document.getElementById("search-input");
const searchButton = document.getElementById("search-button");
const resetButton = document.getElementById("reset-button");

function renderStudents(studentArray) {
    studentList.innerHTML = "";

    // Show "No students found" message if array input variable is empty
    if (studentArray.length === 0) {
        const errorMessage = document.createElement("div");
        errorMessage.className = "no-results";
        errorMessage.textContent = "No students found.";
        studentList.appendChild(errorMessage);
        return;
    }

    // Otherwise, iterate and render individual cards
    studentArray.forEach((student) => {
        // Create a card for each student using document.createElement
        const card = document.createElement("div");
        card.className = "student-card";

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
}

searchButton.addEventListener("click", () => {
    // Get the search keyword from the input field, trim whitespace, and convert to lowercase
    const keyword = searchInput.value.trim().toLowerCase();

    // Filter the students array based on the keyword
    const results = students.filter((student) => {
        return student.studentName.toLowerCase().includes(keyword);
     });
    renderStudents(results);
});

resetButton.addEventListener("click", () => {
    searchInput.value = "";
    renderStudents(students);
});

