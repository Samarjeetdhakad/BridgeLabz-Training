package com.samar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samar.entity.Contacts;

@Repository
public interface ContactRepository extends JpaRepository<Contacts, Long> {

}
