package bolao.dao.impl;

import bolao.dao.JogoDao;
import bolao.model.Jogo;

public class JogoDaoHibernate extends GenericDaoHibernate<Jogo, Integer> implements JogoDao{
	public JogoDaoHibernate(){
		super(Jogo.class);
	}
}
