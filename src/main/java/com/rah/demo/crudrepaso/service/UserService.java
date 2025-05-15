package com.rah.demo.crudrepaso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rah.demo.crudrepaso.entity.DireccionEntity;
import com.rah.demo.crudrepaso.entity.UserEntity;
import com.rah.demo.crudrepaso.model.UserModel;
import com.rah.demo.crudrepaso.repository.UserRepository;
import com.rah.demo.crudrepaso.util.MapperUtil;

@Service
public class UserService {

	private UserRepository userRepository;
	private MapperUtil mapper;

	public UserService(UserRepository userRepository, MapperUtil mapper) {
		super();
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	public UserModel createrUserWithModel(UserModel userModel) {
		UserEntity userEntity = this.mapper.mapperObject(userModel, UserEntity.class);
		UserEntity userSaved = this.userRepository.save(userEntity);
		return this.mapper.mapperObject(userSaved, UserModel.class);
	}

	// create
	public UserEntity createUser(UserEntity userEntity) {
		if (userEntity.getDocumentoUser() != null && userEntity.getDocumentoUser() > 0) {
			if (userEntity.getNombre() != null && !userEntity.getNombre().isBlank()) {
				if (userEntity.getApellido() != null && !userEntity.getApellido().isBlank()) {
					if (userEntity.getDireccionEntities().size() == 0) {

						List<DireccionEntity> lista = new ArrayList<>();

						DireccionEntity direccion = new DireccionEntity();
						direccion.setCodigoPostal(123);
						direccion.setLocalidad("General");
						direccion.setCalle(69);
						direccion.setPuerta("1E");
						direccion.setUserEntity(userEntity);

						lista.add(direccion);
						userEntity.setDireccionEntities(lista);

					}
					return this.userRepository.save(userEntity);
				}
			}
		}
		return null;
	}

	// get all
	public List<UserEntity> getAllUser() {
		return this.userRepository.findAll();
	}

	// update
	public UserEntity updateUser(UserEntity userEntity, Integer id) {
		userEntity.setId(id);
		return this.userRepository.save(userEntity);
	}

	// delete
	public void deleteUser(Integer id) {
		this.userRepository.deleteById(id);
	}

	// get By Id
	public UserEntity getUserById(Integer id) {
		return this.userRepository.findById(id).orElse(null);
	}
}
