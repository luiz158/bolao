package bolao.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {

    public void salvar(T entity);

    public void excluir(T entity);

    public List<T> pesquisarTodos();
}