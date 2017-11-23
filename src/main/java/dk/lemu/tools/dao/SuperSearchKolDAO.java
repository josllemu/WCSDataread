package dk.lemu.tools.dao;

import dk.lemu.tools.entity.SuperSearchKol;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.List;

public class SuperSearchKolDAO extends GenericDAOImplementation<SuperSearchKol, Long> {

  @Override
  public void saveOrUpdate(SuperSearchKol entity) throws Exception {
    SuperSearchKol candidate = findByIds(entity);
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<SuperSearchKol> entities) throws Exception {
    int count = 0;
    for (SuperSearchKol l : entities) {

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

  public SuperSearchKol findByIds(SuperSearchKol searchKol) {
    Query query = currentSession().getNamedQuery("SuperSearchKol.findByIds");
    query.setParameter("wmsOrderHist", searchKol.getWmsOrderHist());
    query.setParameter("supplyHist", searchKol.getSupplyHist());
    query.setParameter("partnerAddress", searchKol.getPartnerAddress());
    query.setParameter("operatorEventHist", searchKol.getOperatorEventHist());
    query.setParameter("item", searchKol.getItem());
    query.setParameter("itemConf", searchKol.getItemConf());
    query.setParameter("customerLabelHist", searchKol.getCustomerLabelHist());
    query.setParameter("lmgssccHist", searchKol.getLmgssccHist());
    query.setParameter("stockHist", searchKol.getStockHist());
    query.setParameter("itemExt", searchKol.getItemExt());

    return (SuperSearchKol) query.uniqueResult();
  }

  public SuperSearchKol makePost() {
    Query query = currentSession().getNamedNativeQuery("SuperSearchKol.makePost");
    query.setMaxResults(1);
    List list = query.list();

    System.out.println(list.toArray());

    return null;
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from SuperSearchKol where dbDate < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }


}
