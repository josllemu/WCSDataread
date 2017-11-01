package dk.lemu.tools.dao;

import dk.lemu.tools.entity.PartnerAddress;
import org.hibernate.query.Query;

import java.util.Collection;

public class PartnerAddressDAO extends GenericDAOImplementation<PartnerAddress, Long> {

  @Override
  public void saveOrUpdate(PartnerAddress entity) throws Exception {
    PartnerAddress candidate = findByOrderAndOrderSub(entity.getOrderID(), entity.getOrderSUB());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<PartnerAddress> entities) throws Exception {
    int count = 0;
    for (PartnerAddress l : entities) {

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

  public PartnerAddress findByOrderAndOrderSub(Integer orderID, String orderSUB) {
    Query query = currentSession().getNamedQuery("PartnerAddress.findByUnit");
    query.setParameter("orderID", orderID);
    query.setParameter("orderSUB", orderSUB);
    return (PartnerAddress) query.uniqueResult();
  }
}
