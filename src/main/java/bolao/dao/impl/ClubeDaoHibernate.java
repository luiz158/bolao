package bolao.dao.impl;

import bolao.dao.ClubeDao;
import bolao.model.Clube;

public class ClubeDaoHibernate extends GenericDaoHibernate<Clube, Integer> implements ClubeDao{
	public ClubeDaoHibernate(){
		super(Clube.class);
	}
}
