package dk.lemu.tools.dao;

import dk.lemu.tools.entity.StockReq2;
import org.hibernate.query.Query;

import java.util.Collection;

public class StockReq2DAO extends GenericDAOImplementation<StockReq2, Long> {

  @Override
  public void saveOrUpdate(StockReq2 entity) throws Exception {
    StockReq2 candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<StockReq2> entities) throws Exception {
    int count = 0;
    for (StockReq2 l : entities) {

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

  public StockReq2 findByItem(String unit) {
    Query query = currentSession().getNamedQuery("StockReq2.findByUnit");
    query.setParameter("unit", unit);
    return (StockReq2) query.uniqueResult();
  }
}
