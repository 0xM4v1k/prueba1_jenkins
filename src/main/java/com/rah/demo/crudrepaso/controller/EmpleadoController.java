package com.rah.demo.crudrepaso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rah.demo.crudrepaso.entity.EmpleadoEntity;
import com.rah.demo.crudrepaso.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	private EmpleadoService empleadoService;

	public EmpleadoController(EmpleadoService empleadoService) {
		super();
		this.empleadoService = empleadoService;
	}

	@PostMapping
	public ResponseEntity<EmpleadoEntity> createEmpleado(@RequestBody EmpleadoEntity empleadoEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.empleadoService.createEmpleado(empleadoEntity));
	}
}
