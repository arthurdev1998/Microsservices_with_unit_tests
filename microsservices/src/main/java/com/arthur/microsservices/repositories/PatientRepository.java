package com.arthur.microsservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arthur.microsservices.domain.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	@Query("SELECT u FROM Patient u WHERE u.cpf =:cpf")
	
	Patient findByCpf(@Param("cpf")String cpf);
	
}
