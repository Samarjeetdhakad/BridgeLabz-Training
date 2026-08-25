package com.fundoo.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ReminderProducer {

	private final JmsTemplate jmsTemplate;

	public void sendPasswordResetRequest(String email, String resetToken) {

		String messageBody = email + "|" + resetToken;

		jmsTemplate.convertAndSend("password-reset-queue", messageBody);
	}
}