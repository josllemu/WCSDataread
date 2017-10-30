package dk.lemu.tools.dao;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface GenericDAOInterface<T, Id extends Serializable> {
  void add(T entity) throws Exception;

  void saveOrUpdate(T entity) throws Exception;

  void update(T entity) throws Exception;

  void remove(T entity) throws Exception;

  void multiSaveOrUpdate(Collection<T> entities) throws Exception;

  T find(Id key);

  List<T> getAll();

  void close();

  void commit() throws Exception;
}