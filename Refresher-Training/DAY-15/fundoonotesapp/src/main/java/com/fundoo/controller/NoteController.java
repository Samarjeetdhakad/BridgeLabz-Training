package com.fundoo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fundoo.dto.note.CreateRequestDTO;
import com.fundoo.dto.note.CreateResponseDTO;
import com.fundoo.dto.note.NoteResponseDTO;
import com.fundoo.entity.Notes;
import com.fundoo.service.notes.NoteService;
import org.springframework.web.bind.annotation.PatchMapping;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {

	private final NoteService noteService;

	// user id of current user
	private Long currentUserId() {
		return (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	}

	@PostMapping("/create")
	public ResponseEntity<CreateResponseDTO> createNote(@Valid @RequestBody CreateRequestDTO request) {
		CreateResponseDTO response = noteService.createNote(currentUserId(), request.getTitle(), request.getContent());

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<NoteResponseDTO> updateNote(@PathVariable int id,
			@Valid @RequestBody CreateRequestDTO request) {

		NoteResponseDTO note = noteService.updateNote(id, currentUserId(), request.getTitle(), request.getContent());

		return ResponseEntity.ok(note);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable int id) {
		boolean deleted = noteService.deleteNote(id, currentUserId());
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}

	@PatchMapping("/{id}/archive")
	public ResponseEntity<NoteResponseDTO> archiveNote(@PathVariable int id) {
		return ResponseEntity.ok(noteService.archiveNote(id, currentUserId()));
	}

	@PatchMapping("/{id}/trash")
	public ResponseEntity<NoteResponseDTO> trashNote(@PathVariable int id) {
		return ResponseEntity.ok(noteService.trashNote(id, currentUserId()));
	}

	@PatchMapping("/{id}/restore")
	public ResponseEntity<NoteResponseDTO> restoreNote(@PathVariable int id) {
		return ResponseEntity.ok(noteService.restoreNote(id, currentUserId()));
	}

	@PatchMapping("/{id}/pin")
	public ResponseEntity<NoteResponseDTO> pinNote(@PathVariable int id) {
		return ResponseEntity.ok(noteService.pinNote(id, currentUserId()));
	}

	@PatchMapping("/{id}/unpin")
	public ResponseEntity<NoteResponseDTO> unpinNote(@PathVariable int id) {
		return ResponseEntity.ok(noteService.unpinNote(id, currentUserId()));
	}

	@GetMapping
	public ResponseEntity<List<NoteResponseDTO>> getNotes(@RequestParam(required = false) String state,
			@RequestParam(required = false) Boolean pinned) {

		Long userId = currentUserId();

		if (state != null) {
			Notes.NoteState noteState = Notes.NoteState.valueOf(state.toUpperCase());
			return ResponseEntity.ok(noteService.findByOwnerAndState(userId, noteState));
		}

		if (Boolean.TRUE.equals(pinned)) {
			return ResponseEntity.ok(noteService.findPinnedByOwner(userId));
		}

		return ResponseEntity.ok(noteService.findActiveByOwner(userId));
	}

	@GetMapping("/search")
	public ResponseEntity<List<NoteResponseDTO>> searchNotes(@RequestParam(required = false) String title,
			@RequestParam(required = false) String state, @RequestParam(required = false) String tag) {

		Notes.NoteState noteState = null;
		if (state != null && !state.isBlank()) {
			noteState = Notes.NoteState.valueOf(state.toUpperCase());
		}
		List<NoteResponseDTO> notes = noteService.search(currentUserId(), title, noteState, tag);

		return ResponseEntity.ok(notes);
	}

	@PostMapping("/{id}/tags")
	public ResponseEntity<NoteResponseDTO> addTag(@PathVariable int id, @RequestParam String tag) {

		return ResponseEntity.ok(noteService.addTagToNote(id, currentUserId(), tag));
	}

	@GetMapping("/tag")
	public ResponseEntity<List<NoteResponseDTO>> findByTag(@RequestParam String name) {

		return ResponseEntity.ok(noteService.findByOwnerAndTag(currentUserId(), name));
	}

	// GET ONE NOTE
	@GetMapping("/{id}")
	public ResponseEntity<NoteResponseDTO> getNote(@PathVariable int id) {

		NoteResponseDTO note = noteService.findById(id, currentUserId());

		return ResponseEntity.ok(note);
	}

}
