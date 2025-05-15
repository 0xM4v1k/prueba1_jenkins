package com.rah.demo.crudrepaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.demo.crudrepaso.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
