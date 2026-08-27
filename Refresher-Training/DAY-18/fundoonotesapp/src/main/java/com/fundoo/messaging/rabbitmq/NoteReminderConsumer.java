package com.fundoo.messaging.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fundoo.entity.User;
import com.fundoo.repository.UserRepository;
import com.fundoo.service.email.EmailService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class NoteReminderConsumer {

	private static final Logger logger = LoggerFactory.getLogger(NoteReminderConsumer.class);

	private final UserRepository userRepository;
	private final EmailService emailService;
	
	@RabbitListener(queues = "reminder-queue")
	public void handleReminder(String message) {


		String[] parts = message.split("\\|");

		String noteTitle = parts[0];
		Long userId = Long.parseLong(parts[1]);

		logger.info("REMINDER (via RabbitMQ): note='{}' for userId={}", noteTitle, userId);

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		emailService.sendReminderEmail(user.getEmail(), noteTitle);
	}
}