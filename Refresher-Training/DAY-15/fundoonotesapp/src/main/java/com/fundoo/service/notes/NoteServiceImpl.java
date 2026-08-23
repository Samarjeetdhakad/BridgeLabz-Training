package com.fundoo.service.notes;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fundoo.dto.note.CreateResponseDTO;
import com.fundoo.dto.note.NoteResponseDTO;
import com.fundoo.entity.Notes;
import com.fundoo.entity.Tag;
import com.fundoo.entity.User;
import com.fundoo.mapper.NoteMapper;
import com.fundoo.repository.NoteRepository;
import com.fundoo.repository.TagRepository;
import com.fundoo.repository.UserRepository;
import com.fundoo.specification.NoteSpecifications;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

	private final UserRepository userRepository;
	private final NoteRepository noteRepository;
	private final TagRepository tagRepository;
	private final NoteMapper noteMapper;

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
	public boolean deleteNote(int noteId, Long requestingUserId) {

		User owner = userRepository.findById((long) requestingUserId)
				.orElseThrow(() -> new IllegalArgumentException("user not found"));

		return noteRepository.findByNoteIdAndOwner(noteId, owner).map(note -> {
			noteRepository.delete(note);
			return true;
		}).orElse(false);
	}

	@Override
	public NoteResponseDTO findById(int noteId, Long userId) {
		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
		Notes note = noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow(() -> new IllegalArgumentException("Note not found"));

		return noteMapper.toResponseDTO(note);
	}

	@Override
	public NoteResponseDTO updateNote(int noteId, Long userId, String title, String content) {

		User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
		Notes note = noteRepository.findByNoteIdAndOwner(noteId, user)
				.orElseThrow(() -> new IllegalArgumentException("Note not found"));

		note.setTitle(title);
		note.setContent(content);
		Notes updatedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(updatedNote);
	}

	private CreateResponseDTO mapToResponse(Notes note) {
		return new CreateResponseDTO(note.getNoteId(), note.getTitle(), note.getContent(), note.getCreatedAt());
	}

	@Override
	public Notes getOwnedNoteOrThrow(int noteId, Long userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		return noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow(() -> new IllegalArgumentException("Note not found"));
	}

	@Override
	public NoteResponseDTO archiveNote(int noteId, Long userId) {

		Notes note = getOwnedNoteOrThrow(noteId, userId);

		note.setState(Notes.NoteState.ARCHIVED);
		note.setPinned(false);

		Notes savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public NoteResponseDTO trashNote(int noteId, Long userId) {

		Notes note = getOwnedNoteOrThrow(noteId, userId);

		note.setState(Notes.NoteState.TRASHED);
		note.setPinned(false);

		Notes savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public NoteResponseDTO restoreNote(int noteId, Long userId) {

		Notes note = getOwnedNoteOrThrow(noteId, userId);

		note.setState(Notes.NoteState.ACTIVE);

		Notes savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public NoteResponseDTO pinNote(int noteId, Long userId) {

		Notes note = getOwnedNoteOrThrow(noteId, userId);

		if (note.getState() == Notes.NoteState.TRASHED) {
			throw new IllegalStateException("Cannot pin a note that is in Trash");
		}

		note.setPinned(true);

		Notes savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public NoteResponseDTO unpinNote(int noteId, Long userId) {

		Notes note = getOwnedNoteOrThrow(noteId, userId);

		note.setPinned(false);

		Notes savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public List<NoteResponseDTO> findByOwnerAndState(Long userId, Notes.NoteState state) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		return noteRepository.findByOwnerAndState(owner, state).stream().map(noteMapper::toResponseDTO).toList();
	}

	@Override
	public List<NoteResponseDTO> findPinnedByOwner(Long userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		return noteRepository.findByOwnerAndIsPinnedTrueAndStateNot(owner, Notes.NoteState.TRASHED).stream()
				.map(noteMapper::toResponseDTO).toList();
	}

	@Override
	public List<NoteResponseDTO> findActiveByOwner(Long userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		return noteRepository.findByOwnerAndState(owner, Notes.NoteState.ACTIVE).stream().map(noteMapper::toResponseDTO)
				.toList();
	}

	@Override
	public List<NoteResponseDTO> search(Long userId, String titleText, Notes.NoteState state, String tagName) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		Specification<Notes> specification = NoteSpecifications.search(owner, titleText, state, tagName);

		return noteRepository.findAll(specification).stream().map(noteMapper::toResponseDTO).toList();
	}

	@Override
	public NoteResponseDTO addTagToNote(int noteId, Long userId, String tagName) {

		Notes note = getOwnedNoteOrThrow(noteId, userId);
		Tag tag = tagRepository.findByName(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
		note.getTags().add(tag);

		Notes savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public List<NoteResponseDTO> findByOwnerAndTag(Long userId, String tagName) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		return noteRepository.findByOwnerAndTagsName(owner, tagName).stream().map(noteMapper::toResponseDTO).toList();
	}
}
