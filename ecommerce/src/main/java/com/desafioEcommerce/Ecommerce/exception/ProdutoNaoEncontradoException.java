package com.desafioEcommerce.Ecommerce.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public ProdutoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
