package com.fundoo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fundoo.entity.User;
import org.springframework.stereotype.Repository;

import com.fundoo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		
	Optional<User> findByEmail(String email);
	
}