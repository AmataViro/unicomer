package com.unicomer.api.apirest.model;

import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="cliente")
@DynamicUpdate
public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "first_name", nullable = false, unique = true)
	private String nombre;

	@Column(name = "last_name", nullable = false, unique = true)
	private String apellido;

	@Column(name = "birthday", nullable = false, unique = true)
	private Date fechaNacimiento;

	@Column(name = "gender", nullable = false, unique = true)
	private String genero;

	@Column(name = "cellphone", nullable = false, unique = true)
	private Integer telefonoMovil;

	@Column(name = "home_phone", nullable = false, unique = true)
	private Integer telefonoFijo;

	@Column(name = "address_home", nullable = false, unique = true)
	private String direccion;

	@Column(name = "profession", nullable = false, unique = true)
	private String profesion;
	
	@Column(name = "incomes", nullable = false, unique = true)
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

	@Override
	public String toString() {
		return "Cliente [apellido=" + apellido + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento
				+ ", genero=" + genero + ", id=" + id + ", ingresos=" + ingresos + ", nombre=" + nombre + ", profesion="
				+ profesion + ", telefonoFijo=" + telefonoFijo + ", telefonoMovil=" + telefonoMovil + "]";
	}
	

}
