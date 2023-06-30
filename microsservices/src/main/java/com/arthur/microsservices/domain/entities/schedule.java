package com.arthur.microsservices.domain.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="AGENDA")
@Data
public class schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "DATA_HORA")
	private LocalDateTime horario;
	@Column(name = "DATA_CRIACAO")
	private LocalDateTime dataCriacao;
	
	@ManyToOne
	private patient paciente;
	
}
