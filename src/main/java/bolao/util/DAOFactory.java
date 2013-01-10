package bolao.util;

import bolao.dao.impl.BolaoDaoHibernate;
import bolao.dao.impl.UsuarioDaoHibernate;

public class DAOFactory {
	
	public static UsuarioDaoHibernate criarUsuarioDAO(){
		UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	
	public static BolaoDaoHibernate criarBolaoDAO(){
		BolaoDaoHibernate bolaoDAO = new BolaoDaoHibernate();
		bolaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return bolaoDAO;
	}
}