package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repositorio;
	
	@BeforeAll
	void start() {
		Usuario usuario = new Usuario("Beatriz", "1234");
		if(repositorio.findByUser(usuario.getUser())!=null)
			repositorio.save(usuario);
		
		usuario = new Usuario("Bea", "12345");
		if(repositorio.findByUser(usuario.getUser())!=null)
			repositorio.save(usuario);
		
		usuario = new Usuario("BeaSofientini", "1234");
		if(repositorio.findByUser(usuario.getUser())!=null)
			repositorio.save(usuario);
	}
	
	@Test
	public void findByUsuarioRetornaUsuario() throws Exception {

		Usuario usuario = repositorio.findByUser("Beatriz").get();
		assertTrue(usuario.getUser().equals("Beatriz"));
	}
	
	@AfterAll
	public void end() {
		repositorio.deleteAll();
	}

}