package com.desafioEcommerce.Ecommerce.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max= 100)
	private String tituloProduto;
	
	@NotNull
	private Float valor;
	
	@NotNull
	private String urlImagem;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
//	private Loja loja;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloProduto() {
		return tituloProduto;
	}

	public void setTituloProduto(String tituloProduto) {
		this.tituloProduto = tituloProduto;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	
	
	
}
