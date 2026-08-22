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
import org.springframework.web.bind.annotation.RestController;
import com.fundoo.dto.note.CreateRequestDTO;
import com.fundoo.dto.note.CreateResponseDTO;
import com.fundoo.entity.Notes;
import com.fundoo.service.notes.NoteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {

	private final NoteService noteService;

	private Long currentUserId() {
		return (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	}

	@PostMapping("/create")
	public ResponseEntity<CreateResponseDTO> createNote(@Valid @RequestBody CreateRequestDTO request) {
		CreateResponseDTO response = noteService.createNote(currentUserId(), request.getTitle(), request.getContent());

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public List<CreateResponseDTO> getMyNote() {
		return noteService.findByOwner(currentUserId());
	}

	// GET ONE NOTE
	@GetMapping("/{id}")
	public ResponseEntity<CreateResponseDTO> getNote(@PathVariable int id) {

		CreateResponseDTO note = noteService.findById(id, currentUserId());

		return ResponseEntity.ok(note);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CreateResponseDTO> updateNote(@PathVariable int id, @Valid @RequestBody CreateRequestDTO request) {

		CreateResponseDTO note = noteService.updateNote(id, currentUserId(), request.getTitle(), request.getContent());

		return ResponseEntity.ok(note);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable int id) {
		boolean deleted = noteService.deleteNote(id, currentUserId());
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
