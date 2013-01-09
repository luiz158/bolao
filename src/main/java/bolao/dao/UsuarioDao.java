package bolao.dao;

import bolao.model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer>{
	public Usuario buscarPorLogin(String login);
}
