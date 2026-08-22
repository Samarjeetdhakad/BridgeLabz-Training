package com.fundoo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundoo.entity.Notes;
import com.fundoo.entity.User;

@Repository
public interface NoteRepository extends JpaRepository<Notes,Integer>{

	 List<Notes> findByOwner(User owner);

	 Optional<Notes> findByNoteIdAndOwner(int noteId, User owner);
	 

}
