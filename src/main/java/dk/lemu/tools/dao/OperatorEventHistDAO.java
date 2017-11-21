package dk.lemu.tools.dao;

import dk.lemu.tools.entity.OperatorEventHist;
import org.hibernate.query.Query;

import java.util.Collection;

public class OperatorEventHistDAO extends GenericDAOImplementation<OperatorEventHist, Long> {

  @Override
  public void saveOrUpdate(OperatorEventHist entity) throws Exception {

      currentSession().save(entity);
  }

  @Override
  public void multiSaveOrUpdate(Collection<OperatorEventHist> entities) throws Exception {
    int count = 0;
    for (OperatorEventHist l : entities) {

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

  public OperatorEventHist findByHisID(Long hisID) {
    Query query = currentSession().getNamedQuery("OperatorEventHist.findByHisID");
    query.setParameter("his_ID", hisID);
    return (OperatorEventHist) query.uniqueResult();
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from OperatorEventHist where dbDato < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
