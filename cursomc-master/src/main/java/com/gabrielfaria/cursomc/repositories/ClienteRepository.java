package com.gabrielfaria.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielfaria.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Transactional(readOnly=true) // faz a busca ficar mais rapida pois não necessita de ser envolvida com um transação de banco de dados
	Cliente findByEmail(String email);

}
