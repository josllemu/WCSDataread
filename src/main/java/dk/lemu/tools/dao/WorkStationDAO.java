package dk.lemu.tools.dao;

import dk.lemu.tools.entity.WorkStation;
import org.hibernate.query.Query;

import java.util.Collection;

public class WorkStationDAO extends GenericDAOImplementation<WorkStation, Long> {

  @Override
  public void saveOrUpdate(WorkStation entity) throws Exception {
    WorkStation candidate = findByHostName(entity.getHostName());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<WorkStation> entities) throws Exception {
    int count = 0;
    for (WorkStation l : entities) {

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

  public WorkStation findByHostName(String hostName) {
    Query query = currentSession().getNamedQuery("WorkStation.findByHostName");
    query.setParameter("hostName", hostName);
    return (WorkStation) query.uniqueResult();
  }
}
