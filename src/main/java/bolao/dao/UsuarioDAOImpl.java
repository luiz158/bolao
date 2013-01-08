package bolao.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bolao.model.Usuario;
import bolao.util.HibernateUtil;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Usuario usuario) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();

			sessao.save(usuario);
			
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
			}
		}
	}

	@Override
	public void atualizar(Usuario usuario) {
		if(usuario.getPermissao() == null || usuario.getPermissao().size() == 0){
			Usuario usuarioPermissao = this.carregar(usuario.getCodigo());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			this.session.evict(usuarioPermissao);
		}
		this.session.update(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
	}

	@Override
	public Usuario carregar(Integer codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}

	@Override
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}
}
