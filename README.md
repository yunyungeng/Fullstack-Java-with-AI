# Day 7: Reflections

## Exercise 1: Install and Secure MongoDB

**1. What is the purpose of the `admin` database?**

It's the administrative database that stores system-level user credentials and roles. Users created here can be granted cluster-wide privileges (like root), and it's where authentication for privileged operations is managed.

**2. Why should an application use its own database user instead of the root administrator?**

The app only needs read/write on its own database, not full cluster control. If the app's credentials leak, the damage is confined to one database rather than the entire server. 

**3. What is the difference between authentication and authorization?**

Authentication verifies who you are (validating identity via username/password). Authorization determines what you're allowed to do (which databases/actions your assigned roles permit)

**4. What would happen if authentication was disabled on a production database?**

Anyone able to reach the server's port could connect anonymously with full access which include reading, modifying, or deleting all data, and creating/dropping users.

## Exercise 5: Persistence Checkpoint

**Test Steps:** 
1. Started MongoDB under the supportdesk profile. 
2. Created a ticket via `POST /api/tickets`, confirmed it via `GET /api/tickets`.
3. Stopped the app, and restarted it. 
4. Ran `GET /api/tickets` again.

**Ticket ID Created:** `6a62ec487f3415e6121c78b6`

**Confirmation:** After restarting the application, `GET /api/tickets` still returned the ticket with ID `6a62ec487f3415e6121c78b6`, confirming the data is persisted in MongoDB rather than held in memory.