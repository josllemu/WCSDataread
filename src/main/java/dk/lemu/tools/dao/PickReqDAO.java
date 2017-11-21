package dk.lemu.tools.dao;

import dk.lemu.tools.entity.PickReq;
import org.hibernate.query.Query;

import java.util.Collection;

public class PickReqDAO extends GenericDAOImplementation<PickReq, Long> {

  @Override
  public void saveOrUpdate(PickReq entity) throws Exception {
    PickReq candidate = findByAllocRef(entity.getAllocRef());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<PickReq> entities) throws Exception {
    int count = 0;
    for (PickReq l : entities) {

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

  public PickReq findByAllocRef(Integer allocRef) {
    Query query = currentSession().getNamedQuery("PickReq.findByAllocRef");
    query.setParameter("allocRef", allocRef);
    return (PickReq) query.uniqueResult();
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from PickReq where dbDate < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
