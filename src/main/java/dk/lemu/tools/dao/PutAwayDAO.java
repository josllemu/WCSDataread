package dk.lemu.tools.dao;

import dk.lemu.tools.entity.PutAway;
import org.hibernate.query.Query;

import java.util.Collection;

public class PutAwayDAO extends GenericDAOImplementation <PutAway, Long>{

  @Override
  public void saveOrUpdate(PutAway entity) throws Exception {
    PutAway candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<PutAway> entities) throws Exception {
    int count=0;
    for (PutAway l : entities) {

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

  public PutAway findByItem(String unit) {
    Query query = currentSession().getNamedQuery("PutAway.findByUnit");
    query.setParameter("unit", unit);
    return (PutAway) query.uniqueResult();
  }
}
