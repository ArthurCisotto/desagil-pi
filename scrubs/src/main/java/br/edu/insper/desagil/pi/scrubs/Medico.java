package br.edu.insper.desagil.pi.scrubs;

public class Medico extends Colaborador {
	private String especialidade;

	public Medico(String login, String nome, String especialidade) {
		super(login, nome, "Médico");
		this.especialidade = especialidade;
	}

	@Override
	public String titulo() {
		String titulo = "MD " + getNome() + " (" + especialidade + ")";
		return titulo;
	}

	@Override
	public String subdominio() {
		return "md";
	}	
}
