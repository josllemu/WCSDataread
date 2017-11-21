package dk.lemu.tools.dao;

import dk.lemu.tools.entity.LMGSSCC;
import org.hibernate.query.Query;

import java.util.Collection;

public class LMGSSCCDAO extends GenericDAOImplementation<LMGSSCC, Long> {

  @Override
  public void saveOrUpdate(LMGSSCC entity) throws Exception {
    LMGSSCC candidate = findBySSCCANDContainer(entity.getSscc(), entity.getContainer(), entity.getSequenceNumber());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<LMGSSCC> entities) throws Exception {
    int count = 0;
    for (LMGSSCC l : entities) {

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

  public LMGSSCC findBySSCCANDContainer(String sscc, String container, Integer seqNo) {
    Query query = currentSession().getNamedQuery("LMGSSCC.findBySSCCANDContainer");
    query.setParameter("sscc", sscc);
    query.setParameter("container", container);
    query.setParameter("sequenceNumber", seqNo);
    return (LMGSSCC) query.uniqueResult();
  }

  public int deleteAll() throws Exception {
    Query query = currentSession().createQuery("delete from LMGSSCC");
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
