package bolao.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
    public void salvar(T entity);
    public void atualizar(T entity);
    public void excluir(T entity);
    public List<T> listar();
    public T carregar(ID codigo);
}
