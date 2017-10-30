package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Alarms;
import org.hibernate.query.Query;

import java.util.Collection;

public class AlarmsDAO extends GenericDAOImplementation <Alarms, Long>{

  @Override
  public void saveOrUpdate(Alarms entity) throws Exception {
    Alarms candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Alarms> entities) throws Exception {
    int count=0;
    for (Alarms l : entities) {

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

  public Alarms findByItem(String unit) {
    Query query = currentSession().getNamedQuery("Alarms.findByUnit");
    query.setParameter("unit", unit);
    return (Alarms) query.uniqueResult();
  }
}
