package com.epractica.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.epractica.api.entity.Asignatura;



public interface AsignaturaService {
	public Iterable<Asignatura> findAll();
	public Page<Asignatura> findAll(Pageable pageable);
	
	public Optional<Asignatura> findById(Long id_asig);
	
	public Asignatura save(Asignatura asignatura);
	
	public void deleteById(Long id_asig);
}
