package com.gabrielfaria.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielfaria.cursomc.domain.Estado;
import com.gabrielfaria.cursomc.repositories.EstadoRepository;

@Service //colocado para injetar os objetos
public class EstadoService {

	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll(){
		return repo.findAllByOrderByNome();
	}
}
