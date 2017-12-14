package dk.lemu.tools.dao;

import dk.lemu.tools.entity.ReplenQty;
import org.hibernate.query.Query;

import java.util.Collection;

public class ReplenQtyDAO extends GenericDAOImplementation<ReplenQty, Long> {

  @Override
  public void saveOrUpdate(ReplenQty entity) throws Exception {
    ReplenQty candidate = findByAllocRef(entity.getAllocRef());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<ReplenQty> entities) throws Exception {
    int count = 0;
    for (ReplenQty l : entities) {

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

  public ReplenQty findByAllocRef(Integer allocRef) {
    Query query = currentSession().getNamedQuery("ReplenQty.findByAllocRef");
    query.setParameter("allocRef", allocRef);
    return (ReplenQty) query.uniqueResult();
  }


}
