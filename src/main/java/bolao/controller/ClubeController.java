package bolao.controller;

import java.util.List;

import bolao.dao.ClubeDao;
import bolao.model.Clube;
import bolao.util.DAOFactory;

public class ClubeController {
private ClubeDao clubeDao;
	
	public ClubeController(){
		this.clubeDao = DAOFactory.criarClubeDAO();
	}

	public void adicionar(Clube clube) {
		this.clubeDao.adicionar(clube);
	}

	public void atualizar(Clube clube) {
		this.clubeDao.atualizar(clube);
	}

	public void excluir(Clube clube) {
		this.clubeDao.excluir(clube);		
	}

	public List<Clube> listar() {
		return this.clubeDao.listar();
	}

	public Clube carregar(Integer codigo) {
		return this.clubeDao.carregar(codigo);
	}
}
