package org.generation.blogPessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 100, message = "Error name size")
	private String nome;
	
	@NotNull
	@Size(min = 2, max = 100, message = "Error user size")
	private String user;
	
	@NotNull
	@Size(min = 2, max = 100, message = "Error password size")
	private String senha;

	
	public Usuario() {
		
	}
	
	public Usuario(@NotNull String user, @NotNull String senha) {
		this.user = user;
		this.senha = senha;
	}
	
	//Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	//Nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	//User
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
	//Senha
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
