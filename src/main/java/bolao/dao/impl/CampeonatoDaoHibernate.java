package bolao.dao.impl;

import bolao.dao.CampeonatoDao;
import bolao.model.Campeonato;

public class CampeonatoDaoHibernate extends GenericDaoHibernate<Campeonato, Integer> implements CampeonatoDao{
	public CampeonatoDaoHibernate(){
		super(Campeonato.class);
	}
}
