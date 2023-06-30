package com.arthur.microsservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthur.microsservices.domain.entities.patient;

public interface patientRepository extends JpaRepository<patient, Long> {

}
