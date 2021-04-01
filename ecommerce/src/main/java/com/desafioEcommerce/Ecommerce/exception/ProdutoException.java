package com.desafioEcommerce.Ecommerce.exception;

public class ProdutoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ProdutoException(String mensagem) 
	{
		super(mensagem);
	}

}
