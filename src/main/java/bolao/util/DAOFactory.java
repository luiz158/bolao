package bolao.util;

import bolao.dao.UsuarioDAO;
import bolao.dao.UsuarioDAOImpl;

public class DAOFactory {
	public static UsuarioDAO criarUsuarioDAO(){
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
}