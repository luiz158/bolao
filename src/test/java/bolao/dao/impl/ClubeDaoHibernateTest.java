package bolao.dao.impl;

import static org.junit.Assert.*;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import bolao.dao.ClubeDao;
import bolao.model.Clube;
import bolao.util.DAOException;
import bolao.util.DAOFactory;

public class ClubeDaoHibernateTest {
	
	private Clube c;
	private ClubeDao cd;
	
	@Before
	public void setUp() throws Exception {
		c = new Clube();
		cd = DAOFactory.criarClubeDAO();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void AdcionarNull(){
		try {
			cd.adicionar(this.c);
			fail("Deveria ter lançado um exceção!");
		} catch (DAOException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void AdcionaRepitido(){
		this.c.setNome("Flamengo");
		
		try {
			this.cd.adicionar(c);
			fail("Deveria ter lançado uma exceção");
		} catch (DAOException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void listaTest(){
		for(Clube c : cd.listar()){
			System.out.println(c.getClube() + " " + c.getNome());
		}
	}
	
	@Test
	public void carregarTest(){
		Clube cl = cd.carregar(25);
		
		if(cl == null){
			assertNull(cl);
		}else{
			assertEquals("Campinense", cl.getNome());
		}
	}
	
	@Test
	public void excluirTest(){
		this.c = cd.carregar(25);
		
		try {
			cd.excluir(c);
		} catch (Exception e) {
			assertNull(c);
		}
	}
}