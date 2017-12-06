package dk.lemu.tools.dao;

import dk.lemu.tools.entity.SuperSearchKol;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

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

  public Integer makePost() throws Exception {
    Long start = System.currentTimeMillis();
    Query query = currentSession().getNamedNativeQuery("SuperSearchKol.makePost");
    Long endq = System.currentTimeMillis();

    Logger.getLogger("WCS").info("Running search: " + (endq - start));


    List<Object[]> list = query.list();

    Long endR = System.currentTimeMillis();
    Logger.getLogger("WCS").info("Running list: " + (endR - endq));

    Logger.getLogger("WCS").info("Running all: " + (endR - start));


    Collection<SuperSearchKol> posts = new ArrayList<>();
    int counter = 0;
    for (Object[] row : list) {

      SuperSearchKol kol = new SuperSearchKol(new Long(row[0].toString()),
          new Long(row[1].toString()),
          new Long(row[2].toString()),
          new Long(row[3].toString()),
          new Long(row[4].toString()),
          row[5] != null ? new Long(row[5].toString()) : null,
          row[6] != null ? new Long(row[6].toString()) : null,
          new Long(row[7].toString()));

      if(!posts.contains(kol)) {
        posts.add(kol);
      }

      if (posts.size() == 250) {
        counter ++;
        Logger.getLogger("WCS").info("saving records: " + (250*(counter-1)) + " to " + (250*counter) + " of (estimate) " + list.size());

        multiSaveOrUpdate(posts);

        posts = new ArrayList<>();
      }
    }
    if (!posts.isEmpty()) {
      multiSaveOrUpdate(posts);
    }

    Long endS = System.currentTimeMillis();
    Logger.getLogger("WCS").info("Running list: " + (endS - endR));

    Logger.getLogger("WCS").info("Running all: " + (endS - start));

    return ((counter*250)+posts.size());
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from SuperSearchKol where dbDate < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }


}
