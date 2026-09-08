package com.fundoonotes.reminder.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PasswordResetConsumer {

	private static final Logger log = LoggerFactory.getLogger(PasswordResetConsumer.class);

	@JmsListener(destination = "password-reset-queue")
	public void handlePasswordResetRequest(String messageBody) {

		String[] parts = messageBody.split("\\|");

		String email = parts[0];
		String resetToken = parts[1];

		sendActualEmail(email, resetToken);
	}

	private void sendActualEmail(String email, String resetToken) {

		log.info("Password reset email sent to: {}", email);
		log.info("RESET TOKEN: {}", resetToken);
	}
}
