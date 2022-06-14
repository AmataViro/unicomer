package com.unicomer.api.apirest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicomer.api.apirest.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	List<Cliente> findAll();
}
