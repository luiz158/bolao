package bolao.util;

import bolao.dao.GenericDao;
import bolao.dao.GenericDaoHibernate;
import bolao.dao.UsuarioDao;
import bolao.dao.UsuarioDaoHibernate;
import bolao.model.Usuario;

public class DAOFactory {
	public static UsuarioDaoHibernate criarUsuarioDAO(){
		UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
}