package dk.lemu.tools.dao;

import dk.lemu.tools.entity.PickCount;
import org.hibernate.query.Query;

import java.util.Collection;

public class PickCountDAO extends GenericDAOImplementation <PickCount, Long>{

  @Override
  public void saveOrUpdate(PickCount entity) throws Exception {
    PickCount candidate = findByItem(entity.getItem());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<PickCount> entities) throws Exception {
    int count=0;
    for (PickCount l : entities) {

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

  public PickCount findByItem(String item) {
    Query query = currentSession().getNamedQuery("PickCount.findbyItem");
    query.setParameter("item_id", item);
    return (PickCount) query.uniqueResult();
  }
}
