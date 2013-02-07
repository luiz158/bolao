package bolao.controller;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import bolao.model.Clube;

public class ClubeControllerTest {
	
	private static ClubeController cc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cc = new ClubeController();
	}

	@Test
	public void testAdicionarTudoNull() {
		Clube clube = new Clube();
		
		assertNotEquals("Erro", cc.adicionar(clube));		
	}

	@Test
	public void testAtualizar() {
		//fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		//fail("Not yet implemented");
	}

	@Test
	public void testListar() {
		for(Clube cl : cc.listar()){
			System.out.println(cl.getClube() + " " + cl.getNome());
		}
	}

	@Test
	public void testCarregar() {
		//fail("Not yet implemented");
	}
}
