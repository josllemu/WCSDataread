package dk.lemu.tools.dao;

import dk.lemu.tools.entity.ContainerSize;
import org.hibernate.query.Query;

import java.util.Collection;

public class ContainerSizeDAO extends GenericDAOImplementation<ContainerSize, Long> {

  @Override
  public void saveOrUpdate(ContainerSize entity) throws Exception {
    ContainerSize candidate = findByUnit(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<ContainerSize> entities) throws Exception {
    int count = 0;
    for (ContainerSize l : entities) {

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

  public ContainerSize findByUnit(Integer unit) {
    Query query = currentSession().getNamedQuery("ContainerSize.findByUnit");
    query.setParameter("unit", unit);
    return (ContainerSize) query.uniqueResult();
  }
}
