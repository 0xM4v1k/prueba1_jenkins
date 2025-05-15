package com.rah.demo.crudrepaso.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModelTest {

	private UserModel userModel;
	private DireccionModel direccionModel;

	@BeforeEach
	public void init() {
		this.userModel = new UserModel();
		this.direccionModel = new DireccionModel();
	}

	@Test
	public void userModelTest() {
		Integer index = 1;
		Integer documento = 123;
		String nombre = "Esme";
		String apellido = "Diaz";
		Integer edad = 20;
		List<DireccionModel> direcciones = new ArrayList<>();
		direcciones.add(direccionModel);

		this.userModel.setIndex(index);
		this.userModel.setDocumento(documento);
		this.userModel.setNombre(nombre);
		this.userModel.setApellido(apellido);
		this.userModel.setEdad(edad);
		this.userModel.setDirecciones(direcciones);

		assertEquals(index, this.userModel.getIndex());
		assertEquals(documento, this.userModel.getDocumento());
		assertEquals(nombre, this.userModel.getNombre());
		assertEquals(apellido, this.userModel.getApellido());
		assertEquals(edad, this.userModel.getEdad());
		assertNotNull(this.userModel.getDirecciones());
	}

	@Test
	public void direccionModel() {
		Integer index = 1;
		Integer codigoPostal = 123;
		String localidad = "prueba";
		Integer calle = 23;
		String puerta = "4d";

		this.direccionModel.setIndex(index);
		this.direccionModel.setCodigoPostal(codigoPostal);
		this.direccionModel.setLocalidad(localidad);
		this.direccionModel.setCalle(calle);
		this.direccionModel.setPuerta(puerta);

		assertEquals(index, this.direccionModel.getIndex());
		assertEquals(codigoPostal, this.direccionModel.getCodigoPostal());
		assertEquals(localidad, this.direccionModel.getLocalidad());
		assertEquals(calle, this.direccionModel.getCalle());
		assertEquals(puerta, this.direccionModel.getPuerta());
	}
}
