package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Movements;
import org.hibernate.query.Query;

import java.util.Collection;

public class MovementsDAO extends GenericDAOImplementation <Movements, Long>{

  @Override
  public void saveOrUpdate(Movements entity) throws Exception {
    Movements candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Movements> entities) throws Exception {
    int count=0;
    for (Movements l : entities) {

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

  public Movements findByItem(String unit) {
    Query query = currentSession().getNamedQuery("Movements.findByUnit");
    query.setParameter("unit", unit);
    return (Movements) query.uniqueResult();
  }
}