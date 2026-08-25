package com.fundoo.service.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundoo.dto.user.AuthResponse;
import com.fundoo.dto.user.ForgotPasswordRequest;
import com.fundoo.dto.user.LoginRequest;
import com.fundoo.dto.user.RegisterRequest;
import com.fundoo.dto.user.ResetPasswordRequest;
import com.fundoo.entity.PasswordResetToken;
import com.fundoo.entity.User;
import com.fundoo.messaging.ReminderProducer;
import com.fundoo.repository.PasswordResetTokenRepository;
import com.fundoo.repository.UserRepository;
import com.fundoo.security.CustomUserDetailsService;
import com.fundoo.security.JwtUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	private final PasswordResetTokenRepository passwordResetTokenRepository;
	private final ReminderProducer reminderProducer;

	@Override
	public AuthResponse register(RegisterRequest request) {
		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new IllegalArgumentException("Email already registerd");
		}

		User user = new User();

		user.setEmail(request.getEmail());
		user.setName(request.getName());

		String hashedPassword = passwordEncoder.encode(request.getPassword());
		user.setPasswordHash(hashedPassword);

		userRepository.save(user);

		UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
				.password(user.getPasswordHash()).build();

		String token = jwtUtil.generateToken(userDetails, user.getUserId());

		return new AuthResponse(token);
	}

	@Override
	public AuthResponse login(LoginRequest request) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		User user = userRepository.findByEmail(userDetails.getUsername())
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		String token = jwtUtil.generateToken(userDetails, user.getUserId());
		return new AuthResponse(token);

	}

	@Override
	public void forgotPassword(ForgotPasswordRequest request) {

		String resetToken = generateResetToken(request.getEmail());

		reminderProducer.sendPasswordResetRequest(request.getEmail(), resetToken);
	}

	@Override
	public void resetPassword(ResetPasswordRequest request) {

		String token = request.getToken();

		if (!jwtUtil.isResetTokenValid(token)) {
			throw new IllegalArgumentException("Invalid or expired reset token");
		}
		Long userId = jwtUtil.extractUserId(token);

		User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		String hashedPassword = passwordEncoder.encode(request.getNewPassword());

		user.setPasswordHash(hashedPassword);

		userRepository.save(user);
	}

	@Override
	public String generateResetToken(String email) {

		User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found"));

		return jwtUtil.generateResetToken(user.getEmail(), user.getUserId());
	}

}
