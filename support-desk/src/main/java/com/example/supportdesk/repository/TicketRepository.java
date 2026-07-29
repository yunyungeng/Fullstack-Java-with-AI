package com.example.supportdesk.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supportdesk.model.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    // Custom query methods can be defined here if needed
    // /api/tickets/{id}
    // /api/tickets?status=OPEN filter tickets by status
    // /api/tickets?category=Software filter tickets by category
    // /api/tickets?page=1&size=10 control page and size

    List<Ticket> findByStatusIgnoreCase(String status);

    List<Ticket> findByCategoryIgnoreCase(String category);

    List<Ticket> findByPriorityIgnoreCase(String priority);
}
