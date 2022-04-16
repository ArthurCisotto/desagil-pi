package br.edu.insper.desagil.pi.scrubs;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ColaboradorTest {

	@Test
	public void constroi() {
		Colaborador colaborador = new Colaborador("arthurcm5", "Arthur Cisotto", "Estudante");
		assertEquals("Arthur Cisotto (Estudante)", colaborador.titulo());
		assertEquals("", colaborador.subdominio());
	}
}
