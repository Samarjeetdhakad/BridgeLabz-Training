package com.fundoo.service.notes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoo.dto.note.CreateResponseDTO;
import com.fundoo.entity.Notes;
import com.fundoo.entity.User;
import com.fundoo.repository.NoteRepository;
import com.fundoo.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

	private final UserRepository userRepository;
	private final NoteRepository noteRepository;

	@Override
	public CreateResponseDTO createNote(Long userId, String title, String content) {
		User owner = userRepository.findById((long) userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		Notes note = new Notes();

		note.setTitle(title);
		note.setContent(content);
		note.setOwner(owner);

		Notes savedNote = noteRepository.save(note);

		return mapToResponse(savedNote);
	}

	@Override
	public List<CreateResponseDTO> findByOwner(Long userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		List<Notes> notes = noteRepository.findByOwner(owner);

		return notes.stream().map(this::mapToResponse).toList();
	}

	@Override
	public boolean deleteNote(int noteId, Long requestingUserId) {

		User owner = userRepository.findById((long) requestingUserId)
				.orElseThrow(() -> new IllegalArgumentException("user not found"));

		return noteRepository.findByNoteIdAndOwner(noteId, owner).map(note -> {
			noteRepository.delete(note);
			return true;
		}).orElse(false);
	}

	@Override
	public CreateResponseDTO findById(int noteId, Long userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		Notes note = noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow(() -> new IllegalArgumentException("Note not found"));

		return mapToResponse(note);
	}

	@Override
	public CreateResponseDTO updateNote(int noteId, Long userId, String title, String content) {

		User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		Notes note = noteRepository.findByNoteIdAndOwner(noteId, user)
				.orElseThrow(() -> new IllegalArgumentException("Note not found"));

		note.setTitle(title);
		note.setContent(content);

		Notes updatedNote = noteRepository.save(note);

		return mapToResponse(updatedNote);
	}

	 private CreateResponseDTO mapToResponse(Notes note) {

	        return new CreateResponseDTO(
	                note.getNoteId(),
	                note.getTitle(),
	                note.getContent(),
	                note.getCreatedAt()
	        );
	    }

}
