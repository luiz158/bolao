package bolao.dao;

import java.io.Serializable;
import java.util.List;

import bolao.util.DAOException;

public interface GenericDao<T, ID extends Serializable> {
    public void adicionar(T entity) throws DAOException;
    public void atualizar(T entity) throws DAOException;
    public void excluir(T entity) throws DAOException;
    public List<T> listar();
    public T carregar(ID codigo);
}
