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

import com.epractica.api.entity.Asignatura;
import com.epractica.api.service.AsignaturaService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {
	  @Autowired
	    private AsignaturaService asignaturaService;

	    //Crear
	    @PostMapping
	    public ResponseEntity<?> create (@Valid @RequestBody Asignatura asignatura){
	        return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.save(asignatura));
	    }

	    //Leer
	    @GetMapping("/{id_asig}")
	    public ResponseEntity<?> read (@PathVariable(value = "id_asig") Long userId){
	        Optional<Asignatura> oUser = asignaturaService.findById(userId);

	        if(!oUser.isPresent()){
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(oUser);
	    }

	    //actualizar
	    @PutMapping("/{id_asig}")
	    public ResponseEntity<?> update (@Valid @RequestBody Asignatura userDetails, @PathVariable(value = "id_asig") Long userId){
	        Optional<Asignatura> asignatura = asignaturaService.findById(userId);

	        if (!asignatura.isPresent()){
	            return ResponseEntity.notFound().build();
	        }
	        asignatura.get().setNombre(userDetails.getNombre());
	        asignatura.get().setCarrera(userDetails.getCarrera());
	        asignatura.get().setHora_ini(userDetails.getHora_ini());
	        asignatura.get().setHora_fin(userDetails.getHora_fin());
		    

	        return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.save(asignatura.get()));
	    }

	    //eliminar
	    @DeleteMapping("/{id_asig}")
	    public ResponseEntity<?> delete (@PathVariable(value = "id_asig") Long userId){
	        if (!asignaturaService.findById(userId).isPresent()){
	            return ResponseEntity.notFound().build();
	        }
	        asignaturaService.deleteById(userId);
	        return ResponseEntity.ok().build();
	    }

	    //read all user
	    @GetMapping
	    public List<Asignatura> readAll(){
	        List<Asignatura> asignaturas = StreamSupport
	                .stream(asignaturaService.findAll().spliterator(), false)
	                .collect(Collectors.toList());
	        return asignaturas;
	    }
}
