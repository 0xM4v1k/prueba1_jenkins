package com.rah.demo.crudrepaso.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class UserModel {

	private Integer index;
	private Integer documento;
	private String nombre;
	private String apellido;
	private Integer edad;

	private List<DireccionModel> direcciones;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
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

    public List<DireccionModel> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionModel> direcciones) {
        this.direcciones = direcciones;
    }
        
        
        
}
