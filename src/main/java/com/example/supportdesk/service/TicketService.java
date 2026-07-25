package com.example.supportdesk.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<TicketResponse> getTickets(String status, String category, String priority) {
        List<Ticket> tickets;

        if (hasValue(status)) {
            tickets = ticketRepository.findByStatusIgnoreCase(status.trim());
        } else if (hasValue(category)) {
            tickets = ticketRepository.findByCategoryIgnoreCase(category.trim());
        } else if (hasValue(priority)) {
            tickets = ticketRepository.findByPriorityIgnoreCase(priority.trim());
        } else {
            tickets = ticketRepository.findAll();
        }
        
        return tickets.stream()
        .map(this::toResponse)
        .toList();
    }

    public Page<TicketResponse> getTicketsPaged(int page, int size, String sortBy, String direction) {
        // Implement pagination logic here using the repository
        // For example, you can use Pageable and PageRequest to fetch paginated results
        // and then map them to TicketResponse DTOs.
        // This is a placeholder implementation; you would need to implement the actual logic.
        
        Sort sort = direction.equalsIgnoreCase("desc")
            ? Sort.by(sortBy).descending()
            : Sort.by(sortBy).ascending();
        
        Pageable pageable = PageRequest.of(page, size, sort);
        
        return ticketRepository.findAll(pageable)
            .map(this::toResponse);
    }

    // Find a single ticket by ID or throw an error
    public TicketResponse getTicketById(String id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket " + id + " was not found"));
        
            return toResponse(ticket);
    }

    public TicketResponse createTicket(CreateTicketRequest request) {
        Ticket ticket = new Ticket(
            request.getTitle().trim(),
            request.getDescription().trim(),
            request.getCategory().trim(),
            request.getPriority().trim(),
            "OPEN",
            request.getCreatedBy().trim(),   
            LocalDateTime.now()  
        );

        Ticket savedTicket = ticketRepository.save(ticket);
        return toResponse(savedTicket);
    }

    private boolean hasValue(String value) {
        return value != null && !value.trim().isBlank();
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

           
