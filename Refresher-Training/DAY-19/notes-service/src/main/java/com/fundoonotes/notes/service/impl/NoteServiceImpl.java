package com.fundoonotes.notes.service.impl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fundoonotes.notes.dto.request.NoteRequestDTO;
import com.fundoonotes.notes.dto.response.NoteResponseDTO;
import com.fundoonotes.notes.entity.Note;
import com.fundoonotes.notes.entity.Tag;
import com.fundoonotes.notes.exception.InvalidNoteStateException;
import com.fundoonotes.notes.exception.NoteNotFoundException;
import com.fundoonotes.notes.exception.TagNotFoundException;
import com.fundoonotes.notes.mapper.NoteMapper;
import com.fundoonotes.notes.repository.NoteRepository;
import com.fundoonotes.notes.repository.TagRepository;
import com.fundoonotes.notes.service.NoteService;
import com.fundoonotes.notes.specification.NoteSpecification;

@Service
public class NoteServiceImpl implements NoteService {

	private final NoteRepository noteRepository;
	private final NoteMapper noteMapper;
	private final TagRepository tagRepository;

	public NoteServiceImpl(NoteRepository noteRepository, NoteMapper noteMapper, TagRepository tagRepository) {

		this.noteRepository = noteRepository;
		this.noteMapper = noteMapper;
		this.tagRepository = tagRepository;
	}

	@Override
	public NoteResponseDTO createNote(int userId, String userEmail, NoteRequestDTO request) {

		Note note = new Note();

		note.setTitle(request.getTitle());
		note.setContent(request.getContent());
		note.setOwnerId(userId);
		note.setOwnerEmail(userEmail);
		note.setReminderAt(request.getReminderAt());

		Note savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public boolean deleteNote(int noteId, int requestingUserId) {

		return noteRepository.findByNoteIdAndOwnerId(noteId, requestingUserId).map(note -> {
			noteRepository.delete(note);
			return true;
		}).orElse(false);
	}

	@Override
	public NoteResponseDTO archiveNote(int noteId, int userId) {

		Note note = getOwnedNoteOrThrow(noteId, userId);

		note.setState(Note.NoteState.ARCHIVED);
		note.setPinned(false);

		Note savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public NoteResponseDTO trashNote(int noteId, int userId) {

		Note note = getOwnedNoteOrThrow(noteId, userId);

		note.setState(Note.NoteState.TRASHED);
		note.setPinned(false);

		Note savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public NoteResponseDTO restoreNote(int noteId, int userId) {

		Note note = getOwnedNoteOrThrow(noteId, userId);

		note.setState(Note.NoteState.ACTIVE);

		Note savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public NoteResponseDTO pinNote(int noteId, int userId) {

		Note note = getOwnedNoteOrThrow(noteId, userId);

		if (note.getState() != Note.NoteState.ACTIVE) {
			throw new InvalidNoteStateException("Only active notes can be pinned");
		}

		note.setPinned(true);

		Note savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public List<NoteResponseDTO> searchNotes(int userId, String title, Note.NoteState state, Boolean pinned) {

		Specification<Note> specification = NoteSpecification.hasOwner(userId);

		if (title != null && !title.isBlank()) {
			specification = specification.and(NoteSpecification.hasTitle(title));
		}

		if (state != null) {
			specification = specification.and(NoteSpecification.hasState(state));
		} else {
			specification = specification.and(NoteSpecification.isNotTrashed());
		}

		if (pinned != null) {
			specification = specification.and(NoteSpecification.isPinned(pinned));
		}

		return noteRepository.findAll(specification).stream().map(noteMapper::toResponseDTO).toList();
	}

	@Override
	public NoteResponseDTO addTag(int noteId, int userId, int tagId) {

		Note note = getOwnedNoteOrThrow(noteId, userId);

		Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new TagNotFoundException(tagId));

		note.getTags().add(tag);

		Note savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public NoteResponseDTO removeTag(int noteId, int userId, int tagId) {

		Note note = getOwnedNoteOrThrow(noteId, userId);

		Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new TagNotFoundException(tagId));

		note.getTags().remove(tag);

		Note savedNote = noteRepository.save(note);

		return noteMapper.toResponseDTO(savedNote);
	}

	@Override
	public List<Note> findActiveByOwner(int userId) {

		return noteRepository.findByOwnerIdAndState(userId, Note.NoteState.ACTIVE);
	}

	private Note getOwnedNoteOrThrow(int noteId, int userId) {

		return noteRepository.findByNoteIdAndOwnerId(noteId, userId).orElseThrow(() -> new NoteNotFoundException(noteId));
	}
}
