package dk.lemu.tools.dao;

import dk.lemu.tools.entity.StockSpread;
import org.hibernate.query.Query;

import java.util.Collection;

public class StockSpreadDAO extends GenericDAOImplementation<StockSpread, Long> {

  @Override
  public void saveOrUpdate(StockSpread entity) throws Exception {
    //cannot update a post make a new one
    currentSession().save(entity);

  }

  @Override
  public void multiSaveOrUpdate(Collection<StockSpread> entities) throws Exception {
    int count = 0;
    for (StockSpread l : entities) {

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

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from StockSpread where dbDate < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }


}
