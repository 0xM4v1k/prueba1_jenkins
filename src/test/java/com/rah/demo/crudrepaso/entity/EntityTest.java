package com.rah.demo.crudrepaso.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityTest {

	private ClienteEntity clienteEntity;
	private DireccionEntity direccionEntity;
	private EmpleadoEntity empleadoEntity;
	private PersonaEntity personaEntity;
	private ProveedorEntity proveedorEntity;
	private UserEntity userEntity;

	@BeforeEach
	public void init() {
		this.clienteEntity = new ClienteEntity();
		this.direccionEntity = new DireccionEntity();
		this.empleadoEntity = new EmpleadoEntity();
		this.personaEntity = new PersonaEntity();
		this.proveedorEntity = new ProveedorEntity();
		this.userEntity = new UserEntity();
	}

	@Test
	public void clienteEntity() {
		Integer id = 1;
		String tipocliente = "prueba";

		clienteEntity.setId(id);
		clienteEntity.setTipocliente(tipocliente);

		assertEquals(id, this.clienteEntity.getId());
		assertEquals(tipocliente, this.clienteEntity.getTipocliente());
	}

	@Test
	public void direccionEntityTest() {
		Integer id = 1;
		Integer codigoPostal = 123;
		String localidad = "prueba";
		Integer calle = 69;
		String puerta = "1d";
		UserEntity userEntity = new UserEntity();

		this.direccionEntity.setId(id);
		this.direccionEntity.setCodigoPostal(codigoPostal);
		this.direccionEntity.setLocalidad(localidad);
		this.direccionEntity.setCalle(calle);
		this.direccionEntity.setPuerta(puerta);
		this.direccionEntity.setUserEntity(userEntity);

		assertEquals(id, this.direccionEntity.getId());
		assertEquals(codigoPostal, this.direccionEntity.getCodigoPostal());
		assertEquals(localidad, this.direccionEntity.getLocalidad());
		assertEquals(calle, this.direccionEntity.getCalle());
		assertEquals(puerta, this.direccionEntity.getPuerta());
		assertNotNull(this.direccionEntity.getUserEntity());
	}

	@Test
	public void empleadoEntityTest() {
		Integer id = 1;
		String cargo = "profesional";
		LocalDate fechaInicioLaborar = LocalDate.parse("2022-01-01");
		LocalDate fechaFinLaborar = null;
		PersonaEntity personaEntity = new PersonaEntity();

		this.empleadoEntity.setId(id);
		this.empleadoEntity.setCargo(cargo);
		this.empleadoEntity.setFechaInicioLaborar(fechaInicioLaborar);
		this.empleadoEntity.setFechaFinLaborar(fechaFinLaborar);
		this.empleadoEntity.setPersonaEntity(personaEntity);

		assertEquals(id, this.empleadoEntity.getId());
		assertEquals(cargo, this.empleadoEntity.getCargo());
		assertEquals(fechaInicioLaborar, this.empleadoEntity.getFechaInicioLaborar());
		assertEquals(fechaFinLaborar, this.empleadoEntity.getFechaFinLaborar());
		assertNotNull(this.empleadoEntity.getPersonaEntity());
	}

	@Test
	public void personaEntityTest() {
		Integer id = 1;
		String nombre = "Esme";
		String apellido = "Diaz";
		Integer edad = 28;
		EmpleadoEntity empleadoEntity = new EmpleadoEntity();

		this.personaEntity.setId(id);
		this.personaEntity.setNombre(nombre);
		this.personaEntity.setApellido(apellido);
		this.personaEntity.setEdad(edad);
		this.personaEntity.setEmpleadoEntity(empleadoEntity);

		assertEquals(id, this.personaEntity.getId());
		assertEquals(nombre, this.personaEntity.getNombre());
		assertEquals(apellido, this.personaEntity.getApellido());
		assertEquals(edad, this.personaEntity.getEdad());
		assertNotNull(this.personaEntity.getEmpleadoEntity());
	}

	@Test
	public void proveedorEntityTest() {
		Integer id = 1;
		String tipoProductos = "prueba";

		this.proveedorEntity.setId(id);
		this.proveedorEntity.setTipoProductos(tipoProductos);

		assertEquals(id, this.proveedorEntity.getId());
		assertEquals(tipoProductos, this.proveedorEntity.getTipoProductos());

	}

	@Test
	public void userEntityTest() {

		Integer id = 1;
		Integer documentoUser = 123;
		String nombre = "Esme";
		String apellido = "Diaz";
		Integer edad = 23;
		List<DireccionEntity> direccionEntities = new ArrayList<>();
		direccionEntities.add(direccionEntity);

		this.userEntity.setId(id);
		this.userEntity.setDocumentoUser(documentoUser);
		this.userEntity.setNombre(nombre);
		this.userEntity.setApellido(apellido);
		this.userEntity.setEdad(edad);
		this.userEntity.setDireccionEntities(direccionEntities);

		assertEquals(id, this.userEntity.getId());
		assertEquals(documentoUser, this.userEntity.getDocumentoUser());
		assertEquals(nombre, this.userEntity.getNombre());
		assertEquals(apellido, this.userEntity.getApellido());
		assertEquals(edad, this.userEntity.getEdad());
		assertNotNull(this.userEntity.getDireccionEntities());

	}
}
