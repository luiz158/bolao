package bolao.dao;

import bolao.model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Long>{
	public Usuario carregar(Integer codigo);
	public Usuario buscarPorLogin(String login);
}
