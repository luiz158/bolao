package bolao.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void test() {
		Session sessao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Conectou!");
		} finally {
			sessao.close();
		}
	}

}
