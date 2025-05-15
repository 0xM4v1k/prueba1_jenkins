package com.rah.demo.crudrepaso.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MapperUtil {

	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * Este metodo se encarga de convertir de Model, Dto, Vo a Entity
	 * 
	 * @param <T> Clase del objeto de salida
	 * @param input  objeto de entrada
	 * @param output objeto de salida
	 * @return
	 */
	public <T> T mapperObject(Object input, Class<T> output) {
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return this.mapper.convertValue(input, output);
	}
}
