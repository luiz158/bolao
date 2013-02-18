package bolao.controller;

import java.util.List;

import bolao.dao.ApostaDao;
import bolao.model.Aposta;
import bolao.util.DAOFactory;
import bolao.util.ValidatorMessage;

public class ApostaController {
	private ApostaDao apostaDao;
	
	public ApostaController(){
		this.apostaDao = DAOFactory.criarApostaDAO();
	}

	public String adicionar(Aposta aposta) {
		String msg = ValidatorMessage.getMessage(aposta);
		
		if(msg == null){
			try{
				this.apostaDao.adicionar(aposta);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro";
			}
		}
		return msg;
	}

	public String atualizar(Aposta aposta) {
		String msg = ValidatorMessage.getMessage(aposta);
		
		if(msg == null){
			try{
				this.apostaDao.atualizar(aposta);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro";
			}
		}
		return msg;
	}

	public String excluir(Aposta aposta) {
		String msg = null;
		try{			
			if(aposta.getAposta() != null){
				this.apostaDao.excluir(aposta);
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

	public List<Aposta> listar() {
		return this.apostaDao.listar(); 
	}

	public Aposta carregar(Integer codigo) {
		return this.apostaDao.carregar(codigo);
	}
}