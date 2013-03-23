package bolao.controller;

import java.util.List;

import bolao.dao.UsuarioDao;
import bolao.model.Usuario;
import bolao.util.DAOFactory;
import bolao.util.ValidatorMessage;

public class UsuarioController {
	
	private UsuarioDao usuarioDAO;
	
	public UsuarioController(){
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public Usuario carregar(Integer codigo){
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario buscarPorLogin(String login){
		return this.usuarioDAO.buscarPorLogin(login);
	}
		
	public String adicionar(Usuario usuario) {
		usuario.getPermissao().add("ROLE_USUARIO");
		String msg = ValidatorMessage.getMessage(usuario);
		
		if(msg == null){
			try{
				this.usuarioDAO.adicionar(usuario);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro: " + e.getMessage();
			}
		}
		return msg;
	}

	public String atualizar(Usuario usuario) {
		String msg = ValidatorMessage.getMessage(usuario);
		
		if(msg == null){
			try{
				this.usuarioDAO.atualizar(usuario);
				msg = "Sucesso";
			}catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				msg = "Erro: " + e.getMessage();
			}
		}
		return msg;
	}

	public String excluir(Usuario usuario) {
		String msg = null;
		try{			
			if(usuario.getUsuario() != null){
				this.usuarioDAO.excluir(usuario);
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
	
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}
}