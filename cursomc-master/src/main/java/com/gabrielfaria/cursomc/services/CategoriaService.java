package com.gabrielfaria.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gabrielfaria.cursomc.domain.Categoria;
import com.gabrielfaria.cursomc.dto.CategoriaDTO;
import com.gabrielfaria.cursomc.repositories.CategoriaRepository;
import com.gabrielfaria.cursomc.services.exception.DateIntegrityException;
import com.gabrielfaria.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj); //atualiza os dados do cliente no banco de dados 
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DateIntegrityException("Não é possível excluir uma categoria que ainda tenha produtos");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	} //utilizado para fazer paginação dos dados contidos no sistema pois se abrir muitos de uma vez pode causar problemas
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria (objDto.getId(), objDto.getNome());
	}
	
	private void updateData (Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}

}
