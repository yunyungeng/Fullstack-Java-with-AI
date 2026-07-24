package com.example.supportdesk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assettracker.exception.ResourceNotFoundException;
import com.example.supportdesk.dto.CreateTicketRequest;
import com.example.supportdesk.dto.TicketResponse;
import com.example.supportdesk.model.Ticket;
import com.example.supportdesk.repository.TicketRepository;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketResponse> getAllTickets() {
        return ticketRepository.findAll()
        .stream()
        .map(this::toResponse)
        .toList();
    }

    // Find a single ticket by ID or throw an error
    public TicketResponse getTicketById(String id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket " + id + " was not found"));
        
            return toResponse(ticket);
    }

    public TicketResponse createTicket(CreateTicketRequest request) {
        Ticket ticket = new Ticket(
            request.getTitle(),
            request.getDescription(),
            request.getCategory(),
            request.getPriority(),
            "OPEN",
            request.getCreatedBy(),
            "2026-07-04" // Set a default date or use the current date
        );
        
        Ticket savedTicket = ticketRepository.save(ticket);
        return toResponse(savedTicket);
    }

    // Helper to convert an Asset entity to an AssetResponse DTO.
    private TicketResponse toResponse(Ticket ticket) {
        return new TicketResponse(
            ticket.getId(),
            ticket.getTitle(),
            ticket.getDescription(),
            ticket.getCategory(),
            ticket.getPriority(),
            ticket.getStatus(),
            ticket.getCreatedBy(),
            ticket.getCreatedAt()
        );
    }
}

           
