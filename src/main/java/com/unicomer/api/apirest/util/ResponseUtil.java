package com.unicomer.api.apirest.util;


import com.unicomer.api.apirest.dto.SuccessResponseDto;
import com.unicomer.api.apirest.dto.ErrorResponseDto;

/**
 * Clase utilitaria que realiza la instanciación del objeto SuccessResponseDto y ErrorResponseDto
 * @author chunhaulai
 *
 */
public class ResponseUtil {

	public static SuccessResponseDto<Object> success(){
		return new SuccessResponseDto<Object>();
	}
	
	public static ErrorResponseDto error(){
		return new ErrorResponseDto();
	}
}
