package bolao.util;

import bolao.dao.BolaoDao;
import bolao.dao.CampeonatoDao;
import bolao.dao.ClubeDao;
import bolao.dao.JogoDao;
import bolao.dao.UsuarioDao;
import bolao.dao.impl.BolaoDaoHibernate;
import bolao.dao.impl.CampeonatoDaoHibernate;
import bolao.dao.impl.ClubeDaoHibernate;
import bolao.dao.impl.JogoDaoHibernate;
import bolao.dao.impl.UsuarioDaoHibernate;

public class DAOFactory {
	
	public static UsuarioDao criarUsuarioDAO(){
		return new UsuarioDaoHibernate();
	}
	
	public static BolaoDao criarBolaoDAO(){
		return new BolaoDaoHibernate();
	}
	
	public static ClubeDao criarClubeDAO(){
		return new ClubeDaoHibernate();
	}

	public static JogoDao criarJogoDAO() {
		return new JogoDaoHibernate();
	}

	public static CampeonatoDao criarCampeonatoDAO() {
		return new CampeonatoDaoHibernate();
	}
}