package com.example.supportdesk.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
public class SupportDeskController {
    @GetMapping("/api/support/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "service", "support-desk-api"
        );
    }

    @GetMapping("/api/support/about") 
    public Map<String, String> about() {
        return Map.of(
            "appName", "Support Desk API",
            "version", "1.0.0",
            "description", "API for managing IT support tickets"
        );
    }
}
