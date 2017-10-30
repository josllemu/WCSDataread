package dk.lemu.tools.dao;

import dk.lemu.tools.entity.MHEEvent;
import org.hibernate.query.Query;

import java.util.Collection;

public class MHEEventDAO extends GenericDAOImplementation <MHEEvent, Long>{

  @Override
  public void saveOrUpdate(MHEEvent entity) throws Exception {
    MHEEvent candidate = findByMHEId(entity.getMheId());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<MHEEvent> entities) throws Exception {
    int count=0;
    for (MHEEvent l : entities) {

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

  public MHEEvent findByMHEId(Integer mheId) {
    Query query = currentSession().getNamedQuery("MHEEvent.findByMHEId");
    query.setParameter("mheId", mheId);
    return (MHEEvent) query.uniqueResult();
  }
}
