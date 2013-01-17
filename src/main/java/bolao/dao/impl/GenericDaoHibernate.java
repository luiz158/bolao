package bolao.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bolao.dao.GenericDao;
import bolao.util.DAOException;

public abstract class GenericDaoHibernate<T, ID extends Serializable> implements GenericDao<T, ID>{

   private Session session;
   private Transaction transacao;
   private Class<T> entityClass;
   
   public GenericDaoHibernate(Class<T> entityClass){
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
   
   public void adicionar(T entity) throws DAOException {
	   try{
		   this.transacao = this.getSession().beginTransaction();
		   this.getSession().save(entity);
		   this.transacao.commit();
	   }catch (HibernateException e) {
		   throw new DAOException("Não foi possível inserir: " + entity.getClass().getName() + " ERRO: " + e.getMessage());
	   }finally{
		   try{
			   if(this.getSession().isOpen()){
				   this.getSession().close();
			   }
		   }catch (Throwable e) {
			   System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
		   }
	   }
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

   @SuppressWarnings("unchecked")
   public T carregar(ID codigo) {
	   return (T) this.getSession().get(this.entityClass, codigo);
   }
}
