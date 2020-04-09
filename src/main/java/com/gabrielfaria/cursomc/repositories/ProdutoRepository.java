package com.gabrielfaria.cursomc.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielfaria.cursomc.domain.Categoria;
import com.gabrielfaria.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	@Transactional(readOnly = true) // usado quando é realizado apenas uma consulta não banco e não tem necessidade de fazer um transação
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> serch(@Param("nome") String nome,@Param("categorias") List<Categoria> categorias, Pageable pageRequest);
		//findDistinctByNomeContainingAndCategoriasIn utilizando esse nome no metodo não precisa da linha Query e faz a mesma coisa.
}
