package com.fundoo.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundoo.dto.AuthResponse;
import com.fundoo.dto.LoginRequest;
import com.fundoo.dto.RegisterRequest;
import com.fundoo.entity.User;
import com.fundoo.repository.UserRepository;
import com.fundoo.security.JwtUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	
	@Override
	public AuthResponse register(RegisterRequest request) {
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new IllegalArgumentException("Email already registerd");
		}
		
		User user = new User();
		
		 user.setEmail(request.getEmail());
	     user.setName(request.getName());

	     String hashedPassword = passwordEncoder.encode(request.getPassword());
	     user.setPasswordHash(hashedPassword);
	     
	     userRepository.save(user);

	     return new AuthResponse(null);
	}

	@Override
	public AuthResponse login(LoginRequest request) {

//		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
//				()-> new IllegalArgumentException("envalid email "));
//		
//		boolean passwordMatches = passwordEncoder.matches(request.getPassword(), user.getPasswordHash());
//		
//		if(!passwordMatches) {
//			throw new IllegalArgumentException("Invalid password");
//		}
		
		Authentication authentication = authenticationManager.authenticate(
													new UsernamePasswordAuthenticationToken
													(request.getEmail(), request.getPassword()) );
			
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		String token = jwtUtil.generateToken(userDetails);
		return new AuthResponse(token);
		
		
	}

}
