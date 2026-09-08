package com.fundoonotes.notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.notes.dto.request.TagRequestDTO;
import com.fundoonotes.notes.dto.response.TagResponseDTO;
import com.fundoonotes.notes.service.TagService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tags")
public class TagController {

	private final TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

	@PostMapping
	public ResponseEntity<TagResponseDTO> createTag(@Valid @RequestBody TagRequestDTO request) {

		TagResponseDTO savedTag = tagService.createTag(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedTag);
	}

	@GetMapping
	public List<TagResponseDTO> getAllTags() {

		return tagService.getAllTags();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTag(@PathVariable int id) {

		tagService.deleteTag(id);

		return ResponseEntity.noContent().build();
	}
}
