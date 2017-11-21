package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Stock;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.Date;

public class StockDAO extends GenericDAOImplementation<Stock, Long> {

  @Override
  public void saveOrUpdate(Stock entity) throws Exception {
    Stock candidate = findByUniqueConstraints(entity.getItem(), entity.getContainer(), entity.getTimeReceived(),
        entity.getAllocRef(), entity.getTimeCreated(), entity.getReceiptLine(), entity.getBatchRef(), entity.getSequence());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Stock> entities) throws Exception {
    int count = 0;
    for (Stock l : entities) {
      saveOrUpdate(l);
      if (++count % 50 == 0) {
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
      }
    }
    commit();
  }

  public Stock findByUniqueConstraints(String itemCode, String containerId, Date timeReceived,
                                       Integer allocRef, Date timeCreated, String receiptLine, String batchRef, Integer sequence) {
    Query query = currentSession().getNamedQuery("Stock.findByUniqueConstraints");
    query.setParameter("itemCode", itemCode);
    query.setParameter("containerId", containerId);
    query.setParameter("receiveDate", timeReceived);
    query.setParameter("allocRef", allocRef);
    query.setParameter("timeCreated", timeCreated);
    query.setParameter("receiptLine", receiptLine);
    query.setParameter("batchRef", batchRef);
    query.setParameter("sequence", sequence);

    return (Stock) query.uniqueResult();
  }

  public int deleteAll() throws Exception {
    Query query = currentSession().createQuery("delete from Stock");
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
