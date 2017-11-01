package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Zone;
import org.hibernate.query.Query;

import java.util.Collection;

public class ZonesDAO extends GenericDAOImplementation<Zone, Long> {

  @Override
  public void saveOrUpdate(Zone entity) throws Exception {
    Zone candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Zone> entities) throws Exception {
    int count = 0;
    for (Zone l : entities) {

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

  public Zone findByItem(String orderId) {
    Query query = currentSession().getNamedQuery("Zone.findByOrderId");
    query.setParameter("order_Id", orderId);
    return (Zone) query.uniqueResult();
  }
}
