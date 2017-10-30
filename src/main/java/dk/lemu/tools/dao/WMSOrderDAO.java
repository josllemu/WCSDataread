package dk.lemu.tools.dao;

import dk.lemu.tools.entity.WMSOrder;
import org.hibernate.query.Query;

import java.util.Collection;

public class WMSOrderDAO extends GenericDAOImplementation <WMSOrder, Long>{

  @Override
  public void saveOrUpdate(WMSOrder entity) throws Exception {
    WMSOrder candidate = findByOrderId(entity.getOrderId());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<WMSOrder> entities) throws Exception {
    int count=0;
    for (WMSOrder l : entities) {

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

  public WMSOrder findByOrderId(Integer orderId) {
    Query query = currentSession().getNamedQuery("WMSOrder.findByOrderId");
    query.setParameter("order_Id", orderId);
    return (WMSOrder) query.uniqueResult();
  }

  public WMSOrder findByOrderNumber(String orderId) {
    Query query = currentSession().getNamedQuery("WMSOrder.findByOrderNumber");
    query.setParameter("order_Id", orderId);
    return (WMSOrder) query.uniqueResult();
  }
}
