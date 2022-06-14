package com.unicomer.api.apirest.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Clase real que implementa AbstractResponseDto para referirse a una excepción
 *
 */
@JsonPropertyOrder({ "code", "status", "message" , "timestamp" , "error" , "path" })
public class ErrorResponseDto extends AbstractResponseDto{
	 
	@JsonIgnoreProperties(ignoreUnknown = true)
    public String timestamp;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public String error;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public String path;

    /**
     * Método que retorna los valores asociados a la fecha/hora en que se registra un error
     * @return Timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Método que obtiene el valor para fecha/hora en que se registra un error
     * @param timestamp timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
