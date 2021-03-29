package com.desafioEcommerce.Ecommerce.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafioEcommerce.Ecommerce.Models.Usuario;
import com.desafioEcommerce.Ecommerce.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repositoryUsuario;
	
	public ResponseEntity<List<Usuario>>findAllUsuario(){
		return ResponseEntity.ok(repositoryUsuario.findAll());
	}
	public ResponseEntity<Usuario> findAllByIdUsuario(Long id){
		return repositoryUsuario.findById(id)
				.map(usu -> ResponseEntity.ok(usu))
				.orElse(ResponseEntity.notFound().build());
	}
	public ResponseEntity<List<Usuario>>findAllUsuarioByNome(String name){
		return ResponseEntity.ok(repositoryUsuario.findAllUsuario(name));
	}
	public ResponseEntity<Usuario>postNewUsuario(Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryUsuario.save(usuario));
	}
	public ResponseEntity<Usuario>putEditUsuario(Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryUsuario.save(usuario));
	}
	public void deleteUsuario(Long id) {
		repositoryUsuario.deleteById(id);
	}
}
