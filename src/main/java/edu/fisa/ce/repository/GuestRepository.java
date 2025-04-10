package edu.fisa.ce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fisa.ce.model.GuestEntity;

public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
	
} 
