package com.fundoonotes.notes.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fundoonotes.notes.dto.response.NoteResponseDTO;
import com.fundoonotes.notes.dto.response.TagResponseDTO;
import com.fundoonotes.notes.entity.Note;

@Component
public class NoteMapper {

    public NoteResponseDTO toResponseDTO(Note note) {

        return new NoteResponseDTO(
                note.getNoteId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt(),
                note.getState(),
                note.isPinned(),
                note.getReminderAt(),
                note.isReminderSent(),
                note.getTags()
                        .stream()
                        .map(tag -> new TagResponseDTO(tag.getTagId(), tag.getName()))
                        .collect(Collectors.toSet())
        );
    }
}
