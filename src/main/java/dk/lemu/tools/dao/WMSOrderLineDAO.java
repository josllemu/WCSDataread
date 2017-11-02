package dk.lemu.tools.dao;

import dk.lemu.tools.entity.WMSOrderLine;
import org.hibernate.query.Query;

import java.util.Collection;

public class WMSOrderLineDAO extends GenericDAOImplementation<WMSOrderLine, Long> {

  @Override
  public void saveOrUpdate(WMSOrderLine entity) throws Exception {
    WMSOrderLine candidate = findByOrderAndLine(entity.getOrderId(), entity.getLine());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<WMSOrderLine> entities) throws Exception {
    int count = 0;
    for (WMSOrderLine l : entities) {

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

  public WMSOrderLine findByOrderAndLine(Integer orderId, Integer line) {
    Query query = currentSession().getNamedQuery("WMSOrderLine.findByOrderAndLine");
    query.setParameter("orderId", orderId);
    query.setParameter("line", line);
    return (WMSOrderLine) query.uniqueResult();
  }
}
