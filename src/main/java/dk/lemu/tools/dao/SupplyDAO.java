package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Supply;
import org.hibernate.query.Query;

import java.util.Collection;

public class SupplyDAO extends GenericDAOImplementation<Supply, Long> {

  @Override
  public void saveOrUpdate(Supply entity) throws Exception {
    Supply candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Supply> entities) throws Exception {
    int count = 0;
    for (Supply l : entities) {

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

  public Supply findByItem(String unit) {
    Query query = currentSession().getNamedQuery("Supply.findByUnit");
    query.setParameter("unit", unit);
    return (Supply) query.uniqueResult();
  }
}
