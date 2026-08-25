package com.fundoo.service.email;

public interface EmailService {

    void sendResetEmail(
            String email,
            String resetToken);

	void sendReminderEmail(String email, String resetToken);
}