package br.edu.insper.desagil.pi.scrubs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MedicoTest {
	
	@Test
	public void constroi() {
		Medico medico = new Medico("jessicacm", "Jessica Cisotto", "Oncologia");
		assertEquals("MD Jessica Cisotto (Oncologia)", medico.titulo());
		assertEquals("md", medico.subdominio());
	}
}
