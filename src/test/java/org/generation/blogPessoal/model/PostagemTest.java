package org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostagemTest {

	public Postagem postagem;
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@BeforeEach
	public void start() {
		postagem = new Postagem("Titulo", "Texto");
	}
	
	@Test
	void testValidarAtributos() {
		Set<ConstraintViolation<Postagem>> violation = validator.validate(postagem);
		System.out.println(violation.toString());
		assertTrue(violation.isEmpty());
	}
	
	@Test
	void testValidarAtibutosNulos() {
		Postagem postagemErro = new Postagem();
		postagemErro.setTitulo("Titulo");
		Set<ConstraintViolation<Postagem>> violation = validator.validate(postagemErro);
		System.out.println(violation.toString());
		assertFalse(violation.isEmpty());
	}
	
}
