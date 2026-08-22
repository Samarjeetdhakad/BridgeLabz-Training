package com.fundoo.service.notes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoo.dto.note.CreateResponseDTO;
import com.fundoo.entity.Notes;

@Service
public interface NoteService {

	 CreateResponseDTO createNote(Long userId, String title, String content);

	 List<CreateResponseDTO> findByOwner(Long userId);

	 boolean deleteNote(int noteId, Long userId);
	 
	 CreateResponseDTO findById(int noteId, Long userId);
	 
	 CreateResponseDTO updateNote(int noteId,  Long userId, String title, String content );

	 
	 

}
