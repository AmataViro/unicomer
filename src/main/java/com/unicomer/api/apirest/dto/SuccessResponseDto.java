package com.unicomer.api.apirest.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Clase real que implementa AbstractResponseDto cuando una petición ha sido ejecutada exitosamente. 
 *
 */
@JsonPropertyOrder({ "code", "status", "data", "message" })
public class SuccessResponseDto<T> extends AbstractResponseDto {

	private T data;

	public SuccessResponseDto() {}

	public SuccessResponseDto(T data) {
		this();
		this.data = data;
	}

	/**
     * Método que retorna la data informativa para los casos de éxito
     * @return
     */
	public T getData() {
		return data;
	}

	public SuccessResponseDto<T> body(T data) {
		this.data = data;
		return this;
	}
}
