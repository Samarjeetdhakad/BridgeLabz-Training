package com.fundoo.dto.note;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateResponseDTO {

    private int noteId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}