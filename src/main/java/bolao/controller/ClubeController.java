package bolao.controller;

import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import bolao.dao.ClubeDao;
import bolao.model.Clube;
import bolao.util.DAOFactory;
import bolao.util.ValidatorMessage;

public class ClubeController {
	private ClubeDao clubeDao;
	
	public ClubeController(){
		this.clubeDao = DAOFactory.criarClubeDAO();
	}

	public String adicionar(Clube clube) {
		String msg = ValidatorMessage.getMessage(clube);
		
		if(msg == null){
			try{
				this.clubeDao.adicionar(clube);
				return "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
			}
		}
		return msg;
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
