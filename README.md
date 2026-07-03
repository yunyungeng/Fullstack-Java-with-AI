# Day 5

## Exercise 1: HTTP Investigation

Test at least five different API requests.

Your investigation must include:

1. One successful request that returns a list
2. One successful request that returns one item
3. One request for an item that does not exist
4. One successful create request
5. One failed create request

For each request, record the following information:

| Method | URL | Status Code | Response Type | What Happened? |
| :---: | --- | :---: | :---:| --- |
| `GET` | http://localhost:8081/api/course-offerings | `200 OK` | List | **Success:** The server retrieved the internal array containing all active course offerings (CO001 and CO002) and sent them back as a JSON array.
| `GET` | http://localhost:8081/api/course-offerings/CO001 | `200 OK` | Single Object | **Success:** The server found an exact match for the ID CO001 inside the array and returned the individual course offering details object
| `GET` | http://localhost:8081/api/course-offerings/C999 | `404 Not Found` | Error Object | **Failure:** The server scanned the collection for an entry matching ID C999. Because it does not exist, it returned an error object stating the resource was not found.
| `POST` | http://localhost:8081/api/course-offerings | `201 Created` | Single Object | **Success:** The server validated the input payload, dynamically generated a new ID (CO003), appended it to the database array, and returned the newly created object.
| `POST` | http://localhost:8081/api/course-offerings | `400 Bad Request` | Error Object | **Failure:** The request payload contained empty fields and an invalid capacity of 0. The server's validation logic caught these issues and rejected the request, returning an array of field errors.

## Questions to Answer
After completing your table, answer the following questions:

**1. Which request returned a successful list response?**
- The `GET http://localhost:8081/api/course-offerings` request successfully returned a list containing the complete collection of active course offering records.

**2. Which request returned a not-found response?**
- The `GET http://localhost:8081/api/course-offerings/C999` request returned a `404 Not Found` response because the identifier `C999` does not match any entry in the database.

**3. Which request returned a validation error?**
- The second `POST` request (targeting `http://localhost:8081/api/course-offerings` with blank values and a capacity of `0`) failed with a `400 Bad Request` validation error block.

**4. What is the difference between a successful response and an error response?**
- **Successful Responses:** Signal that the client's payload met all criteria and the request completed as intended. The server delivers the requested resources or confirmation objects.

- **Error Responses:** Indicate that code execution halted early because something went wrong (invalid input fields, missing resources, etc.). The body changes into an error payload describing the problem so the client application can react without crashing.

**5. Why is the status code important for frontend developers?**
- Status codes function as explicit operational flags for frontend logic. Instead of parsing complex raw response text to figure out if an operation worked, code can evaluate the numeric HTTP status code programmatically. For example, a `200` or `201` status tells a framework like React that it is safe to display data or show a success toast , while a `400` or `404` status can instantly toggle user-facing error panels or validation highlight rings.

## Short Reflection
**What is one thing you understand better about REST after this exercise?**
- Doing this investigation helped me see that a REST API is essentially a structured web doorway built directly on top of our backend logic files. The HTTP verbs (`GET`, `POST`) act as explicit instructions telling the server what operation to run, and the status codes provide a clear communication bridge so that our user interface knows exactly what happened behind the scenes without guessing.

# Exercise 2: REST API Design

## 1. API Specification Table

| Resource | Method | Endpoint | Purpose | Request Body Needed? | Success Status | Possible Error Status
| :---: | :---: | --- | --- | :---: | :---: | :---: |
| **events** | `GET` | `/api/events` | View availabale events | No | `200 OK` | `500 Internal Error` |
| **events** | `GET` | `/api/events/{eventId}` | View details of one event | No | `200 OK` | `404 Not Found` |
| **bookings** | `POST` | `/api/bookings` | Create a booking | Yes | `201 Created` | `400 Bad Request`, `404 Not Found` |
| **bookings** | `GET` | `/api/bookings` | View all bookings | No | `200 OK` | `401 Unauthorized`|
| **bookings** | `GET` | `/api/bookings/{bookingId}` | View details of one booking | No | `200 OK` | `404 Not Found` |
| **bookings** | `DELETE` | `/api/bookings/{bookingId}` | Cancel a booking | No | `204 No Content` | `404 Not Found`, `400 Bad Request` |

## 2. Request and Response Planning
| Endpoint | Request Body Description |
| --- | --- |
`POST /api/bookings` | A JSON object containing reference keys linking the user to the event: `eventId` (String/Long) and `ticketsRequested` (Integer). Authentication handles the user identity implicitly.

## 3. Error Planning
| Error Case | Related Endpoint | Suitable Status Code | Explanation |
| :---: | --- | :---: | --- |
| **Event Fully Booked** | `POST /api/bookings` | `400 Bad Request` | The request cannot be completed because the business rules prohibit ticket generation if the event's capacity has already reached its maximum limit.
| **Booking Does Not Exist** | `GET /api/bookings/{bookingId}` | `404 Not Found` | The database could not match the path parameter `{bookingId}` with an active booking record, meaning the resource is completely missing.
| **Double Cancellation Attempt** | `DELETE /api/bookings/{bookingId}` | `400 Bad Request` | The frontend is attempting to cancel a record that has already been flagged as cancelled. The server rejects this redundant modification.

## 4. Explanation
**Why your endpoint names follow REST principles**

My designed endpoints follow core REST principles by using nouns instead of verbs for resource paths and relying on standard HTTP methods to dictate actions. Instead of using action-style URLs like `/getAllBookings` or `/cancelBooking`, the API exposes clean collections (`/api/events` and `/api/bookings`).

The intent of the request is handled purely by the HTTP verb used:

- `GET` reads the data
- `POST` creates the data
- `DELETE` removes or cancels the data

## Exercise 5: Add Booking Endpoints to the Mock API
All core endpoints and components have been successfully completed:

- `GET /api/bookings`: Successfully extracts all saved booking transactions out of local state array storage.
- `GET /api/bookings/{id}`: Safely screens individual records by resource identifiers with a structured `404 Not Found` path handler setup for missing items.
- `POST /api/bookings`: Parses data models, checks parameters, validates event references, screens seat availability, and subtracts seats upon completing successful transactions.
- `DELETE /api/bookings/{id}` **(Optional Task)**: Implemented to flip status flags to `"CANCELLED"` and safely refund the original seat amount back to the event record.