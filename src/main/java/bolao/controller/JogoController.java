package bolao.controller;

import java.util.List;

import bolao.dao.JogoDao;
import bolao.model.Jogo;
import bolao.util.DAOFactory;
import bolao.util.ValidatorMessage;

public class JogoController {
	private JogoDao jogoDao;
	
	public JogoController(){
		this.jogoDao = DAOFactory.criarJogoDAO();
	}

	public String adicionar(Jogo jogo) {
		String msg = ValidatorMessage.getMessage(jogo);
		
		if(msg == null){
			try{
				this.jogoDao.adicionar(jogo);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro";
			}
		}
		return msg;
	}

	public String atualizar(Jogo jogo) {
		String msg = ValidatorMessage.getMessage(jogo);
		
		if(msg == null){
			try{
				this.jogoDao.atualizar(jogo);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro";
			}
		}
		return msg;
	}

	public String excluir(Jogo jogo) {
		String msg = null;
		try{			
			if(jogo.getJogo() != null){
				this.jogoDao.excluir(jogo);
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

	public List<Jogo> listar() {
		return this.jogoDao.listar(); 
	}

	public Jogo carregar(Integer codigo) {
		return this.jogoDao.carregar(codigo);
	}
}