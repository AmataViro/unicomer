package com.unicomer.api.apirest.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicomer.api.apirest.dto.ClienteDto;
import com.unicomer.api.apirest.model.Cliente;
import com.unicomer.api.apirest.repository.ClienteRepository;
import com.unicomer.api.apirest.util.GeneralLogicException;

@Service
public class ClienteService {
	@Autowired
    private ClienteRepository repository;

    /**
     * Crear el registro de los datos de un cliente
     * 
     * @param cliente
     * @return Id del cliente registrado
     */
    @Transactional
    public Integer agregarCliente(ClienteDto cliente) {
        final Cliente o = this.repository.save(cliente.createEntity());
        return o.getId();
    }

    /**
     * Actualizar el registro de los datos de un cliente
     * 
     * @param cliente
     * @return Id del cliente actualizado
     */
    @Transactional
    public Integer actualizarCliente(ClienteDto cliente) {

        Cliente o_db = this.repository.findById(cliente.getId()).orElseThrow(
                () -> new GeneralLogicException("Cliente [" + cliente.getNombre() + "] no existe"));
        Cliente o = this.repository.save(cliente.createEntity(o_db));
        return o.getId();
    }
	
	/**
     * Obtener un listado de todos los clientes
     * 
     * @param clientes
     * @return Lista de registros de clientes
     */
    public List<ClienteDto> obtenerClientes(){
    	List<ClienteDto> lista = this.repository.findAll().stream().map(o -> {
            ClienteDto dto = new ClienteDto(o);
            return dto;
        }).collect(Collectors.toList());
        return lista;
    }

    /**
     * Obtener los datos del registro de un cliente segun su id
     * 
     * @param id
     * @return Datos del cliente
     */
    public ClienteDto obtenerClientePorId(Integer id) {
        final Cliente o = this.repository.findById(id)
                .orElseThrow(() -> new GeneralLogicException("Cliente [" + id + "] no existe"));
                ClienteDto dto = new ClienteDto(o);

        return dto;
    }

    /**
     * Eliminar el registro de un cliente
     * 
     * @param id
     */
    @Transactional
    public void eliminarCliente(Integer id) {
        this.repository.deleteById(id);
    }
    
}
