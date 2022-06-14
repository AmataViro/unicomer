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

import ch.qos.logback.core.net.server.Client;

@Service
public class ClienteService {
	@Autowired
    private ClienteRepository repository;


    @Transactional
    public Integer agregarCliente(ClienteDto cliente) {
        final Cliente o = this.repository.save(cliente.createEntity());
        return o.getId();
    }

    @Transactional
    public Integer actualizarCliente(ClienteDto cliente) {

        Cliente o_db = this.repository.findById(cliente.getId()).orElseThrow(
                () -> new GeneralLogicException("Cliente [" + cliente.getNombre() + "] no existe"));
        Cliente o = this.repository.save(cliente.createEntity(o_db));
        return o.getId();
    }

	
	/**
     * Obtener todos los clientes
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

    public ClienteDto obtenerCostoPorId(Integer id) {
        final Cliente o = this.repository.findById(id)
                .orElseThrow(() -> new GeneralLogicException("Costo [" + id + "] no existe"));
                ClienteDto dto = new ClienteDto(o);

        return dto;
    }

    @Transactional
    public void eliminarCliente(Integer id) {
        this.repository.deleteById(id);
    }
}
