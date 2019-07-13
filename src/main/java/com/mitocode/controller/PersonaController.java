package com.mitocode.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> lista=service.listar();
		return new ResponseEntity<List<Persona>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> leerPorId(@PathVariable("id") Integer id) {
		Persona obj=service.leerPorId(id);
		return new ResponseEntity<Persona>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Persona obj) {
		Persona persona = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(persona.getIdPersona()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Persona obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
}
