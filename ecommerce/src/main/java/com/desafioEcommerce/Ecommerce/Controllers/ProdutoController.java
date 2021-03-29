package com.desafioEcommerce.Ecommerce.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafioEcommerce.Ecommerce.Models.Produto;
import com.desafioEcommerce.Ecommerce.Repository.ProdutoRepository;
import com.desafioEcommerce.Ecommerce.Service.ProdutoService;

@RestController
@RequestMapping("api/v1/ecommerce/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> GetAll() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable("id") Long id) {
		return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/tituloProduto/{tituloProduto}")
	public ResponseEntity<List<Produto>> GetByValor(@PathVariable String tituloProduto) {
		return ResponseEntity.ok(produtoRepository.findByTituloProdutoContainingIgnoreCase(tituloProduto));
	}
	
	@GetMapping("/tituloProduto/{tituloProduto}/valor/{valor}")

	@PostMapping
	public Produto post(@RequestBody Produto produto) {
		return service.salvar(produto);
	}

	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deletar(id);
	}

}