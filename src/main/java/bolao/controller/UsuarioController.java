package bolao.controller;

import java.util.List;

import bolao.dao.UsuarioDAO;
import bolao.model.Usuario;
import bolao.util.DAOFactory;

public class UsuarioController {
private UsuarioDAO usuarioDAO;
	
	public UsuarioController(){
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public Usuario carregar(Integer codigo){
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario buscarPorLogin(String login){
		return this.usuarioDAO.buscarPorLogin(login);
	}
	
	public void salvar(Usuario usuario){
		Integer codigo = usuario.getCodigo();
		if(codigo == null || codigo == 0){
			usuario.getPermissao().add("ROLE_USUARIO");
			this.usuarioDAO.salvar(usuario);
		}else {
			this.usuarioDAO.atualizar(usuario);
		}
	}
	
	public void excluir(Usuario usuario){
		this.usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}
}