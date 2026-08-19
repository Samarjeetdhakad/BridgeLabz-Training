package com.fundoo.service;

import org.springframework.stereotype.Service;

import com.fundoo.dto.AuthResponse;
import com.fundoo.dto.LoginRequest;
import com.fundoo.dto.RegisterRequest;

@Service
public interface UserService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}