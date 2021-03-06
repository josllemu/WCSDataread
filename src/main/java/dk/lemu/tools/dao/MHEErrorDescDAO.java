package dk.lemu.tools.dao;

import dk.lemu.tools.entity.MHEErrorDesc;
import org.hibernate.query.Query;

import java.util.Collection;

public class MHEErrorDescDAO extends GenericDAOImplementation<MHEErrorDesc, Long> {

  @Override
  public void saveOrUpdate(MHEErrorDesc entity) throws Exception {
    MHEErrorDesc candidate = findByDescription(entity.getDescription());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<MHEErrorDesc> entities) throws Exception {
    int count = 0;
    for (MHEErrorDesc l : entities) {

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

  public MHEErrorDesc findByDescription(String description) {
    Query query = currentSession().getNamedQuery("MHEErrorDesc.findByDescription");
    query.setParameter("description", description);
    return (MHEErrorDesc) query.uniqueResult();
  }
}
