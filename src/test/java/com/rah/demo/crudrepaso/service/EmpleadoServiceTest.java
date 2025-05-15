package com.rah.demo.crudrepaso.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rah.demo.crudrepaso.entity.EmpleadoEntity;
import com.rah.demo.crudrepaso.repository.EmpleadoRepository;

public class EmpleadoServiceTest {

	private EmpleadoService empleadoService;
	@Mock
	private EmpleadoRepository empleadoRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.empleadoService = new EmpleadoService(empleadoRepository);
	}

	@Test
	public void createEmpleado() {
		EmpleadoEntity empleadoEntity = new EmpleadoEntity();
		
		when(this.empleadoRepository.save(empleadoEntity)).thenReturn(empleadoEntity);
		EmpleadoEntity response = this.empleadoService.createEmpleado(empleadoEntity);
		assertNotNull(response);
	}
}
