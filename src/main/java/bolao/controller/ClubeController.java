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
				return "Erro";
			}
		}
		return msg;
	}

	public void atualizar(Clube clube) {
		try{
			this.clubeDao.atualizar(clube);
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
		}
	}

	public String excluir(Clube clube) {
		try{			
			if(clube.getClube() != null){
				this.clubeDao.excluir(clube);
			}else{
				return "Erro";
			}
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
			return "Erro";
		}
		return "Sucesso";
	}

	public List<Clube> listar() {
		List<Clube> clubes = null;
		try{
			clubes = this.clubeDao.listar();
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
		}
		return clubes;
	}

	public Clube carregar(Integer codigo) {
		Clube clube = null;
		try{
			clube = this.clubeDao.carregar(codigo);
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
		}
		return clube;
	}
}