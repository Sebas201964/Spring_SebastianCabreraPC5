package com.epractica.api.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "asignatura")
public class Asignatura implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_asig;

	
    
    @NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	private String nombre;
	@NotEmpty(message = "*Campo Obligatorio, no debe estar vacio")
	private String carrera;
	@NotEmpty(message = "*Campo Obligatorio, no debe estar vacio")
	private String hora_ini;

	@NotEmpty(message = "*Campo Obligatorio, no debe estar vacio")
	private String hora_fin;

	@OneToMany(mappedBy = "asignatura")
	private List<Docente> docente;

	public List<Docente> getDocente() {
		return docente;
	}

	public void setDocente(List<Docente> docente) {
		this.docente = docente;
	}

	public Long getId_asig() {
		return id_asig;
	}

	public void setId_asig(Long id_asig) {
		this.id_asig = id_asig;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHora_ini() {
		return hora_ini;
	}

	public void setHora_ini(String hora_ini) {
		this.hora_ini = hora_ini;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

}
