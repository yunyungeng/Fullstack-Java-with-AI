# Day 8

## Exercise 4: Query Test File and Notes

### Answer these questions:

**1. Which query parameters did you implement?**

For filtering on `GET /api/tickets`: `status`, `priority`, and `category`

For pagination on `GET /api/tickets/paged`: `page`, `size`, `sortBy`, and `direction`, with defaults of `page=0`, `size=5`, `sortBy=createdAt`, `direction=desc`.

**2. Which fields did you index?**

I put indexes on `status`, `priority`, `category`, `createdBy`, and `createdAt`.

**3. Why should an API use pagination?**

If there is no pagination, the API sends back every single ticket at once. If there are thousands of tickets, that response is huge and slow. Pagination sends back a small group at a time (like 5 per page), so it stays fast no matter how many tickets there are.

**4. What log messages appear when you call the filtering endpoint?**

When I call `GET /api/tickets?status=OPEN`, I see these lines in the terminal:

```
INFO 15684 --- [SupportDesk] [nio-8080-exec-7] c.e.supportdesk.service.TicketService    : Fetching tickets with status=OPEN, priority=null, category=null
INFO 15684 --- [SupportDesk] [nio-8080-exec-6] c.e.supportdesk.service.TicketService    : Found 8 ticket(s)
```

**5. What endpoint proves your sorting works?**

`GET /api/tickets/paged?page=0&size=5&sortBy=createdAt&direction=desc`

This gives tickets from newest to oldest. If I change `direction=desc` to `direction=asc`, the order flips to oldest first. Seeing the order change proves the sorting is really working.

