package com.arthur.microsservices.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arthur.microsservices.domain.entities.Patient;
import com.arthur.microsservices.exceptions.ResourcesNotFoundException;
import com.arthur.microsservices.repositories.PatientRepository;

@Service
@Transactional
public class PacienteService {
	
	private PatientRepository patientRepository;
	
	public PacienteService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	
	public List<Patient> FindAllPacient(){
		return patientRepository.findAll();
	}
	
	public Patient FindPacientById(Long id) {
		var entity = patientRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Paciente não encontrado"));
		return entity;
	}
	
	public Patient CreatePatient (Patient patient) {
		if (FindCpf(patient) != null) {
			throw new ResourcesNotFoundException("usuario ja cadastrado");
		}
		return patientRepository.save(patient);
	
	}
	
	public Patient UpdatePatient (Long id) {
		
		var entity = patientRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Paciente nao encontrado"));
		Patient obj = new Patient();
		
		obj.setCpf(entity.getCpf());
		obj.setEmail(entity.getEmail());
		obj.setNome(entity.getNome());
		obj.setSobrenomeString(entity.getSobrenomeString());
		return obj;
		
	}
	
	public void DeletePatient(Long id) {
		patientRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Paciente nao encontrado"));
		patientRepository.deleteById(id);
	}
	
	public Patient FindCpf(Patient patient) {
		return patientRepository.findByCpf(patient.getCpf());
		
	}
}
