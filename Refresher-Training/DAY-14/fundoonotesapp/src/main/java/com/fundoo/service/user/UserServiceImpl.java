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
import com.fundoo.repository.PasswordResetTokenRepository;
import com.fundoo.repository.UserRepository;
import com.fundoo.security.JwtUtil;
import com.fundoo.service.CustomUserDetailsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	private final PasswordResetTokenRepository passwordResetTokenRepository;
	private final CustomUserDetailsService customUserDetailsService;

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
	public String forgotPassword(ForgotPasswordRequest request) {

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		// Check whether user already has a reset token
		passwordResetTokenRepository.findByUser(user)
				.ifPresent(existingToken -> passwordResetTokenRepository.delete(existingToken));

		String token = UUID.randomUUID().toString();

		PasswordResetToken resetToken = new PasswordResetToken();

		resetToken.setToken(token);
		resetToken.setUser(user);
		resetToken.setExpiryDate(LocalDateTime.now().plusMinutes(15));
		resetToken.setUsed(false);

		passwordResetTokenRepository.save(resetToken);
		return token;
	}

	@Override
	public void resetPassword(ResetPasswordRequest request) {

		PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(request.getToken())
				.orElseThrow(() -> new IllegalArgumentException("Invalid reset token"));

		if (resetToken.isUsed()) {
			throw new IllegalArgumentException("Reset token has already been used");
		}

		if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException("Reset token has expired");
		}

		User user = resetToken.getUser();
		String hashedPassword = passwordEncoder.encode(request.getNewPassword());

		user.setPasswordHash(hashedPassword);
		userRepository.save(user);
		resetToken.setUsed(true);

		passwordResetTokenRepository.save(resetToken);
	}

}
