package bolao.util;

import bolao.dao.impl.UsuarioDaoHibernate;

public class DAOFactory {
	public static UsuarioDaoHibernate criarUsuarioDAO(){
		UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
}