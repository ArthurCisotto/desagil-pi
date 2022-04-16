package br.edu.insper.desagil.pi.scrubs;

public class Paciente {
	
	private String cpf;
	private String nome;
	
	public Paciente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	
}
