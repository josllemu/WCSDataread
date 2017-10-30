package dk.lemu.tools.dao;

import dk.lemu.tools.entity.OperatorEvent;
import org.hibernate.query.Query;

import java.util.Collection;

public class OperatorEventDAO extends GenericDAOImplementation <OperatorEvent, Long>{

  @Override
  public void saveOrUpdate(OperatorEvent entity) throws Exception {
    OperatorEvent candidate = findByHisID(entity.getHisID());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<OperatorEvent> entities) throws Exception {
    int count=0;
    for (OperatorEvent l : entities) {

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

  public OperatorEvent findByHisID(Long hisID) {
    Query query = currentSession().getNamedQuery("OperatorEvent.findByHisID");
    query.setParameter("his_ID", hisID);
    return (OperatorEvent) query.uniqueResult();
  }
}
