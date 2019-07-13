package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Persona;
import com.mitocode.repo.IPersonaRepo;
import com.mitocode.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaRepo repo;

	@Override
	public Persona registrar(Persona obj) {
		return repo.save(obj);
		
	}

	@Override
	public Persona modificar(Persona obj) {
		return repo.save(obj);
		
	}

	@Override
	public List<Persona> listar() {
		return repo.findAll();
	}

	@Override
	public Persona leerPorId(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public void eliminar(Integer id) {
		repo.delete(id);
		
	}

	

}
