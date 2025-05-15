package com.rah.demo.crudrepaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.demo.crudrepaso.entity.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {

}
