package com.unicomer.api.apirest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicomer.api.apirest.dto.AbstractResponseDto;
import com.unicomer.api.apirest.dto.ClienteDto;
import com.unicomer.api.apirest.dto.SuccessResponseDto;
import com.unicomer.api.apirest.service.ClienteService;
import com.unicomer.api.apirest.util.GeneralLogicException;
import com.unicomer.api.apirest.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador REST que realiza operaciones correspondientes a CRUD de Clientes
 * 
 * @author vobando
 *
 */
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping(value = "/cliente")
@RestController
@Api(description = "Operaciones correspondientes a CRUD de Clientes", produces = "application/json")
public class ClienteController {
	
	@Autowired
    private ClienteService service;

	/**
	 * Metodo implementado para registrar un nuevo cliente
	 * @return id
	 */
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
	@ApiOperation(value = "Agregar un nuevo cliente", response = SuccessResponseDto.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Los datos del cliente se ha guardado exitosamente", response = AbstractResponseDto.class),
			@ApiResponse(code = 500, message = "Error generado por excepción interna", response = Void.class) })
	public ResponseEntity<AbstractResponseDto> post(@ApiParam("Estructura de la planificacion") @RequestBody ClienteDto dto) {
		
		final Integer id = this.service.agregarCliente(dto);
		return ResponseUtil.success().body(id).message("Los datos del cliente se ha guardado exitosamente")
				.send(HttpStatus.OK);
	}

	/**
	 * Metodo implementado para actualizar un nuevo cliente
	 * @return id
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ApiOperation(value = "Actualizar los datos del cliente", response = SuccessResponseDto.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Los datos se han actualizado exitosamente", response = AbstractResponseDto.class),
			@ApiResponse(code = 500, message = "Error generado por excepción interna", response = Void.class) })
	public ResponseEntity<AbstractResponseDto> put(@ApiParam("Estructura del Archivo") @RequestBody final ClienteDto dto) {
		if (dto.getId() == null)
			throw new GeneralLogicException("Id del cliente no esta definido");

		final Integer id = this.service.actualizarCliente(dto);

		return ResponseUtil.success().body(id).message("Lo datos se han actualizado exitosamente")
				.send(HttpStatus.OK);
	}

	/**
     * Método implementado para obtener un listado de clientes
     * 
     * @return ResponseEntity
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "Obtener lista de clientes", response = SuccessResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "Clines obtenidos exitosamente", response = AbstractResponseDto.class),
                    @ApiResponse(code = 500, message = "Error generado por excepción interna", response = AbstractResponseDto.class) })
    public ResponseEntity<AbstractResponseDto> getAll() {
            List<ClienteDto> lista = this.service.obtenerClientes();
            return ResponseUtil.success().body(lista).message("Clietes obtenidos exitosamente")
                            .send(HttpStatus.OK);

    }

	/** 
	 * Método implementado para obtener los datos de un cliente de acuerdo a su ID
	 * 
	 * @return ResponseEntity
	*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener los datos de un cliente por ID", response = SuccessResponseDto.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente obtenido exitosamente", response = AbstractResponseDto.class),
			@ApiResponse(code = 500, message = "Error generado por excepción interna", response = Void.class) })
	public ResponseEntity<AbstractResponseDto> getById(@ApiParam("Id del cliente") @PathVariable(required = true, name = "id") final Integer id) {
		return ResponseUtil.success().body(this.service.obtenerCostoPorId(id))
				.message("Cliente obtenido exitosamente").send(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar los datos de un cliente por ID", response = SuccessResponseDto.class, produces = "application/json")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Cliente elimiado exitosamente", response = AbstractResponseDto.class),
		@ApiResponse(code = 500, message = "Error generado por excepción interna", response = Void.class) })
        public ResponseEntity<AbstractResponseDto> eliminarCliente(@PathVariable("id") Integer id) {
            if (id == null)
				throw new GeneralLogicException("Id del cliente no esta definido");

                this.service.eliminarCliente(id);
            return ResponseUtil.success().body(id).message("Se realizó la eliminación de los datos del cliente")
                                .send(HttpStatus.OK);
        }
}
