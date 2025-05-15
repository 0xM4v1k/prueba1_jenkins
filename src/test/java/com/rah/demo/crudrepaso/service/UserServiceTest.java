package com.rah.demo.crudrepaso.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rah.demo.crudrepaso.entity.DireccionEntity;
import com.rah.demo.crudrepaso.entity.UserEntity;
import com.rah.demo.crudrepaso.model.UserModel;
import com.rah.demo.crudrepaso.repository.UserRepository;
import com.rah.demo.crudrepaso.util.MapperUtil;

public class UserServiceTest {

	private UserService userService;
	@Mock
	private UserRepository userRepository;
	@Mock
	private MapperUtil mapper;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.userService = new UserService(userRepository, mapper);
	}

	@Test
	public void createrUserWithModel() {
		UserModel userModel = new UserModel();

		when(this.userService.createrUserWithModel(userModel)).thenReturn(userModel);
		UserEntity userEntity = this.mapper.mapperObject(userModel, UserEntity.class);
		UserEntity userSave = this.userRepository.save(userEntity);
		UserModel response = this.mapper.mapperObject(userSave, UserModel.class);
		assertNotNull(response);
	}

	@Test
	public void createUserTest() {
		UserEntity userEntity = new UserEntity();
		userEntity.setDocumentoUser(12345);
		userEntity.setNombre("Esme");
		userEntity.setApellido("Diaz");
		List<DireccionEntity> direccionEntities = new ArrayList<>();
		userEntity.setDireccionEntities(direccionEntities);

		UserEntity salida = new UserEntity();
		salida.setId(userEntity.getId());
		salida.setNombre(userEntity.getNombre());
		salida.setApellido(userEntity.getApellido());
		salida.setDireccionEntities(userEntity.getDireccionEntities());

		when(this.userRepository.save(userEntity)).thenReturn(userEntity);
		UserEntity response = this.userService.createUser(userEntity);
		assertNotNull(response);
	}

	@Test
	public void getAllUserTest() {
		List<UserEntity> listUserEntities = new ArrayList<>();
		UserEntity userEntity = new UserEntity();
		listUserEntities.add(userEntity);

		when(this.userRepository.findAll()).thenReturn(listUserEntities);
		List<UserEntity> response = this.userService.getAllUser();
		assertNotNull(response);
	}

	@Test
	public void updateUserTest() {
		UserEntity userEntity = new UserEntity();
		Integer id = 1;

		when(this.userRepository.save(userEntity)).thenReturn(userEntity);
		UserEntity response = this.userService.updateUser(userEntity, id);
		assertNotNull(response);
	}

	@Test
	public void deleteUserTest() {
		Integer id = 1;
		this.userService.deleteUser(id);
	}

	@Test
	public void getUserByIdTest() {
		Integer id = 1;
		UserEntity userEntity = new UserEntity();
		Optional<UserEntity> userOptional = Optional.of(userEntity);

		when(this.userRepository.findById(id)).thenReturn(userOptional);
		UserEntity response = this.userService.getUserById(id);
		assertNotNull(response);
	}
}
