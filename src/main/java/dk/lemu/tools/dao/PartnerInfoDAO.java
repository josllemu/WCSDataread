package dk.lemu.tools.dao;

import dk.lemu.tools.entity.PartnerInfo;
import org.hibernate.query.Query;

import java.util.Collection;

public class PartnerInfoDAO extends GenericDAOImplementation <PartnerInfo, Long>{

  @Override
  public void saveOrUpdate(PartnerInfo entity) throws Exception {
    PartnerInfo candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<PartnerInfo> entities) throws Exception {
    int count=0;
    for (PartnerInfo l : entities) {

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

  public PartnerInfo findByItem(String unit) {
    Query query = currentSession().getNamedQuery("PartnerInfo.findByUnit");
    query.setParameter("unit", unit);
    return (PartnerInfo) query.uniqueResult();
  }
}
