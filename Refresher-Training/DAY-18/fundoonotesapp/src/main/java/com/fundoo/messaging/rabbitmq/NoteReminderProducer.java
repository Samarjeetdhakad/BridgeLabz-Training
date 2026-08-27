package com.fundoo.messaging.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Component;

import com.fundoo.configuration.RabbitMQConfig;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NoteReminderProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendReminder(String noteTitle, Long userId) {

        String message = noteTitle + "|" + userId;

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.REMINDER_ROUTING_KEY,
                message
        );
    }
}