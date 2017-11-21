package dk.lemu.tools.dao;

import dk.lemu.tools.entity.SupplyHist;
import org.hibernate.query.Query;

import java.util.Collection;

public class SupplyHistDAO extends GenericDAOImplementation<SupplyHist, Long> {

  @Override
  public void saveOrUpdate(SupplyHist entity) throws Exception {

      currentSession().save(entity);

  }

  @Override
  public void multiSaveOrUpdate(Collection<SupplyHist> entities) throws Exception {
    int count = 0;
    for (SupplyHist l : entities) {

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

  public SupplyHist findByOrder(String orderId) {
    Query query = currentSession().getNamedQuery("SupplyHist.findByOrder");
    query.setParameter("orderId", orderId);
    return (SupplyHist) query.uniqueResult();
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from SupplyHist where dbDate < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
