package bolao.controller;

import java.util.List;

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
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro";
			}
		}
		return msg;
	}

	public String atualizar(Clube clube) {
		String msg = ValidatorMessage.getMessage(clube);
		
		if(msg == null){
			try{
				this.clubeDao.atualizar(clube);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro";
			}
		}
		return msg;
	}

	public String excluir(Clube clube) {
		String msg = null;
		try{			
			if(clube.getClube() != null){
				this.clubeDao.excluir(clube);
				msg = "Sucesso";
			}else{
				msg = "Erro";
			}
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
			msg = "Erro";
		}
		return msg;
	}

	public List<Clube> listar() {
		return this.clubeDao.listar(); 
	}

	public Clube carregar(Integer codigo) {
		return this.clubeDao.carregar(codigo);
	}
}