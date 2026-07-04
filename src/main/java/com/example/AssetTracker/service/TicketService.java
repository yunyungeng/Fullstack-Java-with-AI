package com.example.assettracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assettracker.dto.CreateTicketRequest;
import com.example.assettracker.dto.TicketResponse;
import com.example.assettracker.exception.ResourceNotFoundException;

@Service
public class TicketService {
    private final List<TicketResponse> tickets = new ArrayList<>();
    private int ticketIdCounter = 4; // 

    public TicketService() {
        tickets.add(new TicketResponse(
            "T001",
            "Cannot access email",
            "User cannot login to company email account.",
            "Email",
            "HIGH",
            "OPEN",
            "amir@example.com",
            "2026-07-03"
        ));

        tickets.add(new TicketResponse(
            "T002",
            "Laptop is slow",
            "Operating system takes over 10 minutes to boot completely.",
            "Hardware",
            "LOW",
            "OPEN",
            "siti@example.com",
            "2026-07-04"
        ));

        tickets.add(new TicketResponse(
            "T003",
            "VPN connection not working",
            "Intermittent disconnections when attempting remote network access.",
            "Network",
            "HIGH",
            "OPEN",
            "john@example.com",
            "2026-07-04"
        ));
    }

    public List<TicketResponse> getAllTickets() {
        return tickets;
    }

    // Find a single ticket by ID or throw an error
    public TicketResponse getTicketById(String id) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Ticket " + id + " was not found"));
    }

    public TicketResponse createTicket(CreateTicketRequest request) {
        // Generate a new ticket ID
        String generatedId = String.format("T%03d", ticketIdCounter++);

        TicketResponse newTicket = new TicketResponse(
            generatedId,
            request.getTitle(),
            request.getDescription(),
            request.getCategory(),
            request.getPriority(),
            "OPEN",
            request.getCreatedBy(),
            "2026-07-04" // Set a default date or use the current date
        );
        
        tickets.add(newTicket);
        return newTicket;
    }
}
