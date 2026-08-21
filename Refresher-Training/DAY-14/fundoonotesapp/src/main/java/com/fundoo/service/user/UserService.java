package com.fundoo.service.user;

import org.springframework.stereotype.Service;

import com.fundoo.dto.user.AuthResponse;
import com.fundoo.dto.user.ForgotPasswordRequest;
import com.fundoo.dto.user.LoginRequest;
import com.fundoo.dto.user.RegisterRequest;
import com.fundoo.dto.user.ResetPasswordRequest;

@Service
public interface UserService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
    
    String forgotPassword(ForgotPasswordRequest request);

    void resetPassword(ResetPasswordRequest request);
}