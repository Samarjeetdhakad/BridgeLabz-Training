package com.fundoonotes.notes.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fundoonotes.notes.entity.Note;
import com.fundoonotes.notes.messaging.NoteReminderProducer;
import com.fundoonotes.notes.repository.NoteRepository;

@Component
public class NoteReminderScheduler {

	private final NoteRepository noteRepository;
	private final NoteReminderProducer noteReminderProducer;

	public NoteReminderScheduler(NoteRepository noteRepository, NoteReminderProducer noteReminderProducer) {

		this.noteRepository = noteRepository;
		this.noteReminderProducer = noteReminderProducer;
	}

	@Scheduled(fixedRate = 60000)
	public void processDueReminders() {

		List<Note> dueNotes = noteRepository.findByReminderAtIsNotNullAndReminderAtLessThanEqualAndReminderSentFalse(LocalDateTime.now());

		for (Note note : dueNotes) {

			noteReminderProducer.sendReminder(note.getTitle(), note.getOwnerEmail());

			note.setReminderSent(true);
			noteRepository.save(note);
		}
	}
}
