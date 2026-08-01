# Day 10

## Exercise 1: Add Versioned Ticket API Endpoints

**Why might a company keep both /api/tickets and /api/v1/tickets temporarily?**

Because existing clients (mobile apps, other services, scripts) are already calling the old /api/tickets and would break instantly if it vanished. Versioning lets you introduce the new structure without forcing everyone to switch at once.
