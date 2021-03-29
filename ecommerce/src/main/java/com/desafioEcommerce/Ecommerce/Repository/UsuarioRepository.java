package com.desafioEcommerce.Ecommerce.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafioEcommerce.Ecommerce.Models.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{	

	@Query(value= "SELECT * FROM usuario WHERE usuario.nome = :nome", nativeQuery = true)
	public List<Usuario>findAllUsuario(@Param("nome") String nome);
}
