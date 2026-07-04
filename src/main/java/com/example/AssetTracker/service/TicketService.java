package com.example.assettracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assettracker.dto.TicketResponse;

@Service
public class TicketService {
    private final List<TicketResponse> tickets = new ArrayList<>();

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
}
