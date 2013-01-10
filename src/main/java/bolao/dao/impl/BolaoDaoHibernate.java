package bolao.dao.impl;

import bolao.dao.BolaoDao;
import bolao.model.Bolao;

public class BolaoDaoHibernate extends GenericDaoHibernate<Bolao, Integer> implements BolaoDao{
	public BolaoDaoHibernate(){
		super(Bolao.class);
	}
}
