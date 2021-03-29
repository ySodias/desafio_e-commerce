package com.desafioEcommerce.Ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafioEcommerce.Ecommerce.Models.Loja;

public interface LojaRepository extends JpaRepository<Loja,Long> {
	public List<Loja> findAllByNomeLojaContainingIgnoreCase(String nomeLoja);
	public List<Loja> findAllByDescricao(String descricao);
	
	@Query(value = "SELECT * FROM Loja WHERE nomeLoja LIKE A% ", nativeQuery = true)
	public List<Loja> findByNomeLojaA(@Param("nome") String nomeLoja);
	

}
