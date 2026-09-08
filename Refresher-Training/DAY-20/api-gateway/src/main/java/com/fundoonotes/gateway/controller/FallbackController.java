package com.fundoonotes.gateway.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

	@RequestMapping("/auth")
	public ResponseEntity<Map<String, String>> authFallback() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of("status", "503", "service",
				"auth-service", "message", "Auth service is currently unavailable. Please try again later."));
	}

	@RequestMapping("/notes")
	public ResponseEntity<Map<String, String>> notesFallback() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of("status", "503", "service",
				"notes-service", "message", "Notes service is currently unavailable. Please try again later."));
	}
}
