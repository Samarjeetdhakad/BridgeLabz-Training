package com.fundoo.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fundoo.dto.note.NoteResponseDTO;
import com.fundoo.dto.note.TagResponseDTO;
import com.fundoo.entity.Notes;
import com.fundoo.entity.Tag;

@Component
public class NoteMapper {

    public NoteResponseDTO toResponseDTO(Notes note) {

        Set<TagResponseDTO> tags = note.getTags()
                .stream()
                .map(this::toTagResponseDTO)
                .collect(Collectors.toSet());

        return new NoteResponseDTO(
                note.getNoteId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt(),
                note.getState(),
                note.isPinned(),
                tags
        );
    }

    private TagResponseDTO toTagResponseDTO(Tag tag) {

        return new TagResponseDTO(
                tag.getTagId(),
                tag.getName()
        );
    }
}