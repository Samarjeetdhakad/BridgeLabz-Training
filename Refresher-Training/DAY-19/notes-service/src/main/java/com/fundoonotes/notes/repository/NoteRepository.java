package com.fundoonotes.notes.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fundoonotes.notes.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>, JpaSpecificationExecutor<Note> {

	List<Note> findByOwnerId(int ownerId);

	Optional<Note> findByNoteIdAndOwnerId(int noteId, int ownerId);

	List<Note> findByOwnerIdAndState(int ownerId, Note.NoteState state);

	List<Note> findByReminderAtIsNotNullAndReminderAtLessThanEqualAndReminderSentFalse(LocalDateTime now);
}
