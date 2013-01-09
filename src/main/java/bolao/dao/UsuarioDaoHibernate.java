package bolao.dao;

import java.util.List;

import org.hibernate.Query;

import bolao.model.Usuario;

public class UsuarioDaoHibernate extends GenericDaoHibernate<Usuario, Long> implements UsuarioDao{

	public UsuarioDaoHibernate() {
		super(Usuario.class);
	}

	@Override
	public void atualizar(Usuario usuario) {
		if(usuario.getPermissao() == null || usuario.getPermissao().size() == 0){
			Usuario usuarioPermissao = this.carregar(usuario.getCodigo());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			super.getSession().evict(usuarioPermissao);
		}
		super.getSession().update(usuario);
	}

	@Override
	public Usuario carregar(Integer codigo) {
		return (Usuario) super.getSession().get(Usuario.class, codigo);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = super.getSession().createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}
}
