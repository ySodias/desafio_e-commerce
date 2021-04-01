package com.desafioEcommerce.Ecommerce.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioEcommerce.Ecommerce.Models.Loja;
import com.desafioEcommerce.Ecommerce.Repository.LojaRepository;
import com.desafioEcommerce.Ecommerce.Service.LojaService;

@RestController
@RequestMapping("api/v1/ecommerce/loja")
@CrossOrigin("*")
public class LojaController {
	
	@Autowired
	LojaService service;
	
	@Autowired
	LojaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Loja>> pegarTodos(){
			return (ResponseEntity<List<Loja>>) service.pegarTodos();
	}
	
	@GetMapping("nome/{nomeLoja}")
	public ResponseEntity<List<Loja>> pegarPorNome(@PathVariable String nomeLoja){
		return (ResponseEntity<List<Loja>>) service.pegarLojaPorNome(nomeLoja);
	}

	@GetMapping("descricao/{descricao}")
	public ResponseEntity<List<Loja>> pegarPorDescriacao(@PathVariable String descricao){
		return (ResponseEntity<List<Loja>>) service.pegarPorDescricao(descricao);
	}
	@GetMapping("id/{idLoja}")
	public ResponseEntity<Loja> pegarPorId(@PathVariable Long idLoja){
		return service.pegarPorId(idLoja);
	}
	
	@GetMapping("nomelojacomA/{nomeLoja}")
	public ResponseEntity<List<Loja>> pegarLojaComA (@PathVariable String nomeLoja){
		return ResponseEntity.ok(repository.findByNomeStartingWithA(nomeLoja));
	}
	
	@PostMapping
	public ResponseEntity<Loja> cadastro (@RequestBody Loja loja){
		return service.cadastrarLoja(loja);
	}
		
	@PutMapping
	public ResponseEntity<Loja> atualizando (@RequestBody Loja loja){
		return service.atulizando(loja);
	}
	
	@DeleteMapping("/{id}")
	public void deletando(@PathVariable Long id) {
		service.deletandoLoja(id);
			
	}
}
