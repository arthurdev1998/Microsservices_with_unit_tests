package com.arthur.microsservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthur.microsservices.domain.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	
}
