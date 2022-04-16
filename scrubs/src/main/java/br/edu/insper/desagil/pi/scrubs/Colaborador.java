package br.edu.insper.desagil.pi.scrubs;

public class Colaborador {
	
	private String login;
	private String nome;
	private String cargo;
	
	public Colaborador(String login, String nome, String cargo) {
		this.login = login;
		this.nome = nome;
		this.cargo = cargo;
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
	public String getCargo() {
		return cargo;
	}
	
	public String titulo() {
		String titulo = nome + " (" + cargo + ")";
		return titulo;
	}
	
	public String subdominio() {
		return "";
	}
	
}
