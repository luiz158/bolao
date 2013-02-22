package bolao.controller;

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
	public void testAdicionar() {
		String clubes[] = {"Campinense", "Treze", "CSP"};
		
		for(int i = 0; i < clubes.length; i++){
			Clube clube = new Clube();
			
			clube.setNome(clubes[i]);
			cc.adicionar(clube);
		}
	}

	@Test
	public void testListar() {
		for(Clube cl : cc.listar()){
			System.out.println(cl.getClube() + " " + cl.getNome());
		}
	}
}