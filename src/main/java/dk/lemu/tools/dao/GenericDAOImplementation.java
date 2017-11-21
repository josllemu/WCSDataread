package dk.lemu.tools.dao;

import dk.lemu.tools.database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public abstract class GenericDAOImplementation<T, Id extends Serializable> implements GenericDAOInterface<T, Id> {

  public static Date ninetyDaysAgo = new Date(System.currentTimeMillis()-7776000000L);

  private static Transaction transaction;
  private Class<? extends T> daoType;
  private Session session;


  public GenericDAOImplementation() {
    Type t = getClass().getGenericSuperclass();
    ParameterizedType pt = (ParameterizedType) t;
    daoType = (Class) pt.getActualTypeArguments()[0];
    session = HibernateUtil.currentSession();
    //if startup first time session is empty for initialize
    if (session != null) {
      transaction = session.getTransaction();
    }

  }

  protected Session currentSession() {
    if (session != null && session.isOpen()) {

      if (!session.getTransaction().isActive()) {
        session.beginTransaction();
        transaction = session.getTransaction();
      }
    } else {

      if (!session.getTransaction().isActive()) {
        session.beginTransaction();
        transaction = session.getTransaction();
      }
    }
    return session;
  }

  public void commit() throws Exception {
    try {// Commit the transaction
      transaction.commit();
    } catch (Exception ex) {
      // If there are any exceptions, roll back the changes
      if (transaction != null) {
        transaction.rollback();
      }
      // Print the Exception
      ex.printStackTrace();
    }
  }

  @Override
  public void add(T entity) throws Exception {

    currentSession().save(entity);
    commit();
  }


  @Override
  public void update(T entity) throws Exception {

    currentSession().update(entity);
    commit();
  }

  @Override
  public void remove(T entity) throws Exception {

    currentSession().delete(entity);
    commit();
  }

  @Override
  public T find(Id key) {
    return (T) currentSession().get(daoType, key);
  }

  @Override
  public List<T> getAll() {
    return currentSession().createQuery("FROM " + daoType.getSimpleName() + " ").list();
  }


  public void close() {
    currentSession().close();
    HibernateUtil.closeSession();
  }
}