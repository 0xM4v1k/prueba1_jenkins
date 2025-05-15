package com.rah.demo.crudrepaso.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empleados")
public class EmpleadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cargo;
	private LocalDate fechaInicioLaborar;
	private LocalDate fechaFinLaborar;

	@OneToOne(mappedBy = "empleadoEntity", cascade = CascadeType.ALL)
	@JsonManagedReference
	private PersonaEntity personaEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getFechaInicioLaborar() {
		return fechaInicioLaborar;
	}

	public void setFechaInicioLaborar(LocalDate fechaInicioLaborar) {
		this.fechaInicioLaborar = fechaInicioLaborar;
	}

	public LocalDate getFechaFinLaborar() {
		return fechaFinLaborar;
	}

	public void setFechaFinLaborar(LocalDate fechaFinLaborar) {
		this.fechaFinLaborar = fechaFinLaborar;
	}

	public PersonaEntity getPersonaEntity() {
		return personaEntity;
	}

	public void setPersonaEntity(PersonaEntity personaEntity) {
		this.personaEntity = personaEntity;
	}

}
