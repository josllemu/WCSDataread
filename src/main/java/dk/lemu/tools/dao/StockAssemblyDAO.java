package dk.lemu.tools.dao;

import dk.lemu.tools.entity.StockAssembly;
import org.hibernate.query.Query;

import java.util.Collection;

public class StockAssemblyDAO extends GenericDAOImplementation <StockAssembly, Long>{

  @Override
  public void saveOrUpdate(StockAssembly entity) throws Exception {
    StockAssembly candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<StockAssembly> entities) throws Exception {
    int count=0;
    for (StockAssembly l : entities) {

      saveOrUpdate(l);
      if ( ++count % 50 == 0 ) {
        //System.out.println("chunk: " +(count/50) + " of " + (entities.size()/50) + " saved - numEntries: " + entities.size());
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
      }
    }
    commit();
  }

  public StockAssembly findByItem(String unit) {
    Query query = currentSession().getNamedQuery("StockAssembly.findByUnit");
    query.setParameter("unit", unit);
    return (StockAssembly) query.uniqueResult();
  }
}
