package bolao.controller;

import java.util.List;

import bolao.dao.UsuarioDao;
import bolao.model.Usuario;
import bolao.util.DAOException;
import bolao.util.DAOFactory;

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
	
	public void adcionar(Usuario usuario){
		usuario.getPermissao().add("ROLE_USUARIO");
		//this.usuarioDAO.adicionar(usuario);
	}
	
	public void atualizar(Usuario usuario){
		try {
			this.usuarioDAO.atualizar(usuario);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluir(Usuario usuario){
		try {
			this.usuarioDAO.excluir(usuario);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}
}