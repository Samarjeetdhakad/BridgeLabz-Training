package com.fundoonotes.auth.service;

import com.fundoonotes.auth.dto.request.LoginRequest;
import com.fundoonotes.auth.dto.request.RegisterRequest;

public interface UserService {

    String register(RegisterRequest request);

    String login(LoginRequest request);

    String forgotPassword(String email);

    void resetPassword(String token, String newPassword);
}
