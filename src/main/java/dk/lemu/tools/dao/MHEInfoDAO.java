package dk.lemu.tools.dao;

import dk.lemu.tools.entity.MHEInfo;
import org.hibernate.query.Query;

import java.util.Collection;

public class MHEInfoDAO extends GenericDAOImplementation <MHEInfo, Long>{

  @Override
  public void saveOrUpdate(MHEInfo entity) throws Exception {
    MHEInfo candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<MHEInfo> entities) throws Exception {
    int count=0;
    for (MHEInfo l : entities) {

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

  public MHEInfo findByItem(String unit) {
    Query query = currentSession().getNamedQuery("MHEInfo.findByUnit");
    query.setParameter("unit", unit);
    return (MHEInfo) query.uniqueResult();
  }
}
