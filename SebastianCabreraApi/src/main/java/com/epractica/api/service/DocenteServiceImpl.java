package com.epractica.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epractica.api.entity.Asignatura;
import com.epractica.api.entity.Docente;
import com.epractica.api.repository.AsignaturaRepository;
import com.epractica.api.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService{
	 @Autowired
	    private DocenteRepository docenteRepository;

	    @Override
	    @Transactional(readOnly = true)
	    public Iterable<Docente> findAll() {
	        return docenteRepository.findAll();
	    }

	    @Override
	    @Transactional(readOnly = true)
	    public Page<Docente> findAll(Pageable pageable) {
	        return docenteRepository.findAll(pageable);
	    }

	    @Override
	    @Transactional(readOnly = true)
	    public Optional<Docente> findById(Long id) {
	        return docenteRepository.findById(id);
	    }

	    @Override
	    @Transactional
	    public Docente save(Docente profesor) {
	        return docenteRepository.save(profesor);
	    }

	    @Override
	    @Transactional
	    public void deleteById(Long id_asig) {
	    	docenteRepository.deleteById(id_asig);
	    }
}
