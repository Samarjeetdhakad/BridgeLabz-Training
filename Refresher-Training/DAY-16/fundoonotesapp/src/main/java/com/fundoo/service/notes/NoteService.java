package com.fundoo.service.notes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoo.dto.note.CreateResponseDTO;
import com.fundoo.dto.note.NoteResponseDTO;
import com.fundoo.entity.Notes;
import com.fundoo.entity.Notes.NoteState;

@Service
public interface NoteService {

	 CreateResponseDTO createNote(Long userId, String title, String content);


	 boolean deleteNote(int noteId, Long userId);
	 
	 NoteResponseDTO findById(int noteId, Long userId);
	 
	 NoteResponseDTO updateNote(int noteId,  Long userId, String title, String content );

	 Notes getOwnedNoteOrThrow(int noteId,Long owner);
	 
	 NoteResponseDTO archiveNote(int noteId, Long userId); 
     
     NoteResponseDTO trashNote(int noteId, Long userId);
     
     NoteResponseDTO restoreNote(int noteId, Long userId);
     
     NoteResponseDTO pinNote(int noteId, Long userId);
     
     NoteResponseDTO unpinNote(int noteId, Long userId);

	 List<NoteResponseDTO> findByOwnerAndState(Long userId, NoteState state);

	 List<NoteResponseDTO> findPinnedByOwner(Long userId);

	 List<NoteResponseDTO> findActiveByOwner(Long userId);

	 List<NoteResponseDTO> search(Long userId, String titleText, NoteState state, String tagName);

	 NoteResponseDTO addTagToNote(int noteId, Long userId, String tagName);

	 List<NoteResponseDTO> findByOwnerAndTag(Long userId, String tagName);
     
}
