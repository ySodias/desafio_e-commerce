package com.desafioEcommerce.Ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafioEcommerce.Ecommerce.Models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findAllByValorLessThan(Float valor);

	List<Produto> findAllByValorGreaterThanEqual(Float valor);

	@Query(value = "SELECT * FROM produto WHERE titulo_produto= :tituloProduto", nativeQuery = true)
	public List<Produto> findAllByTituloProdutoContainingIgnoreCase(@Param("tituloProduto") String tituloProduto);

	@Query(value = "SELECT * FROM produto WHERE titulo_produto= :tituloProduto AND valor = :valor", nativeQuery = true)
	public List<Produto> findAllByTituloProdutoAndValor(@Param("tituloProduto") String tituloProduto,
			@Param("valor") Float valor);

}