package com.desafioEcommerce.Ecommerce.Models;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table (name="usuario", uniqueConstraints = @UniqueConstraint(columnNames="usuario"))
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=45)
	private String nome;
	
	@NotNull
	@Size(min=6, max=12)
	private String usuario;
	
	@NotNull
	@Size(min=6, max=12)
	private String senha;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		name = "inscricao",
		joinColumns = @JoinColumn(name = "fk_idUsuario"),
		inverseJoinColumns = @JoinColumn(name = "fk_idLoja"))
	private List<Loja> lojasInscrita;	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Loja> getLojasInscrita() {
		return lojasInscrita;
	}

	public void setLojasInscrita(List<Loja> lojasInscrita) {
		this.lojasInscrita = lojasInscrita;
	}


	
}
