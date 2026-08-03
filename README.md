# Day 10

## Exercise 1: Add Versioned Ticket API Endpoints

**Why might a company keep both /api/tickets and `/api/v1/tickets` temporarily?**

Because existing clients (mobile apps, other services, scripts) are already calling the old `/api/tickets` and would break instantly if it vanished. Versioning lets you introduce the new structure without forcing everyone to switch at once.

## Exercise 2: Create a Ticket Report by Status

**Why is a grouped report endpoint better than asking the frontend to download all tickets and count them manually?**

The database counts server-side and returns just a few summary rows, instead of sending thousands of full tickets over the network for the browser to count. It's faster, uses less bandwidth and memory, and scales as ticket volume grows.