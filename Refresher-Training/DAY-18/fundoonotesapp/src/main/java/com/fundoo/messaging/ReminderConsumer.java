package com.fundoo.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fundoo.service.email.EmailService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ReminderConsumer {

	private final EmailService emailService;

	@JmsListener(destination = "password-reset-queue")
	public void handlePasswordResetRequest(String messageBody) {

		String[] parts = messageBody.split("\\|", 2);

		String email = parts[0];
		String resetToken = parts[1];

		emailService.sendResetEmail(email, resetToken);
	}
}