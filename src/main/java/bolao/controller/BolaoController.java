package bolao.controller;

import java.util.List;

import bolao.dao.BolaoDao;
import bolao.model.Bolao;
import bolao.model.Usuario;
import bolao.util.DAOFactory;
import bolao.util.RNException;
import bolao.util.ValidatorMessage;

public class BolaoController{
	
	private BolaoDao bolaoDao;
	
	public BolaoController(){
		this.bolaoDao = DAOFactory.criarBolaoDAO();
	}

	public String adicionar(Bolao bolao) {
		String msg = ValidatorMessage.getMessage(bolao);
		
		if(msg == null){
			try{
				this.bolaoDao.adicionar(bolao);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro: " + e.getMessage();
			}
		}
		return msg;
	}

	public String atualizar(Bolao bolao) {
		String msg = ValidatorMessage.getMessage(bolao);
		
		if(msg == null){
			try{
				this.bolaoDao.atualizar(bolao);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro: " + e.getMessage();
			}
		}
		return msg;
	}

	public String excluir(Bolao bolao) {
		String msg = null;
		try{			
			if(bolao.getBolao() != null){
				this.bolaoDao.excluir(bolao);
				msg = "Sucesso";
			}else{
				msg = "Erro";
			}
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
			msg = "Erro: " + e.getMessage();
		}
		return msg;
	}

	public List<Bolao> listar() {
		return this.bolaoDao.listar();
	}

	public Bolao carregar(Integer codigo) {
		return this.bolaoDao.carregar(codigo);
	}
	
	public String adicionarApostador(Bolao bolao, Usuario usuario) throws RNException{
		UsuarioController usuarioController = new UsuarioController();
		
		if(usuarioController.carregar(usuario.getUsuario()) == null){
			throw new RNException("Usuario não existente");
		}
		bolao.getApostadores().add(usuario);
		return "Sucesso";
	}
}