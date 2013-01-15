package bolao.util;

import bolao.dao.BolaoDao;
import bolao.dao.ClubeDao;
import bolao.dao.UsuarioDao;
import bolao.dao.impl.BolaoDaoHibernate;
import bolao.dao.impl.ClubeDaoHibernate;
import bolao.dao.impl.UsuarioDaoHibernate;

public class DAOFactory {
	
	public static UsuarioDao criarUsuarioDAO(){
		UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	
	public static BolaoDao criarBolaoDAO(){
		BolaoDaoHibernate bolaoDAO = new BolaoDaoHibernate();
		bolaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return bolaoDAO;
	}
	
	public static ClubeDao criarClubeDAO(){
		ClubeDaoHibernate clubeDAO = new ClubeDaoHibernate();
		clubeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return clubeDAO;
	}
}