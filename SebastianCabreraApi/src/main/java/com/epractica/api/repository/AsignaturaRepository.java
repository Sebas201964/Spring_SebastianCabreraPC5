package com.epractica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epractica.api.entity.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{

}
