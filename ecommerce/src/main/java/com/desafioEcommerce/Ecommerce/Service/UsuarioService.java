package com.desafioEcommerce.Ecommerce.Service;

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
	
	
	
	public ResponseEntity<Usuario>postNewUsuario(Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryUsuario.save(usuario));
	}
	
}
