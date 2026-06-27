// Select the HTML elements
const statusMessage = document.getElementById("status-message");
const studentList = document.getElementById("student-list");

// Function to render students
function renderStudents(students) {
    studentList.innerHTML = ""; // Clear the student list

    students.forEach((student) => {
        // Create a card for each student
        const card = document.createElement("div");

        // Use innerHTML to place student details inside the card
        card.innerHTML = `
            <h3>${student.studentName}</h3>
            <p><strong>ID:</strong> ${student.studentId}</p>
            <p><strong>Email:</strong> ${student.email}</p>
            <p><strong>Status:</strong> ${student.status}</p>
        `;

        // Add the card to the student list
        studentList.appendChild(card);
    });
}

// Create async function to fetch student data
async function loadStudents() {
    try {
        statusMessage.textContent = "Loading students..."; // Show loading message
        const response = await fetch("students.json");   // Fetch the student data from the JSON file

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const students = await response.json(); // Parse the JSON data

        statusMessage.textContent = ""; // Clear the loading message
        renderStudents(students); // Render the students
    } catch (error) {
        statusMessage.textContent = `Error: ${error.message}`; // Show error message
    }
}

loadStudents(); // Call the function to initiate database collection lookup