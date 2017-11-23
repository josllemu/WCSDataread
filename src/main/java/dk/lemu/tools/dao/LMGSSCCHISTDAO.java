package dk.lemu.tools.dao;

import dk.lemu.tools.entity.LMGSSCCHist;
import org.hibernate.query.Query;

import java.util.Collection;

public class LMGSSCCHISTDAO extends GenericDAOImplementation<LMGSSCCHist, Long> {

  @Override
  public void saveOrUpdate(LMGSSCCHist entity) throws Exception {
    currentSession().save(entity);
  }

  @Override
  public void multiSaveOrUpdate(Collection<LMGSSCCHist> entities) throws Exception {
    int count = 0;
    for (LMGSSCCHist l : entities) {

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

  public LMGSSCCHist findBySSCC(String sscc) {
    Query query = currentSession().getNamedQuery("LMGSSCCHist.findBySSCC");
    query.setParameter("sscc", sscc);
    return (LMGSSCCHist) query.uniqueResult();
  }

    public int deleteOldPost() throws Exception {
      Query query = currentSession().createQuery("delete from LMGSSCCHist where dbDato < :ninetyDays");
      query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
      int numpost = query.executeUpdate();
      commit();
      return numpost;
  }
}
