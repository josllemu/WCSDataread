package dk.lemu.tools.dao;

import dk.lemu.tools.entity.CustomerLabelHist;
import org.hibernate.query.Query;

import java.util.Collection;

public class CustomerLabelHistDAO extends GenericDAOImplementation<CustomerLabelHist, Long> {

  @Override
  public void saveOrUpdate(CustomerLabelHist entity) throws Exception {
    currentSession().save(entity);
  }


  @Override
  public void multiSaveOrUpdate(Collection<CustomerLabelHist> entities) throws Exception {
    int count = 0;
    for (CustomerLabelHist l : entities) {

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

  public CustomerLabelHist findByShippingCode(String shippingCode) {
    Query query = currentSession().getNamedQuery("CustomerLabel.findByShippingCode");
    query.setParameter("shipping_Code", shippingCode);
    return (CustomerLabelHist) query.uniqueResult();
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from CustomerLabelHist where dbDate < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
