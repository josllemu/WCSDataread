package dk.lemu.tools.dao;

import dk.lemu.tools.entity.CustomerLabel;
import org.hibernate.query.Query;

import java.util.Collection;

public class CustomerLabelDAO extends GenericDAOImplementation <CustomerLabel, Long>{

  @Override
  public void saveOrUpdate(CustomerLabel entity) throws Exception {
    CustomerLabel candidate = findByItem(entity.getShippingCode());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }



  @Override
  public void multiSaveOrUpdate(Collection<CustomerLabel> entities) throws Exception {
    int count=0;
    for (CustomerLabel l : entities) {

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

  public CustomerLabel findByItem(String unit) {
    Query query = currentSession().getNamedQuery("CustomerLabel.findByShippingCode");
    query.setParameter("shipping_Code", unit);
    return (CustomerLabel) query.uniqueResult();
  }
}
