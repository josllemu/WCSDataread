package dk.lemu.tools.dao;

import dk.lemu.tools.entity.WMSOrder;
import org.hibernate.query.Query;

import java.util.Collection;

public class WMSOrderDAO extends GenericDAOImplementation<WMSOrder, Long> {

  @Override
  public void saveOrUpdate(WMSOrder entity) throws Exception {
    WMSOrder candidate = findByOrderIdOrderNumberAndDelNotId(entity.getOrderId(), entity.getOrderNumber(), entity.getDelNoteId());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<WMSOrder> entities) throws Exception {
    int count = 0;
    for (WMSOrder l : entities) {

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

  public WMSOrder findByOrderId(String orderId) {
    Query query = currentSession().getNamedQuery("WMSOrder.findByOrderId");
    query.setParameter("order_Id", orderId);
    return (WMSOrder) query.uniqueResult();
  }

  public WMSOrder findByOrderIdOrderNumberAndDelNotId(String orderId, String orderNumber, String delNoteId) {
    Query query = currentSession().getNamedQuery("WMSOrder.findByOrderIdOrderNumberAndDelNotId");
    query.setParameter("order_Id", orderId);
    query.setParameter("order_Number", orderNumber);
    query.setParameter("delNoteId", delNoteId);
    return (WMSOrder) query.uniqueResult();
  }

  public WMSOrder findByOrderNumber(String orderNumber) {
    Query query = currentSession().getNamedQuery("WMSOrder.findByOrderNumber");
    query.setParameter("order_Number", orderNumber);
    return (WMSOrder) query.uniqueResult();
  }

  public WMSOrder findByDelNoteId(String delNoteId) {
    Query query = currentSession().getNamedQuery("WMSOrder.findByDelNoteId");
    query.setParameter("delNoteId", delNoteId);
    return (WMSOrder) query.uniqueResult();
  }
}
