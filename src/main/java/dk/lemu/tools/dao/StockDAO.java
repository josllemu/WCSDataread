package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Container;
import dk.lemu.tools.entity.Item;
import dk.lemu.tools.entity.Stock;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.Date;

public class StockDAO extends GenericDAOImplementation <Stock, Long>{

  @Override
  public void saveOrUpdate(Stock entity) throws Exception {
    Stock candidate = findByItemCodeAndContainer(entity.getItem(), entity.getContainer(), entity.getTimeReceived());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Stock> entities) throws Exception {
    int count=0;
    for (Stock l : entities) {
      saveOrUpdate(l);
      if ( ++count % 50 == 0 ) {
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
      }
    }
    commit();
  }

  public Stock findByItemCodeAndContainer(Item itemCode, Container containerId, Date timeReceived) {
    Query query = currentSession().getNamedQuery("Stock.findByItemCodeAndContainerAndTimeReceived");
    query.setParameter("itemCode", itemCode);
    query.setParameter("containerId", containerId);
    query.setParameter("receiveDate", timeReceived);
    return (Stock) query.uniqueResult();
  }
}
