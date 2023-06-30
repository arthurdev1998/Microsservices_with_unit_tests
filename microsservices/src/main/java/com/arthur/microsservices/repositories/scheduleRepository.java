package com.arthur.microsservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthur.microsservices.domain.entities.schedule;

public interface scheduleRepository extends JpaRepository<schedule, Long> {

	
}
