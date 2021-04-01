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

import com.desafioEcommerce.Ecommerce.Models.Usuario;
import com.desafioEcommerce.Ecommerce.Service.UsuarioService;

@RestController
@RequestMapping("api/v1/ecommerce/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuario(){
		return serviceUsuario.findAllUsuario();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getByIdUsuario(@PathVariable Long id){
		return serviceUsuario.findAllByIdUsuario(id);
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNomeUsuario(@PathVariable String nome){
		return serviceUsuario.findAllUsuarioByNome(nome);
	}
	@PostMapping
	public ResponseEntity<Usuario>newUsuario(@RequestBody Usuario usuario){
		return serviceUsuario.postNewUsuario(usuario);
	}
	@PutMapping
	public ResponseEntity<Usuario>editUsuario(@RequestBody Usuario usuario){
		return serviceUsuario.putEditUsuario(usuario);
	}
	@DeleteMapping("/{id}")
	public void deleteExistentUsuario(@PathVariable Long id) {
		serviceUsuario.deleteUsuario(id);
	}
}
