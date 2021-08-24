package com.lcsouza.portifolio.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String idade;
	private String email;
	//criar enum para genero
	private String genero;
	private Empresa empresa;
	
	
	public User(Long id,String nome,Empresa empresa) {
		super();
		this.nome = nome;
		this.id = id ;
		
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome);
	}
	

}
