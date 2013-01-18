package bolao.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bolao.util.HibernateUtil;

import bolao.dao.GenericDao;
import bolao.util.DAOException;

public abstract class GenericDaoHibernate<T, ID extends Serializable> implements GenericDao<T, ID>{

   private Session session;
   private Transaction transacao;
   private Class<T> entityClass;
   
   public GenericDaoHibernate(Class<T> entityClass){
       this.entityClass = entityClass;
   }
   
   public Class<T> getEntityClass() {
       return this.entityClass;
   }
   
   public void setSession(Session session) {
       this.session = session;
   }
   
   protected Session getSession() {
       if (this.session == null)
           throw new IllegalStateException("Sessão não foi definida no DAO");
       return session;
   }
   
   public void adicionar(T entity) throws DAOException {
	   try{
		   this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		   this.transacao = this.session.beginTransaction();
		   this.session.save(entity);
		   this.transacao.commit();
	   }catch (HibernateException e) {
		   if(this.transacao.isActive())
			   this.transacao.rollback();
		   throw new DAOException("Não foi possível inserir: " + entity.getClass().getName() + " ERRO: " + e.getMessage());
	   }finally{
		   try{
			   if(this.session.isOpen()){
				   this.session.close();
			   }
		   }catch (Throwable e) {
			   System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
		   }
	   }
   }

   public void excluir(T entity) throws DAOException {
	   try{
		   this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		   this.transacao = this.session.beginTransaction();
    	   this.session.delete(entity);
    	   this.transacao.commit();
      }catch(Exception e){
    	  if(this.transacao.isActive())
			   this.transacao.rollback();
		  throw new DAOException("Não foi possível excluir: " + entity.getClass().getName() + " ERRO: " + e.getMessage());
	   }finally{
		   try{
			   if(this.session.isOpen()){
				   this.session.close();
			   }
		   }catch (Throwable e) {
			   System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
		   }
	   }	   
    }

   public void atualizar(T entity) throws DAOException {
	   try{
		   this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		   this.transacao = this.session.beginTransaction();
		   this.session.update(entity);
		   this.transacao.commit();
	   } catch(HibernateException e){
		   if(this.transacao.isActive())
			   this.transacao.rollback();
		   throw new DAOException("Não foi possível alterar: " + entity.getClass().getName() + " ERRO: " + e.getMessage());
	   }finally{
		   try{
			   if(this.session.isOpen()){
				   this.session.close();
			   }
		   }catch (Throwable e) {
			   System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
		   }
	   }
	}
   
   @SuppressWarnings("unchecked")
   public List<T> listar(){
	   List<T> entities = null;
	   
	   try{
		   this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		   this.transacao = this.session.beginTransaction();
		   entities = this.getSession().createCriteria(this.getEntityClass()).list();
		   this.transacao.commit();
	   } catch(HibernateException e){
		   if(this.transacao.isActive())
			   this.transacao.rollback();
	   }finally{
		   try{
			   if(this.session.isOpen()){
				   this.session.close();
			   }
		   }catch (Throwable e) {
			   System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
		   }
	   }
	   return entities;
   }

   @SuppressWarnings("unchecked")
   public T carregar(ID codigo){
	   T t = null;
	   
	   try{
		   this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		   this.transacao = this.session.beginTransaction();
		   t = (T) this.session.get(this.entityClass, codigo);
		   this.transacao.commit();
	   } catch(HibernateException e){
		   if(this.transacao.isActive())
			   this.transacao.rollback();
	   }finally{
		   try{
			   if(this.session.isOpen()){
				   this.session.close();
			   }
		   }catch (Throwable e) {
			   System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
		   }
	   }
	   return t;
   }
}