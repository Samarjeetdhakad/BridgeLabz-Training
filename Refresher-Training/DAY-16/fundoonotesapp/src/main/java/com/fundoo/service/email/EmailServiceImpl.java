package com.fundoo.service.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

	private final JavaMailSender mailSender;

	@Override
	public void sendResetEmail(String email, String resetToken) {

		String resetLink = "http://localhost:5173/reset-password?token=" + resetToken;

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(email);

		message.setSubject("Fundoo Notes - Password Reset");

		message.setText("Hello,\n\n" + "You requested a password reset.\n\n"
				+ "Click the link below to reset your password:\n\n" + resetLink + "\n\n"
				+ "This link will expire in 15 minutes.\n\n" + "If you did not request this password reset, "
				+ "please ignore this email.");

		mailSender.send(message);
	}
}