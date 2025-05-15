package com.rah.demo.crudrepaso.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("index")
	private Integer id;
	@JsonProperty("documento")
	private Integer documentoUser;
	private String nombre;
	private String apellido;
	private Integer edad;

	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonProperty("direcciones")
	private List<DireccionEntity> direccionEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDocumentoUser() {
        return documentoUser;
    }

    public void setDocumentoUser(Integer documentoUser) {
        this.documentoUser = documentoUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<DireccionEntity> getDireccionEntities() {
        return direccionEntities;
    }

    public void setDireccionEntities(List<DireccionEntity> direccionEntities) {
        this.direccionEntities = direccionEntities;
    }
        
        
        

}