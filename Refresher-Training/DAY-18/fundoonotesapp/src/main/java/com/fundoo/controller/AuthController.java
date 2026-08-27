package com.fundoo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo.dto.user.AuthResponse;
import com.fundoo.dto.user.ForgotPasswordRequest;
import com.fundoo.dto.user.LoginRequest;
import com.fundoo.dto.user.RegisterRequest;
import com.fundoo.dto.user.ResetPasswordRequest;
import com.fundoo.messaging.ReminderProducer;
import com.fundoo.service.user.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

	private final UserService userService;
	private final ReminderProducer reminderProducer;

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(request));

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {

		AuthResponse response = userService.login(request);

		return ResponseEntity.ok(response);
	}


	@PostMapping("/forgot-password")
	public ResponseEntity<Void> forgotPassword(@RequestBody Map<String, String> body) {

		String email = body.get("email");

		String resetToken = userService.generateResetToken(email);

		reminderProducer.sendPasswordResetRequest(email, resetToken);

		return ResponseEntity.ok().build();
	}
	
	

	@PostMapping("/reset-password")
	public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {

		try {

			userService.resetPassword(request);

			return ResponseEntity.ok("Password reset successfully");

		} catch (IllegalArgumentException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}