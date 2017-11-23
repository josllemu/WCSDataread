package dk.lemu.tools.dao;

import dk.lemu.tools.entity.StockHist;

import java.util.Collection;

public class StockHistDAO extends GenericDAOImplementation<StockHist, Long> {

  @Override
  public void saveOrUpdate(StockHist entity) throws Exception {
    //Hist Entity, no update
    currentSession().save(entity);

  }

  @Override
  public void multiSaveOrUpdate(Collection<StockHist> entities) throws Exception {
    int count = 0;
    for (StockHist l : entities) {
      saveOrUpdate(l);
      if (++count % 50 == 0) {
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
      }
    }
    commit();
  }

}
