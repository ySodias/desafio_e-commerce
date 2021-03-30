package com.desafioEcommerce.Ecommerce.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioEcommerce.Ecommerce.Models.Usuario;
import com.desafioEcommerce.Ecommerce.Repository.UsuarioRepository;

@RestController
@RequestMapping("api/v1/ecommerce/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("nome/{nome}")
	public ResponseEntity<List<Usuario>> getAllUsuarioByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllUsuario(nome));
	}
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
}
