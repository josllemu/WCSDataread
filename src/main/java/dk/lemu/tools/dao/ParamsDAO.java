package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Params;
import org.hibernate.query.Query;

import java.util.Collection;

public class ParamsDAO extends GenericDAOImplementation<Params, Long> {

  @Override
  public void saveOrUpdate(Params entity) throws Exception {
    Params candidate = findByParms(entity.getParms());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Params> entities) throws Exception {
    int count = 0;
    for (Params l : entities) {

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

  public Params findByParms(String parms) {
    Query query = currentSession().getNamedQuery("Params.findByParms");
    query.setParameter("parms", parms);
    return (Params) query.uniqueResult();
  }
}
