# Day 10

## Exercise 1: Add Versioned Ticket API Endpoints

**Why might a company keep both /api/tickets and `/api/v1/tickets` temporarily?**

Because existing clients (mobile apps, other services, scripts) are already calling the old `/api/tickets` and would break instantly if it vanished. Versioning lets you introduce the new structure without forcing everyone to switch at once.

## Exercise 2: Create a Ticket Report by Status

**Why is a grouped report endpoint better than asking the frontend to download all tickets and count them manually?**

The database counts server-side and returns just a few summary rows, instead of sending thousands of full tickets over the network for the browser to count. It's faster, uses less bandwidth and memory, and scales as ticket volume grows.

## Exercise 3: Create a Ticket Report by Priority

**How could this report help a support manager decide where to assign staff?**

It shows where the workload is concentrated. A large HIGH-priority count signals urgent tickets that need more staff directed there quickly, while mostly LOW-priority means resources can be spread more evenly. It turns raw tickets into a quick view for staffing decisions.

## Exercise 4: Create a Simple API Documentation Endpoint

**Why is API documentation useful before frontend integration?**

It tells frontend developers exactly what endpoints exist, what to send, and what they'll get back, so they can build against the API without guessing or constantly asking the backend team.

## Exercise 5: Backend Milestone Review

Your task is to review your Support Desk Ticket API and prove that the backend is ready for frontend integration.

Tick each item once completed:

1. [/] Project runs successfully
2. [/] MongoDB connection works
3. [/] Ticket model uses @Document and @Id
4. [/] TicketRepository extends MongoRepository
5. [/] Basic CRUD endpoints work
6. [/] Filtering works
7. [/] Pagination works
8. [/] Sorting works
9. [/] Duplicate or validation errors return clear responses
10. [/] Register endpoint works
11. [/] Login endpoint returns JWT
12. [/] Protected endpoints reject missing token
13. [/] Protected endpoints accept valid token
14. [/] Versioned /api/v1 routes exist
15. [/] Report endpoint works
16. [/] API documentation endpoint exists
17. [/] .http file contains test evidence


**What is one thing you would improve before connecting this backend to React?**

Refresh tokens since it expires after 60 minutes and the user gets logged out. It should refresh without forcing the user to log in again.