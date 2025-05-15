package com.rah.demo.crudrepaso.service;

import org.springframework.stereotype.Service;

import com.rah.demo.crudrepaso.entity.EmpleadoEntity;
import com.rah.demo.crudrepaso.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	private EmpleadoRepository empleadoRepository;

	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		super();
		this.empleadoRepository = empleadoRepository;
	}

	// create
	public EmpleadoEntity createEmpleado(EmpleadoEntity empleadoEntity) {
		return this.empleadoRepository.save(empleadoEntity);
	}
}
