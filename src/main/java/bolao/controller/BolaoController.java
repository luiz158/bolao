package bolao.controller;

import java.util.List;

import bolao.dao.BolaoDao;
import bolao.model.Bolao;
import bolao.util.DAOException;
import bolao.util.DAOFactory;

public class BolaoController{
	
	private BolaoDao bolaoDao;
	
	public BolaoController(){
		this.bolaoDao = DAOFactory.criarBolaoDAO();
	}

	public void adicionar(Bolao bolao) {
		//this.bolaoDao.adicionar(bolao);
	}

	public void atualizar(Bolao bolao) {
		try {
			this.bolaoDao.atualizar(bolao);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(Bolao bolao) {
		try {
			this.bolaoDao.excluir(bolao);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public List<Bolao> listar() {
		return this.bolaoDao.listar();
	}

	public Bolao carregar(Integer codigo) {
		return this.bolaoDao.carregar(codigo);
	}
}