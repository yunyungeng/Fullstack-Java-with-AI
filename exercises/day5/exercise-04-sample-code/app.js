const API_BASE_URL = "http://localhost:8081/api";

// Write your JavaScript here.
// 1. Select the original HTML structure elements
const loadButton = document.getElementById("loadButton");
const statusText = document.getElementById("statusText");
const eventList = document.getElementById("eventList");

// --- Challenge Task: Dynamic UI Injection ---
// Create a search container wrapper to keep our workspace neat
const searchContainer = document.createElement("div");
searchContainer.style.marginTop = "20px";
searchContainer.style.padding = "15px";
searchContainer.style.border = "1px dashed #ccc";
searchContainer.style.borderRadius = "5px";

// Create heading for the search segment
const searchHeading = document.createElement("h3");
searchHeading.textContent = "Search Event by ID";
searchContainer.appendChild(searchHeading);

// Create the text input element
const searchInput = document.createElement("input");
searchInput.type = "text";
searchInput.id = "searchInput";
searchInput.placeholder = "e.g., EV001";
searchInput.style.marginRight = "8px";
searchContainer.appendChild(searchInput);

// Create the submission action button
const searchButton = document.createElement("button");
searchButton.id = "searchButton";
searchButton.textContent = "Search Event";
searchContainer.appendChild(searchButton);

// Insert the search box directly after our event list element in the DOM tree
eventList.after(searchContainer);
// --------------------------------------------

// 2. Helper function to create clean text output matching instructions
function createEventText(event) {
    return `${event.title} - ${event.date} - ${event.venue} - ${event.availableSeats} seats available`;
}

// 3. Main asynchronous request logic to fetch and render all events
async function loadAllEvents() {
    // Show a loading status message while the network transaction processes
    statusText.textContent = "Loading events... Please wait.";
    eventList.innerHTML = ""; // Clear out previous list data fields

    try {
        const response = await fetch(`${API_BASE_URL}/events`);
        
        // Throw an explicit runtime error block if response code is not successful (2xx status)
        if (!response.ok) {
            throw new Error(`HTTP Error! Status: ${response.status}`);
        }

        const events = await response.json();

        // Check if there are no items in the list array
        if (events.length === 0) {
            statusText.textContent = "No available events found.";
            return;
        }

        // Display every event inside the unordered list item nodes
        events.forEach(event => {
            const listItem = document.createElement("li");
            listItem.textContent = createEventText(event);
            eventList.appendChild(listItem);
        });

        // Show a successful state message once loaded
        statusText.textContent = "Events loaded successfully!";

    } catch (error) {
        // Intercept network failure or exception traces and update status to a meaningful error message
        statusText.textContent = `Failed to load events: ${error.message}`;
    }
}

// 4. Asynchronous request logic for the Challenge Task (Search event by single ID)
async function searchEventById() {
    const eventId = searchInput.value.trim();
    
    // Validate input to ensure user has entered a value
    if (!eventId) {
        statusText.textContent = "Please enter an Event ID to search.";
        return;
    }

    // Show a loading status message while the network transaction processes
    statusText.textContent = `Searching for event ID: ${eventId}...`;
    eventList.innerHTML = ""; // Clear out previous list data fields

    try {
        const response = await fetch(`${API_BASE_URL}/events/${eventId}`);
        
        // Throw an explicit runtime error block if response code is not successful (2xx status)
        if (!response.ok) {
            throw new Error(`HTTP Error! Status: ${response.status}`);
        }
        
        const event = await response.json();

        // Display the found event inside the unordered list item node
        const listItem = document.createElement("li");
        listItem.textContent = createEventText(event);
        listItem.style.fontWeight = "bold";
        eventList.appendChild(listItem);

        statusText.textContent = `Event ID: ${eventId} found successfully!`;

    } catch (error) {
        // Intercept network failure or exception traces and update status to a meaningful error message
        statusText.textContent = `Failed to find event ID: ${eventId}. Error: ${error.message}`;
    }
}

// . Connect user interface button triggers to their corresponding execution flows
loadButton.addEventListener("click", loadAllEvents);
searchButton.addEventListener("click", searchEventById);