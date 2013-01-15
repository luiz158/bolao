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

	public void adicionar(Bolao bolao) {
		this.bolaoDao.adicionar(bolao);
	}

	public void atualizar(Bolao bolao) {
		this.bolaoDao.atualizar(bolao);
	}

	public void excluir(Bolao bolao) {
		this.bolaoDao.excluir(bolao);		
	}

	public List<Bolao> listar() {
		return this.bolaoDao.listar();
	}

	public Bolao carregar(Integer codigo) {
		return this.bolaoDao.carregar(codigo);
	}
}