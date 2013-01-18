package bolao.controller;

import java.util.List;

import bolao.dao.CampeonatoDao;
import bolao.model.Campeonato;
import bolao.util.DAOFactory;
import bolao.util.ValidatorMessage;

public class CampeonatoController {
	private CampeonatoDao campeonatoDao;
	
	public CampeonatoController(){
		this.campeonatoDao = DAOFactory.criarCampeonatoDAO();
	}

	public String adicionar(Campeonato campeonato) {
		String msg = ValidatorMessage.getMessage(campeonato);
		
		if(msg == null){
			try{
				this.campeonatoDao.adicionar(campeonato);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro";
			}
		}
		return msg;
	}

	public String atualizar(Campeonato campeonato) {
		String msg = ValidatorMessage.getMessage(campeonato);
		
		if(msg == null){
			try{
				this.campeonatoDao.atualizar(campeonato);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro";
			}
		}
		return msg;
	}

	public String excluir(Campeonato campeonato) {
		String msg = null;
		try{			
			if(campeonato.getCampeonato() != null){
				this.campeonatoDao.excluir(campeonato);
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

	public List<Campeonato> listar() {
		return this.campeonatoDao.listar(); 
	}

	public Campeonato carregar(Integer codigo) {
		return this.campeonatoDao.carregar(codigo);
	}
}