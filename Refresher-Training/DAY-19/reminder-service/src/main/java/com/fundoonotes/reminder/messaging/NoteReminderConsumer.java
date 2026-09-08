package com.fundoonotes.reminder.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fundoonotes.reminder.service.EmailService;

@Component
public class NoteReminderConsumer {

	private final EmailService emailService;

	public NoteReminderConsumer(EmailService emailService) {
		this.emailService = emailService;
	}

	@RabbitListener(queues = "reminder-queue")
	public void handleReminder(String message) {

		String[] parts = message.split("\\|");

		String noteTitle = parts[0];
		String email = parts[1];

		emailService.sendReminderEmail(email, noteTitle);
	}
}
