# Day 6

## Exercise 5: Create an HTTP Test File

**A short note listing which endpoints worked**
- `GET /api/health` - Returns `200 OK`
- `GET /api/About` - Returns `200 OK`
- `GET /api/tickets` - Returns `200 OK`
- `GET /api/tickets/T001` - Returns `200 OK`
- `GET /api/tickets/T999` - Returns `404 Not Found`
- `POST /api/tickets` **(Valid Body)** - Returns `201 Created`
- `POST /api/tickets` **(Blank Fields)** - Returns `400 Bad Request`

**One example of a successful response**

`POST http://localhost:8080/api/tickets`
```
{
    "id": "T005",
    "title": "Printer not responding",
    "description": "The department printer in Room 302 is jammed and throwing an offline error code.",
    "category": "Hardware",
    "priority": "MEDIUM",
    "status": "OPEN",
    "createdBy": "annie@company.com",
    "createdAt": "2026-07-04"
}
```

**One example of an error response**

`POST http://localhost:8080/api/tickets`
```
{
    "errors": [
        {
            "field": "title",
            "message": "Title is required"
        },
        {
            "field": "priority",
            "message": "Priority is required"
        },
        {
            "field": "category",
            "message": "Category is required"
        },
        {
            "field": "description",
            "message": "Description is required"
        },
        {
            "field": "createdBy",
            "message": "CreatedBy is required"
        }
    ],
    "message": "Validation failed"
}
```