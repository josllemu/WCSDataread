package dk.lemu.tools.dao;

import dk.lemu.tools.entity.MHEError;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.Date;

public class MHEErrorDAO extends GenericDAOImplementation <MHEError, Long>{

  @Override
  public void saveOrUpdate(MHEError entity) throws Exception {
    MHEError candidate = findByDescription(entity.getErrorTime(), entity.getErrorCode(), entity.getType());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<MHEError> entities) throws Exception {
    int count=0;
    for (MHEError l : entities) {

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

  public MHEError findByDescription(Date errorTime, Integer errorCode, Integer type) {
    Query query = currentSession().getNamedQuery("MHEError.findByErrorTimeErrorCodeAndType");
    query.setParameter("errorTime", errorTime);
    query.setParameter("errorCode", errorCode);
    query.setParameter("type", type);
    return (MHEError) query.uniqueResult();
  }
}
