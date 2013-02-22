package bolao.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import bolao.model.Campeonato;
import bolao.model.Jogo;

public class CampeonatoControllerTest {
	
	private Campeonato c;
	private CampeonatoController cc;
	
	@Before
	public void setUp() throws Exception {
		this.c = new Campeonato();
		this.cc = new CampeonatoController();
	}
	
	@Test
	public void testAdicionar() {
		c.setAno(2013);
		c.setNome("Paraibano");
		
		boolean ok = false;
		
		for(Campeonato cl : cc.listar()){
			if (cl.getNome().equals("Paraibano"))
				ok = true;
		}
		
		if (ok){
			assertEquals("Erro", cc.adicionar(c));
		}else{
			assertEquals("Sucesso", cc.adicionar(c));
		}
	}

	@Test
	public void testListar() {
		for(Campeonato camp : cc.listar()){
			System.out.println(camp.getCampeonato() + " " + camp.getNome() + " " + camp.getAno());
			System.out.println("    JOGOS");
			for(Jogo j : camp.getJogos()){
				System.out.println("       " + j.getCampeonato().getNome() + "-" + j.getCampeonato().getAno() + ": " + j.getClubeCasa().getNome() + " x " + j.getClubeVisitante().getNome());
			}
		}
	}
}
