package com.example.supportdesk.controller;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.supportdesk.dto.CreateTicketRequest;
import com.example.supportdesk.dto.TicketResponse;
import com.example.supportdesk.service.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketV1Controller {

    private static final Set<String> ALLOWED_SORT_FIELDS = 
            Set.of("title", "status", "category", "priority", "createdBy", "createdAt", "updatedAt");

    private final TicketService ticketService;

    // Constructor injection for TicketService
    public TicketV1Controller(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // GET /api/v1/tickets -> returns all tickets
    @GetMapping
    public List<TicketResponse> getTickets(
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) String priority
    ) {
        return ticketService.getTickets(status, category, priority);
    }

    @GetMapping("/paged")
    public Page<TicketResponse> getTicketsPaged(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "createdAt") String sortBy,
        @RequestParam(defaultValue = "desc") String direction
    ) {
        if (page < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Page index must be more or equal to 0");
        }

        if (size < 1 || size > 50) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Page size must between 1 and 50");
        }

        if (sortBy == null || sortBy.isBlank() || !ALLOWED_SORT_FIELDS.contains(sortBy)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid sort field. Allowed fields are: " + ALLOWED_SORT_FIELDS);
        }

        String normalisedDirection = direction.toLowerCase();
        if (!Set.of("asc", "desc").contains(normalisedDirection)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sort direction must be either 'asc' or 'desc'");
        }

        return ticketService.getTicketsPaged(page, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public TicketResponse getTicketById(@PathVariable String id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody CreateTicketRequest request) {
        TicketResponse created = ticketService.createTicket(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
