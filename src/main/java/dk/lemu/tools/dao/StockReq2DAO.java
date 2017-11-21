package dk.lemu.tools.dao;

import dk.lemu.tools.entity.StockReq2;
import org.hibernate.query.Query;

import java.util.Collection;

public class StockReq2DAO extends GenericDAOImplementation<StockReq2, Long> {

  @Override
  public void saveOrUpdate(StockReq2 entity) throws Exception {
    StockReq2 candidate = findByAllocRef(entity.getAllocRef());
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

  public StockReq2 findByAllocRef(Integer allocRef) {
    Query query = currentSession().getNamedQuery("StockReq2.findByAllocRef");
    query.setParameter("allocRef", allocRef);
    return (StockReq2) query.uniqueResult();
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from StockReq2 where dbDate < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
