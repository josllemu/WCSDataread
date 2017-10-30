package dk.lemu.tools.dao;

import dk.lemu.tools.entity.PickCategory;
import org.hibernate.query.Query;

import java.util.Collection;

public class PickCategoryDAO extends GenericDAOImplementation <PickCategory, Long>{

  @Override
  public void saveOrUpdate(PickCategory entity) throws Exception {
    PickCategory candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<PickCategory> entities) throws Exception {
    int count=0;
    for (PickCategory l : entities) {

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

  public PickCategory findByItem(String unit) {
    Query query = currentSession().getNamedQuery("PickCategory.findByUnit");
    query.setParameter("unit", unit);
    return (PickCategory) query.uniqueResult();
  }
}
