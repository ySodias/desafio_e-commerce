package com.desafioEcommerce.Ecommerce.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafioEcommerce.Ecommerce.Models.Loja;
import com.desafioEcommerce.Ecommerce.Repository.LojaRepository;

@Service
public class LojaService {

	private @Autowired LojaRepository repositoryLoja;
	
	
	//Pegar as lojas
	
	public ResponseEntity <List<Loja>> pegarLojaPorNome(String nomeLoja){
		return ResponseEntity.status(HttpStatus.FOUND).body(repositoryLoja.findAllByNomeLojaContainingIgnoreCase(nomeLoja));
	
	}
	
	public ResponseEntity <List<Loja>> pegarPorDescricao(String descricao){
		return ResponseEntity.status(HttpStatus.FOUND).body(repositoryLoja.findAllByDescricao(descricao));
	
	}
	
	public ResponseEntity <Loja> pegarPorId(Long id){
		return repositoryLoja.findById(id)
				.map(prod -> ResponseEntity.ok(prod))
				.orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity <List<Loja>> pegarTodos(){
		return ResponseEntity.status(HttpStatus.FOUND).body(repositoryLoja.findAll());
	}
	
	public ResponseEntity<Loja> cadastrarLoja(Loja loja){
		if(repositoryLoja.findAll().contains(loja)) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();		
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(repositoryLoja.save(loja));
		}
	}
	
	public ResponseEntity<Loja> atulizando(Loja loja){
		if(repositoryLoja.findAll().contains(loja)) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();		
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(repositoryLoja.save(loja));
		}
	}
	
	
	public void deletandoLoja(Long idLoja) {
		repositoryLoja.deleteById(idLoja);
	
}
}