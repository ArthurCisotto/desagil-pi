package br.edu.insper.desagil.pi.scrubs;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
	private String dominio;
	private List<Paciente> pacientes;
	private List<Prontuario> prontuarios;
	
	public Hospital(String dominio, List<Paciente> pacientes, List<Prontuario> prontuarios) {
		this.dominio = dominio;
		this.pacientes = pacientes;
		this.prontuarios = prontuarios;
	}
	
	public String email(Colaborador colaborador) {
		String email;
		if(colaborador.subdominio().equals("")) {
			email = colaborador.getLogin() + "@" + dominio;
		}else {
			email = colaborador.getLogin() + "@" + colaborador.subdominio() + "." + dominio;
		}	
		return email;
	}
	
	public void cadastra(String cpf, String nome) {
		for (Paciente paciente: pacientes) {
			if (paciente.getCpf().equals(cpf)) {
				paciente.setNome(nome);
				return;
			}
		}
		Paciente pacienteNovo = new Paciente(cpf,nome);
		pacientes.add(pacienteNovo);	
	}
	
	public boolean interna(Paciente paciente, Medico medico, String diagnostico) {
		for (Prontuario prontuario: prontuarios) {
			if(prontuario.getPaciente().getCpf().equals(paciente.getCpf())) {
				return false;
			}
		}
		Prontuario prontuarioNovo = new Prontuario(paciente, medico);
		prontuarioNovo.anota(medico, diagnostico);
		prontuarios.add(prontuarioNovo);
		return true;
	}
	
	public List<String> nomesPacientes() {
		List<String> nomesPacientes = new ArrayList<>();
		for (Paciente paciente: pacientes) {
			nomesPacientes.add(paciente.getNome());
		}
		return nomesPacientes;
	}
	
	public List<Paciente> pacientesDe(String login) {
		List<Paciente> listaPacientes = new ArrayList<>();
		for (Prontuario prontuario: prontuarios) {
			if(prontuario.getMedico().getLogin().equals(login)) {
				listaPacientes.add(prontuario.getPaciente());
			}
		}
		return listaPacientes;
	}
}
