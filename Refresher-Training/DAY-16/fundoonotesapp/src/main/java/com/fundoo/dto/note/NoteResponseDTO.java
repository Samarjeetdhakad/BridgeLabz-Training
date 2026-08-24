package com.fundoo.dto.note;

import java.time.LocalDateTime;
import java.util.Set;

import com.fundoo.entity.Notes.NoteState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponseDTO {

    private int noteId;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private NoteState state;

    private boolean pinned;

    private Set<TagResponseDTO> tags;
}