const events = [
    {
        id: "EV001",
        title: "Tech Career Fair",
        date: "2026-08-10",
        venue: "Kuala Lumpur Convention Centre",
        availableSeats: 120
    },
    {
        id: "EV002",
        title: "Web Development Bootcamp",
        date: "2026-08-15",
        venue: "Digital Learning Hub",
        availableSeats: 35
    },
    {
        id: "EV003",
        title: "AI for Business Workshop",
        date: "2026-08-20",
        venue: "Innovation Centre",
        availableSeats: 50
    }
];

// Write your code below

// 1. Select the required target elements from the DOM
const eventList = document.getElementById("eventList");
const statusText = document.getElementById("statusText");

// 2. Loop through every event object inside the data array
events.forEach(event => {
  // Create a new list item element dynamically
  const listItem = document.createElement("li");

  // Format the output properties using template literals
  let displayMessage = `${event.title} - ${event.date} - ${event.venue} - ${event.availableSeats} seats available`;

  // Challenge Task: Check if available seats fall below 50 to flag a limited state
  if (event.availableSeats < 50) {
    displayMessage += " - Limited seats";
  }

  // Inject the textual data into the list item element
  listItem.textContent = displayMessage;

  // Mount the complete list element onto the parent target ul node
  eventList.appendChild(listItem);
});

// 3. Dynamic layout feedback calculation to update status paragraph indicators
statusText.textContent = `${events.length} event(s) displayed.`;