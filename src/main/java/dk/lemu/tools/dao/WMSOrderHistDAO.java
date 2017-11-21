package dk.lemu.tools.dao;

import dk.lemu.tools.entity.WMSOrderHist;
import org.hibernate.query.Query;

import java.util.Collection;

public class WMSOrderHistDAO extends GenericDAOImplementation<WMSOrderHist, Long> {

  @Override
  public void saveOrUpdate(WMSOrderHist entity) throws Exception {

      currentSession().save(entity);

  }

  @Override
  public void multiSaveOrUpdate(Collection<WMSOrderHist> entities) throws Exception {
    int count = 0;
    for (WMSOrderHist l : entities) {

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

  public WMSOrderHist findByOrderId(String orderId) {
    Query query = currentSession().getNamedQuery("WMSOrderHist.findByOrderId");
    query.setParameter("order_Id", orderId);
    return (WMSOrderHist) query.uniqueResult();
  }

  public WMSOrderHist findByOrderIdOrderNumberAndDelNotId(String orderId, String orderNumber, String delNoteId) {
    Query query = currentSession().getNamedQuery("WMSOrderHist.findByOrderIdOrderNumberAndDelNotId");
    query.setParameter("order_Id", orderId);
    query.setParameter("order_Number", orderNumber);
    query.setParameter("delNoteId", delNoteId);
    return (WMSOrderHist) query.uniqueResult();
  }

  public WMSOrderHist findByOrderNumber(String orderNumber) {
    Query query = currentSession().getNamedQuery("WMSOrderHist.findByOrderNumber");
    query.setParameter("order_Number", orderNumber);
    return (WMSOrderHist) query.uniqueResult();
  }

  public WMSOrderHist findByDelNoteId(String delNoteId) {
    Query query = currentSession().getNamedQuery("WMSOrderHist.findByDelNoteId");
    query.setParameter("delNoteId", delNoteId);
    return (WMSOrderHist) query.uniqueResult();
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from WMSOrderHist where dbDate < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
