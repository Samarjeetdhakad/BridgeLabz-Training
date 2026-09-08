package com.fundoonotes.notes.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fundoonotes.notes.config.RabbitMQConfig;

@Component
public class NoteReminderProducer {

	private final RabbitTemplate rabbitTemplate;

	public NoteReminderProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendReminder(String noteTitle, String ownerEmail) {

		String message = noteTitle + "|" + ownerEmail;

		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.REMINDER_ROUTING_KEY, message);
	}
}
