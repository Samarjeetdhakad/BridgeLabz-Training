package com.fundoo.scheduler;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fundoo.entity.Notes;
import com.fundoo.messaging.rabbitmq.NoteReminderProducer;
import com.fundoo.repository.NoteRepository;

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

	    LocalDateTime now = LocalDateTime.now();

	    List<Notes> dueNotes =
	            noteRepository.findByReminderAtIsNotNullAndReminderAtLessThanEqualAndReminderSentFalse(now);

	    for (Notes note : dueNotes) {

	        noteReminderProducer.sendReminder(
	                note.getTitle(),
	                note.getOwner().getUserId()
	        );

	        note.setReminderSent(true);
	        noteRepository.save(note);

	    }
	}
}