package bolao.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public abstract class AbstractFacadeDao<T, ID extends Serializable> implements GenericDao<T, Serializable>{

   private Session session;
   private Class<T> entityClass;
   
   public AbstractFacadeDao(Class<T> entityClass) {
       this.entityClass = entityClass;
   }
   
   @SuppressWarnings("unchecked")
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
   
   @SuppressWarnings("unchecked")
   public void salvar(T entity) {
    	this.getSession().saveOrUpdate(entity);
    }

   @SuppressWarnings("unchecked")
   public void excluir(T entity) {
        this.getSession().delete(entity);
    }
   
   @SuppressWarnings("unchecked")
   public List<T> pesquisarTodos() {
	   return this.getSession().createCriteria(this.getEntityClass()).list();
	   }
}
