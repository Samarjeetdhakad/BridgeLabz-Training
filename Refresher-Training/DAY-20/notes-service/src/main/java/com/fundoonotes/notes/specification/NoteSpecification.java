package com.fundoonotes.notes.specification;

import org.springframework.data.jpa.domain.Specification;

import com.fundoonotes.notes.entity.Note;

public class NoteSpecification {

	public static Specification<Note> hasOwner(int ownerId) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("ownerId"), ownerId);
	}

	public static Specification<Note> hasTitle(String title) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),
				"%" + title.toLowerCase() + "%");
	}

	public static Specification<Note> hasState(Note.NoteState state) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("state"), state);
	}

	public static Specification<Note> isPinned(boolean pinned) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("pinned"), pinned);
	}

	public static Specification<Note> isNotTrashed() {
		return (root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get("state"), Note.NoteState.TRASHED);
	}
}
