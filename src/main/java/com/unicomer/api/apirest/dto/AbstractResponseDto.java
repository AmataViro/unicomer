package com.unicomer.api.apirest.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractResponseDto {
	private String message = "";

	private int code = HttpStatus.OK.value();

	private String status = HttpStatus.OK.getReasonPhrase();

	public String getMessage() {
		return message;
	}

	/**
     * Método que retorna el mensaje según la acción que se esté ejecutando
	 * @param message Mensaje de respuesta
     * @return Objeto de respuesta
     */
	public AbstractResponseDto message(String message) {
		this.message = message;
		return this;
	}

	/**
     * Método que retorna el código según la acción que se esté ejecutando
     * @return Codigo de retorno
     */
	public int getCode() {
		return code;
	}

	/**
     * Método que retorna el estatus según la acción que se esté ejecutando
     * @return Estado de retorno
     */
	public String getStatus() {
		return status;
	}

	/**
     * Método que agrupa en un objeto los parámetros necesarios para retornar al ejecutar una acción
	 * @param status Estado Http
     * @return ResponseEntity Entidad HTTP de respuesta
     */
	public ResponseEntity<AbstractResponseDto> send(HttpStatus status) {
		this.code = status.value();
		this.status = status.getReasonPhrase();
		return new ResponseEntity<AbstractResponseDto>(this, status);
	}
	
}
