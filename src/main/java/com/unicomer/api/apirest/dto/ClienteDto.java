package com.unicomer.api.apirest.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.unicomer.api.apirest.model.Cliente;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ClienteDto", description = "Estructura de datos de Cliente")
@JsonPropertyOrder({})
public class ClienteDto {
	@ApiModelProperty(value = "Id del cliente", example = "1")
    private Integer id;
	
	@ApiModelProperty(value = "Nombre del cliente", example = "Pedro")
    private String nombre;
	
	@ApiModelProperty(value = "Apellido del cliente", example = "Perez")
    private String apellido;
	
	@ApiModelProperty(value = "Fecha de nacimiento del cliente", example = "1990-01-01")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Santiago")
    private Date fechaNacimiento;
	
	@ApiModelProperty(value = "Genero del cliente", example = "Masculino")
    private String genero;
	
	@ApiModelProperty(value = "Número de teléfono del cliente", example = "123456987")
    private Integer telefonoMovil;
	
	@ApiModelProperty(value = "Número de teléfono de casa del cliente", example = "456789122")
    private Integer telefonoFijo;
	
	@ApiModelProperty(value = "Dirección del cliente", example = "Santiago de Chile")
    private String direccion;
	
	@ApiModelProperty(value = "Profesión del cliente", example = "Informático")
    private String profesion;
	
	@ApiModelProperty(value = "Ingreso del cliente", example = "350000")
    private Float ingresos;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(Integer telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public Integer getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(Integer telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public Float getIngresos() {
		return ingresos;
	}

	public void setIngresos(Float ingresos) {
		this.ingresos = ingresos;
	}

	public Cliente createEntity() {
		Cliente e = new Cliente();
        if (this.getId() != null)
            e.setId(this.id);
            
        this.createEntity(e);

        return e;
    }
        
    public Cliente createEntity(Cliente e) {
		e.setNombre(this.nombre);
		e.setApellido(this.apellido);
		e.setFechaNacimiento(this.fechaNacimiento);
		e.setGenero(this.genero);
		e.setTelefonoMovil(this.telefonoMovil);
		e.setTelefonoFijo(this.telefonoFijo);
		e.setDireccion(this.direccion);
		e.setProfesion(this.profesion);
		e.setIngresos(this.ingresos);

    	return e;
    
    }
    
    public ClienteDto() {
		
	}
    
    
    public ClienteDto(Cliente entity) {
    	this.setId(entity.getId());
    	this.setNombre(entity.getNombre());
    	this.setApellido(entity.getApellido());
    	this.setFechaNacimiento(entity.getFechaNacimiento());
    	this.setGenero(entity.getGenero());
    	this.setTelefonoMovil(entity.getTelefonoMovil());
    	this.setTelefonoFijo(entity.getTelefonoFijo());
    	this.setDireccion(entity.getDireccion());
    	this.setProfesion(entity.getProfesion());
    	this.setIngresos(entity.getIngresos());
    }

	@Override
	public String toString() {
		return "ClienteDto [apellido=" + apellido + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento
				+ ", genero=" + genero + ", id=" + id + ", ingresos=" + ingresos + ", nombre=" + nombre + ", profesion="
				+ profesion + ", telefonoFijo=" + telefonoFijo + ", telefonoMovil=" + telefonoMovil + "]";
	}

	
    
}
