package dk.lemu.tools.dao;

import dk.lemu.tools.entity.PMSData;
import org.hibernate.query.Query;

import java.util.Collection;

public class PMSDataDAO extends GenericDAOImplementation<PMSData, Long> {

  @Override
  public void saveOrUpdate(PMSData entity) throws Exception {
    PMSData candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<PMSData> entities) throws Exception {
    int count = 0;
    for (PMSData l : entities) {

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

  public PMSData findByItem(String unit) {
    Query query = currentSession().getNamedQuery("PMSData.findByUnit");
    query.setParameter("unit", unit);
    return (PMSData) query.uniqueResult();
  }
}
