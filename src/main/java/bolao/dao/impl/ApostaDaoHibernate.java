package bolao.dao.impl;

import bolao.dao.ApostaDao;
import bolao.model.Aposta;

public class ApostaDaoHibernate extends GenericDaoHibernate<Aposta, Integer> implements ApostaDao{
	public ApostaDaoHibernate(){
		super(Aposta.class);
	}
}
