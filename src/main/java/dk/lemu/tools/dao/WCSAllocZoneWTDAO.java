package dk.lemu.tools.dao;

import dk.lemu.tools.entity.WCSAllocZoneWT;
import org.hibernate.query.Query;

import java.util.Collection;

public class WCSAllocZoneWTDAO extends GenericDAOImplementation<WCSAllocZoneWT, Long> {

  @Override
  public void saveOrUpdate(WCSAllocZoneWT entity) throws Exception {
    WCSAllocZoneWT candidate = findByZonePriorityAndWeight(entity.getZone(), entity.getPriority(), entity.getWeight());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }


  @Override
  public void multiSaveOrUpdate(Collection<WCSAllocZoneWT> entities) throws Exception {
    int count = 0;
    for (WCSAllocZoneWT l : entities) {

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

  private WCSAllocZoneWT findByZonePriorityAndWeight(Integer zone, Integer priority, Double weight) {
    Query query = currentSession().getNamedQuery("WCSAllocZoneWT.findByZonePriorityAndWeight");
    query.setParameter("zone", zone);
    query.setParameter("priority", priority);
    query.setParameter("weight", weight);
    return (WCSAllocZoneWT) query.uniqueResult();
  }
}
