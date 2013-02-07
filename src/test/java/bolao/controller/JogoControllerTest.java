package bolao.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import bolao.model.Jogo;

public class JogoControllerTest {
	
	private Jogo jogo;
	private JogoController jogoController;
	
	@Before
	public void setUp() throws Exception {
		this.jogo = new Jogo();
		this.jogoController = new JogoController();
	}

	@Ignore
	@Test
	public void testAdicionar() {
		CampeonatoController cc = new CampeonatoController();
		ClubeController clc = new ClubeController();
		
		jogo.setCampeonato(cc.carregar(32));
		jogo.setClubeCasa(clc.carregar(13));
		jogo.setClubeVisitante(clc.carregar(31));
		jogo.setNumeroRodada(1);
		
		jogoController.adicionar(jogo);
	}
	
	/*
	@Test
	public void testAtualizar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	public void testListar() {
		for(Jogo j : jogoController.listar()){
			System.out.println(j.getCampeonato().getNome() + "-" + j.getCampeonato().getAno() + ": " + j.getClubeCasa().getNome() + " x " + j.getClubeVisitante().getNome());
		}
	}

	/*
	@Test
	public void testCarregar() {
		fail("Not yet implemented");
	}*/

}