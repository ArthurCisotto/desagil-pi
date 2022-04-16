package br.edu.insper.desagil.pi.scrubs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HospitalTest {
	
	private Hospital h;
	private Paciente pc1;
	private List<Paciente> listaPacientes;
	private Medico m1;
	private Prontuario pr1;
	private List<Prontuario> listaProntuarios;
	
	@BeforeEach
	private void setUp() {
		listaPacientes  = new ArrayList<>();
		pc1 = new Paciente("123.456.789-10", "Arthur Cisotto");
		listaPacientes.add(pc1);

		m1 = new Medico("jessicacm", "Jessica Cisotto", "Oncologia");
		listaProntuarios = new ArrayList<>();
		pr1 = new Prontuario(pc1, m1);
		listaProntuarios.add(pr1);
		
		h = new Hospital("insper.edu.br",listaPacientes,listaProntuarios);
	}
	
	@Test
	public void emailColaboradorSemSubdominio() {
		Colaborador colaboradorSemSubdominio =  new Colaborador("arthurcm5", "Arthur Cisotto", "Estudante");
		assertEquals("arthurcm5@insper.edu.br", h.email(colaboradorSemSubdominio));
	}
	
	@Test
	public void emailColaboradorComSubdominio() {
		assertEquals("jessicacm@md.insper.edu.br", h.email(m1));
	}
	
	@Test
	public void cadastraNovoPaciente() {
		h.cadastra("123.456.789-11", "Andre Brito");
		
		List<String> listaNomesDesejada = new ArrayList<>();
		listaNomesDesejada.add("Arthur Cisotto");
		listaNomesDesejada.add("Andre Brito");
		
		assertEquals(listaNomesDesejada, h.nomesPacientes());
		assertEquals(listaNomesDesejada.size(),h.nomesPacientes().size());
	}
	
	@Test
	public void cadastraMesmoPacienteNovoNome() {
		h.cadastra("123.456.789-10", "Andre Brito");
		
		List<String> listaNomesDesejada = new ArrayList<>();
		listaNomesDesejada.add("Andre Brito");
		
		assertEquals(listaNomesDesejada, h.nomesPacientes());
		assertEquals(listaNomesDesejada.size(),h.nomesPacientes().size());
	}
	
	@Test
	public void internaNaoInternado() {
		Paciente pc2 = new Paciente("123.456.789-11", "Andre Brito");
		assertTrue(h.interna(pc2, m1, "gripe"));
	}
	
	@Test
	public void naoInternaInternado() {
		assertFalse(h.interna(pc1, m1, "asma"));
	}
	
	@Test
	public void internaComMesmoMedico() {
		Paciente pc2 = new Paciente("123.456.789-11", "Andre Brito");
		h.interna(pc2, m1, "gripe");
		assertEquals(pc1.getCpf(),h.pacientesDe(m1.getLogin()).get(0).getCpf());
		assertEquals(pc2.getCpf(),h.pacientesDe(m1.getLogin()).get(1).getCpf());
	}
	
	@Test
	public void internaComMedicosDiferentes() {
		Medico m2 = new Medico("fernandocg", "Fernando Cenci Guimaraes", "Oftalmologia");
		Paciente pc2 = new Paciente("123.456.789-11", "Andre Brito");
		h.interna(pc2, m2, "catarata");
		assertEquals(pc1.getCpf(),h.pacientesDe(m1.getLogin()).get(0).getCpf());
		assertEquals(pc2.getCpf(),h.pacientesDe(m2.getLogin()).get(0).getCpf());
	}
}
