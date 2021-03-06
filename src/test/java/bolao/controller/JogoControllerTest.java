package bolao.controller;

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

	
	@Test
	public void testAdicionar() {
		CampeonatoController cc = new CampeonatoController();
		ClubeController clc = new ClubeController();
		
		jogo.setCampeonato(cc.carregar(7));
		jogo.setClubeCasa(clc.carregar(3));
		jogo.setClubeVisitante(clc.carregar(2));
		jogo.setNumeroRodada(1);
		
		jogoController.adicionar(jogo);
	}
	
	@Test
	public void testListar() {
		for(Jogo j : jogoController.listar()){
			System.out.println(j.getCampeonato().getCampeonato() + " " + j.getCampeonato().getNome() + "-" + j.getCampeonato().getAno() + ": " + j.getClubeCasa().getNome() + " x " + j.getClubeVisitante().getNome());
		}
	}
}