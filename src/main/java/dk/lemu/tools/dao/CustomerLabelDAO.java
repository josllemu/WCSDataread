package dk.lemu.tools.dao;

import dk.lemu.tools.entity.CustomerLabel;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.Date;

public class CustomerLabelDAO extends GenericDAOImplementation<CustomerLabel, Long> {

  @Override
  public void saveOrUpdate(CustomerLabel entity) throws Exception {
    CustomerLabel candidate = findByShippingCode(entity.getSeq(), entity.getShippingCode(), entity.getOrderNumber(), entity.getPackDate());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }


  @Override
  public void multiSaveOrUpdate(Collection<CustomerLabel> entities) throws Exception {
    int count = 0;
    for (CustomerLabel l : entities) {

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

  public CustomerLabel findByShippingCode(Integer seq, String shippingCode, String orderNumber, Date packDate) {
    Query query = currentSession().getNamedQuery("CustomerLabel.findByShippingCode");
    query.setParameter("shipping_Code", shippingCode);
    query.setParameter("orderNumber", orderNumber);
    query.setParameter("packDate", packDate);
    query.setParameter("seq", seq);
    return (CustomerLabel) query.uniqueResult();
  }

  public int deleteAll() throws Exception {
    Query query = currentSession().createQuery("delete from CustomerLabel");
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
