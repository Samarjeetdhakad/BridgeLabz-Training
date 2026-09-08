package com.fundoonotes.notes.service;

import java.util.List;

import com.fundoonotes.notes.dto.request.NoteRequestDTO;
import com.fundoonotes.notes.dto.response.NoteResponseDTO;
import com.fundoonotes.notes.entity.Note;

public interface NoteService {

	NoteResponseDTO createNote(int userId, String userEmail, NoteRequestDTO request);

	boolean deleteNote(int noteId, int requestingUserId);

	NoteResponseDTO archiveNote(int noteId, int userId);

	NoteResponseDTO trashNote(int noteId, int userId);

	NoteResponseDTO restoreNote(int noteId, int userId);

	NoteResponseDTO pinNote(int noteId, int userId);

	List<NoteResponseDTO> searchNotes(int userId, String title, Note.NoteState state, Boolean pinned);

	NoteResponseDTO addTag(int noteId, int userId, int tagId);

	NoteResponseDTO removeTag(int noteId, int userId, int tagId);

	List<Note> findActiveByOwner(int userId);
}
