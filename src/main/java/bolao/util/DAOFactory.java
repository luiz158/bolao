package bolao.util;

import bolao.dao.BolaoDao;
import bolao.dao.ClubeDao;
import bolao.dao.JogoDao;
import bolao.dao.UsuarioDao;
import bolao.dao.impl.BolaoDaoHibernate;
import bolao.dao.impl.ClubeDaoHibernate;
import bolao.dao.impl.JogoDaoHibernate;
import bolao.dao.impl.UsuarioDaoHibernate;

public class DAOFactory {
	
	public static UsuarioDao criarUsuarioDAO(){
		UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
		return usuarioDAO;
	}
	
	public static BolaoDao criarBolaoDAO(){
		BolaoDaoHibernate bolaoDAO = new BolaoDaoHibernate();
		return bolaoDAO;
	}
	
	public static ClubeDao criarClubeDAO(){
		ClubeDaoHibernate clubeDAO = new ClubeDaoHibernate();
		return clubeDAO;
	}

	public static JogoDao criarJogoDAO() {
		JogoDaoHibernate jogoDAO = new JogoDaoHibernate();
		return jogoDAO;
	}
}