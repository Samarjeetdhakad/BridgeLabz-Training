package com.fundoonotes.notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fundoonotes.notes.dto.request.NoteRequestDTO;
import com.fundoonotes.notes.dto.response.NoteResponseDTO;
import com.fundoonotes.notes.entity.Note;
import com.fundoonotes.notes.security.CustomUserDetails;
import com.fundoonotes.notes.service.NoteService;
import com.fundoonotes.notes.service.impl.NoteExportService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notes")
public class NoteController {

	private final NoteService noteService;
	private final NoteExportService noteExportService;

	public NoteController(NoteService noteService, NoteExportService noteExportService) {
		this.noteService = noteService;
		this.noteExportService = noteExportService;
	}

	private CustomUserDetails currentUser() {

		return (CustomUserDetails) SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();
	}

	private int currentUserId() {
		return currentUser().getUserId();
	}

	private String currentUserEmail() {
		return currentUser().getEmail();
	}

	@PostMapping
	public ResponseEntity<NoteResponseDTO> createNote(@Valid @RequestBody NoteRequestDTO request) {

		NoteResponseDTO savedNote = noteService.createNote(currentUserId(), currentUserEmail(), request);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
	}

	@GetMapping
	public List<NoteResponseDTO> getMyNotes(@RequestParam(required = false) String title,
											@RequestParam(required = false) Note.NoteState state,
											@RequestParam(required = false) Boolean pinned) {

		return noteService.searchNotes(currentUserId(), title, state, pinned);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNote(@PathVariable int id) {

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

	@PostMapping("/{id}/tags/{tagId}")
	public ResponseEntity<NoteResponseDTO> addTag(@PathVariable int id, @PathVariable int tagId) {

		NoteResponseDTO response = noteService.addTag(id, currentUserId(), tagId);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}/tags/{tagId}")
	public ResponseEntity<NoteResponseDTO> removeTag(@PathVariable int id, @PathVariable int tagId) {

		NoteResponseDTO response = noteService.removeTag(id, currentUserId(), tagId);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/export")
	public ResponseEntity<byte[]> exportNotes() throws Exception {

		List<Note> notes = noteService.findActiveByOwner(currentUserId());

		byte[] excelBytes = noteExportService.exportToExcel(notes);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=my-notes.xlsx")
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(excelBytes);
	}

}
