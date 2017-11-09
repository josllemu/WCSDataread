package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Log;
import org.hibernate.query.Query;

import java.util.Collection;

public class LogDAO extends GenericDAOImplementation<Log, Long> {

  @Override
  public void saveOrUpdate(Log entity) throws Exception {
    Log candidate = findByPath(entity.getPath());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Log> entities) throws Exception {
    int count = 0;
    for (Log l : entities) {

      saveOrUpdate(l);
      if (++count % 50 == 0) {
        //System.out.println("chunk: " +(count/50) + " of " + (entities.size()/50) + " saved - numEntries: " + entities.size());
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
      }
    }
    commit();
  }

  public Log findByPath(String path) {
    Query query = currentSession().getNamedQuery("Log.findByPath");
    query.setParameter("path", path);
    return (Log) query.uniqueResult();
  }

}
