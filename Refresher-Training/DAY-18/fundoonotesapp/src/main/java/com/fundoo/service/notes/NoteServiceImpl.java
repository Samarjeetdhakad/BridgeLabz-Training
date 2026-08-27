package com.fundoo.service.notes;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.dto.note.CreateRequestDTO;
import com.fundoo.dto.note.CreateResponseDTO;
import com.fundoo.dto.note.NoteResponseDTO;
import com.fundoo.entity.Notes;
import com.fundoo.entity.Tag;
import com.fundoo.entity.User;
import com.fundoo.exception.InvalidNoteStateException;
import com.fundoo.exception.NoteNotFoundException;
import com.fundoo.exception.UnathorizedNoteAccessException;
import com.fundoo.exception.UserNotFoundException;
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

	private static final Logger logger =
	        LoggerFactory.getLogger(NoteServiceImpl.class);
	
	@Transactional
	@Override
	public CreateResponseDTO createNote(Long userId, CreateRequestDTO request) {
		User owner = userRepository.findById((long) userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		logger.info("Creating note for userId={}", userId);
		
		Notes note = new Notes();
		note.setTitle(request.getTitle());
		note.setContent(request.getContent());
		note.setReminderAt(request.getReminderAt());
		note.setOwner(owner);
		Notes savedNote = noteRepository.save(note);

		return mapToResponse(savedNote);
	}

	@Transactional
	@Override
	public boolean deleteNote(int noteId, Long userId) {

		User owner = userRepository.findById((long)userId)
				.orElseThrow(() ->new UserNotFoundException(userId));

		return noteRepository.findByNoteIdAndOwner(noteId, owner).map(note -> {
			noteRepository.delete(note);
			return true;
		}).orElse(false);
	}

	@Override
	public NoteResponseDTO findById(int noteId, Long userId) {
		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
	
		Notes note = noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow( () -> {
					logger.warn("Uauthorized access attempt for note id = {}", noteId);
					return new UnathorizedNoteAccessException();
				});
		return noteMapper.toResponseDTO(note);
	}

	@Transactional
	@Override
	public NoteResponseDTO updateNote(int noteId, Long userId, String title, String content) {

		User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
		Notes note = noteRepository.findByNoteIdAndOwner(noteId, user)
				.orElseThrow(() -> new UnathorizedNoteAccessException());

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
				.orElseThrow(() -> new NoteNotFoundException(noteId));
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
			throw new InvalidNoteStateException("Cannot pin a note that is in Trash or Archived");
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

		User owner = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

		return noteRepository.findByOwnerAndState(owner, state).stream().map(noteMapper::toResponseDTO).toList();
	}

	@Override
	public List<NoteResponseDTO> findPinnedByOwner(Long userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

		return noteRepository.findByOwnerAndIsPinnedTrueAndStateNot(owner, Notes.NoteState.TRASHED).stream()
				.map(noteMapper::toResponseDTO).toList();
	}

	@Override
	public List<NoteResponseDTO> findActiveByOwner(Long userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

		return noteRepository.findByOwnerAndState(owner, Notes.NoteState.ACTIVE).stream().map(noteMapper::toResponseDTO)
				.toList();
	}

	@Override
	public List<NoteResponseDTO> search(Long userId, String titleText, Notes.NoteState state, String tagName) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

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

		User owner = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

		return noteRepository.findByOwnerAndTagsName(owner, tagName).stream().map(noteMapper::toResponseDTO).toList();
	}
}
