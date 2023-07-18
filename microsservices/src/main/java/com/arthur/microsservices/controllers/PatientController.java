package com.arthur.microsservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.arthur.microsservices.domain.entities.Patient;
import com.arthur.microsservices.services.PacienteService;

@RequestMapping(value="api/patient")
@RestController
public class PatientController {
	
	@Autowired
	private PacienteService patientService;
	
	@GetMapping
	public ResponseEntity<List<Patient>>  GetAllPatients(){
		var obj = patientService.FindAllPacient();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(obj);

	}
	
	@PostMapping
	public ResponseEntity<Patient> CreatePatient(@RequestBody Patient patient){
		var obj = patientService.CreatePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}
	
	@PutMapping(value = "/{Id}")
	public ResponseEntity<Patient> UpdatePatitent(@PathVariable (value="Id")Long id){
		var obj = patientService.UpdatePatient(id);
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	@DeleteMapping(value = "/{Id}")
	public ResponseEntity<?> DeletePatient(@PathVariable (value= "Id")Long id){
		patientService.DeletePatient(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
