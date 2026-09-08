package com.fundoonotes.auth.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundoonotes.auth.dto.request.LoginRequest;
import com.fundoonotes.auth.dto.request.RegisterRequest;
import com.fundoonotes.auth.entity.PasswordResetToken;
import com.fundoonotes.auth.entity.User;
import com.fundoonotes.auth.exception.DuplicateEmailException;
import com.fundoonotes.auth.exception.InvalidCredentialsException;
import com.fundoonotes.auth.exception.InvalidResetTokenException;
import com.fundoonotes.auth.exception.ResetTokenAlreadyUsedException;
import com.fundoonotes.auth.exception.ResetTokenExpiredException;
import com.fundoonotes.auth.exception.UserNotFoundException;
import com.fundoonotes.auth.repository.PasswordResetTokenRepository;
import com.fundoonotes.auth.repository.UserRepository;
import com.fundoonotes.auth.security.JwtUtil;
import com.fundoonotes.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final JwtUtil jwtUtil;
	private final PasswordResetTokenRepository passwordResetTokenRepository;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserServiceImpl(UserRepository userRepository, JwtUtil jwtUtil,
			PasswordResetTokenRepository passwordResetTokenRepository) {

		this.userRepository = userRepository;
		this.jwtUtil = jwtUtil;
		this.passwordResetTokenRepository = passwordResetTokenRepository;
	}

	@Override
	public String register(RegisterRequest request) {

		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new DuplicateEmailException(request.getEmail());
		}

		User user = new User();

		user.setEmail(request.getEmail());
		user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
		user.setName(request.getName());

		User savedUser = userRepository.save(user);

		return jwtUtil.generateToken(String.valueOf(savedUser.getUserId()), savedUser.getEmail());
	}

	@Override
	public String login(LoginRequest request) {

		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(InvalidCredentialsException::new);

		if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {

			throw new InvalidCredentialsException();
		}

		return jwtUtil.generateToken(String.valueOf(user.getUserId()), user.getEmail());
	}

	@Override
	public String forgotPassword(String email) {

		User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));

		String token = UUID.randomUUID().toString();

		PasswordResetToken resetToken = passwordResetTokenRepository.findByUser(user).orElse(new PasswordResetToken());

		resetToken.setToken(token);
		resetToken.setUser(user);
		resetToken.setExpiryTime(LocalDateTime.now().plusMinutes(15));
		resetToken.setUsed(false);

		passwordResetTokenRepository.save(resetToken);

		return token;
	}

	@Override
	public void resetPassword(String token, String newPassword) {

		PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token)
				.orElseThrow(InvalidResetTokenException::new);

		if (resetToken.isUsed()) {
			throw new ResetTokenAlreadyUsedException();
		}

		if (resetToken.getExpiryTime().isBefore(LocalDateTime.now())) {

			throw new ResetTokenExpiredException();
		}

		User user = resetToken.getUser();

		user.setPasswordHash(passwordEncoder.encode(newPassword));

		userRepository.save(user);

		resetToken.setUsed(true);

		passwordResetTokenRepository.save(resetToken);
	}
}
