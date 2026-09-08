package com.fundoonotes.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.auth.dto.request.ForgotPasswordRequest;
import com.fundoonotes.auth.dto.request.LoginRequest;
import com.fundoonotes.auth.dto.request.RegisterRequest;
import com.fundoonotes.auth.dto.request.ResetPasswordRequest;
import com.fundoonotes.auth.dto.response.AuthResponse;
import com.fundoonotes.auth.messaging.PasswordResetProducer;
import com.fundoonotes.auth.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UserService userService;
	private final PasswordResetProducer passwordResetProducer;

	public AuthController(UserService userService, PasswordResetProducer passwordResetProducer) {

		this.userService = userService;
		this.passwordResetProducer = passwordResetProducer;
	}

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {

		String token = userService.register(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(token));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {

		String token = userService.login(request);

		return ResponseEntity.ok(new AuthResponse(token));
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<Void> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {

		String token = userService.forgotPassword(request.getEmail());

		passwordResetProducer.sendPasswordResetRequest(request.getEmail(), token);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {

		userService.resetPassword(request.getToken(), request.getNewPassword());

		return ResponseEntity.ok("Password reset successful");
	}
}
