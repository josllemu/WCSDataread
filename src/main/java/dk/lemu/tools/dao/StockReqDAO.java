package dk.lemu.tools.dao;

import dk.lemu.tools.entity.StockReq;
import org.hibernate.query.Query;

import java.util.Collection;

public class StockReqDAO extends GenericDAOImplementation<StockReq, Long> {

  @Override
  public void saveOrUpdate(StockReq entity) throws Exception {
    StockReq candidate = findByAllocRef(entity.getAllocRef());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<StockReq> entities) throws Exception {
    int count = 0;
    for (StockReq l : entities) {

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

  public StockReq findByAllocRef(Integer allocRef) {
    Query query = currentSession().getNamedQuery("StockReq.findByAllocRef");
    query.setParameter("allocRef", allocRef);
    return (StockReq) query.uniqueResult();
  }
}
