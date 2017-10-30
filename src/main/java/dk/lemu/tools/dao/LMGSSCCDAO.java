package dk.lemu.tools.dao;

import dk.lemu.tools.entity.LMGSSCC;
import org.hibernate.query.Query;

import java.util.Collection;

public class LMGSSCCDAO extends GenericDAOImplementation <LMGSSCC, Long>{

  @Override
  public void saveOrUpdate(LMGSSCC entity) throws Exception {
    LMGSSCC candidate = findByItem(entity.getId());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<LMGSSCC> entities) throws Exception {
    int count=0;
    for (LMGSSCC l : entities) {

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

  public LMGSSCC findByItem(Long id) {
    Query query = currentSession().getNamedQuery("LMGSSCC.findById");
    query.setParameter("id", id);
    return (LMGSSCC) query.uniqueResult();
  }
}
