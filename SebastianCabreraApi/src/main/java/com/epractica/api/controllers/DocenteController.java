package com.epractica.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epractica.api.entity.Docente;
import com.epractica.api.service.DocenteService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/docente")
public class DocenteController {
	   @Autowired
	    private DocenteService docenteService;

	    //Crear
	    @PostMapping
	    public ResponseEntity<?> create (@Valid @RequestBody Docente docente){
	        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.save(docente));
	    }

	    //Leer
	    @GetMapping("/{id}")
	    public ResponseEntity<?> read (@PathVariable(value = "id") Long userId){
	        Optional<Docente> oUser = docenteService.findById(userId);

	        if(!oUser.isPresent()){
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(oUser);
	    }

	    //actualizar
	    @PutMapping("/{id}")
	    public ResponseEntity<?> update (@Valid @RequestBody Docente userDetails, @PathVariable(value = "id") Long userId){
	        Optional<Docente> docente = docenteService.findById(userId);

	        if (!docente.isPresent()){
	            return ResponseEntity.notFound().build();
	        }
	        docente.get().setNombre(userDetails.getNombre());
	        docente.get().setApellido(userDetails.getApellido());
	        docente.get().setCelular(userDetails.getCelular());
	        docente.get().setEmail(userDetails.getEmail());
	        docente.get().setAsignatura(userDetails.getAsignatura());
	        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.save(docente.get()));
	    }

	    //eliminar
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete (@PathVariable(value = "id") Long userId){
	        if (!docenteService.findById(userId).isPresent()){
	            return ResponseEntity.notFound().build();
	        }
	        docenteService.deleteById(userId);
	        return ResponseEntity.ok().build();
	    }

	    //read all user
	    @GetMapping
	    public List<Docente> readAll(){
	        List<Docente> docentes = StreamSupport
	                .stream(docenteService.findAll().spliterator(), false)
	                .collect(Collectors.toList());
	        return docentes;
	    }
}
