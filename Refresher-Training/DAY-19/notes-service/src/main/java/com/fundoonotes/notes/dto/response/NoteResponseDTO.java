package com.fundoonotes.notes.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

import com.fundoonotes.notes.entity.Note.NoteState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponseDTO {

    private int noteId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private NoteState state;
    private boolean pinned;
    private LocalDateTime reminderAt;
    private boolean reminderSent;
    private Set<TagResponseDTO> tags;

}
