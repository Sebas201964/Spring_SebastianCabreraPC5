package com.epractica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epractica.api.entity.Docente;
@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long>{

}
