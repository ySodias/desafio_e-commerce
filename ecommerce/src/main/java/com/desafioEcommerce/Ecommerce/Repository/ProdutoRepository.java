package com.desafioEcommerce.Ecommerce.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafioEcommerce.Ecommerce.Models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByValorLessThan(Float valor);

	List<Produto> findByValorGreaterThanEqual(Float valor);

	boolean existsByTituloProduto(String tituloProduto);

	@Query(value = "SELECT * FROM produto WHERE tituloProduto")
	List<Produto> findByTituloProdutoContainingIgnoreCase(String tituloProduto);

	@Query(value = "SELECT * FROM produto WHERE tituloProduto= :tituloProduto AND valor = :valor")
	public Optional<Produto> findByTituloProdutoAndValor(@Param("tituloProduto") String tituloProduto,
			@Param("valor") Float valor);

}
