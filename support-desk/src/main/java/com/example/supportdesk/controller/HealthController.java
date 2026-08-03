package com.example.supportdesk.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/api/health")
    public Map<String, String> health() {
        // Returning a small JSON object. Spring MVC converts Map -> JSON automatically.
        return Map.of(
                "status", "UP",
                "service", "support-desk-api"
        );
    }
}
