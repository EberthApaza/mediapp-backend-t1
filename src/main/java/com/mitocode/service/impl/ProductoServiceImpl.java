package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Producto;
import com.mitocode.repo.IProductoRepo;
import com.mitocode.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoRepo repo;

	@Override
	public Producto registrar(Producto obj) {
		return repo.save(obj);
		
	}

	@Override
	public Producto modificar(Producto obj) {
		return repo.save(obj);
		
	}

	@Override
	public List<Producto> listar() {
		return repo.findAll();
	}

	@Override
	public Producto leerPorId(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public void eliminar(Integer id) {
		repo.delete(id);
		
	}

	

}
