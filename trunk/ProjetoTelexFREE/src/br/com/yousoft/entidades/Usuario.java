package br.com.yousoft.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity (name = "usuario")
public class Usuario {

	@GeneratedValue
	@Id
	private Long id;
	
	@Column(name = "nome", length = 200, nullable = true)
	private String nome;
	
	@Column(name = "login", length = 30, nullable = true)
	private String login;
	
	@Column(name = "senha", length = 100, nullable = true)
	private String senha;
	
	@Column(name = "situacao", length = 30, nullable = true)
	private String situacao;
	
	@Column(name = "status", length = 20, nullable = true)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
