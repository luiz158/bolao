package bolao.controller;

import java.util.List;

import bolao.dao.UsuarioDao;
import bolao.model.Usuario;
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
		this.usuarioDAO.atualizar(usuario);
	}
	
	public void excluir(Usuario usuario){
		this.usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}
}