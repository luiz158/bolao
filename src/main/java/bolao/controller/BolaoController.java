package bolao.controller;

import java.util.List;

import bolao.dao.BolaoDao;
import bolao.model.Bolao;
import bolao.util.DAOFactory;

public class BolaoController{
	
	private BolaoDao bolaoDao;
	
	public BolaoController(){
		this.bolaoDao = DAOFactory.criarBolaoDAO();
	}

	public void adicionar(Bolao entity) {
		this.bolaoDao.adicionar(entity);
	}

	public void atualizar(Bolao entity) {
		this.bolaoDao.atualizar(entity);
	}

	public void excluir(Bolao entity) {
		this.bolaoDao.excluir(entity);		
	}

	public List<Bolao> listar() {
		return this.bolaoDao.listar();
	}

	public Bolao carregar(Integer codigo) {
		return this.bolaoDao.carregar(codigo);
	}
}