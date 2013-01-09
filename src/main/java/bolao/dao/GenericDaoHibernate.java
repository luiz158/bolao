package bolao.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public abstract class GenericDaoHibernate<T, ID extends Serializable> implements GenericDao<T, ID>{

   private Session session;
   private Class<T> entityClass;
   
   public GenericDaoHibernate(Class<T> entityClass) {
       this.entityClass = entityClass;
   }
   
   public void setSession(Session session) {
       this.session = session;
   }
   
   protected Session getSession() {
       if (this.session == null)
           throw new IllegalStateException("Sessão não foi definida no DAO");
       return session;
   }
   
   public Class<T> getEntityClass() {
       return this.entityClass;
   }
   
   public void salvar(T entity) {
    	this.getSession().save(entity);
    }

   public void excluir(T entity) {
        this.getSession().delete(entity);
    }
   
   @SuppressWarnings("unchecked")
   public List<T> listar() {
	   return this.getSession().createCriteria(this.getEntityClass()).list();
   }

   public void atualizar(T entity) {
	   this.getSession().update(entity);
	}
}
