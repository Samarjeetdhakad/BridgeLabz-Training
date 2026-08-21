package com.fundoo.dto.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponseDTO {

    private int status;

    private String message;

    private LocalDateTime timestamp;
}