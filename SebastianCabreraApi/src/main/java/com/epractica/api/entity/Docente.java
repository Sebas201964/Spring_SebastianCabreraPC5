package com.epractica.api.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="docente")
public class Docente implements Serializable{
	private static final long serialVersionUID = 4626912300073047023L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	@NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	private String nombre;
	
	@NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	private String apellido;
	
	@Size(min=10,max=10,message="El numero de caracteres debe ser 10 digitos")
	private String celular;

	@NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	@Email(message="El correo debe tener el formato prueba@prueba.com")
	@Column(name="mail",nullable=false, length=50, unique=true)
	private String email;
	
	@ManyToOne
	private Asignatura asignatura;

	
	
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
/*
relaciones se coloca en la clase un ide igual y en la otra 
@manytoone 
private Aula aula;
@onetomay(mappedbby="aula")
private list Studients studients
setter y getter 
*/
