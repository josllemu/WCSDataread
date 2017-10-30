package dk.lemu.tools.dao;

import dk.lemu.tools.entity.EmptyContainer;
import org.hibernate.query.Query;

import java.util.Collection;

public class EmptyContainerDAO extends GenericDAOImplementation <EmptyContainer, Long>{

  @Override
  public void saveOrUpdate(EmptyContainer entity) throws Exception {
    EmptyContainer candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<EmptyContainer> entities) throws Exception {
    int count=0;
    for (EmptyContainer l : entities) {

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

  public EmptyContainer findByItem(String unit) {
    Query query = currentSession().getNamedQuery("EmptyContainer.findByUnit");
    query.setParameter("unit", unit);
    return (EmptyContainer) query.uniqueResult();
  }
}
