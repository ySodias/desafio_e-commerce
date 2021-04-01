package com.desafioEcommerce.Ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafioEcommerce.Ecommerce.Models.Produto;
import com.desafioEcommerce.Ecommerce.Repository.ProdutoRepository;
import com.desafioEcommerce.Ecommerce.exception.ProdutoException;
import com.desafioEcommerce.Ecommerce.exception.ProdutoNaoEncontradoException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void deletar(Long id) {
		try {
			produtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ProdutoNaoEncontradoException(String.format("Produto de %d não encontrado", id));
		} catch (DataIntegrityViolationException e) {
			throw new ProdutoException(String.format("%d Não pode ser removido", id));
		}
	}

}
