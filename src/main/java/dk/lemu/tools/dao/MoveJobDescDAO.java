package dk.lemu.tools.dao;

import dk.lemu.tools.entity.MoveJobDesc;
import org.hibernate.query.Query;

import java.util.Collection;

public class MoveJobDescDAO extends GenericDAOImplementation <MoveJobDesc, Long>{

  @Override
  public void saveOrUpdate(MoveJobDesc entity) throws Exception {
    MoveJobDesc candidate = findByItem(entity.getUnit());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<MoveJobDesc> entities) throws Exception {
    int count=0;
    for (MoveJobDesc l : entities) {

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

  public MoveJobDesc findByItem(String unit) {
    Query query = currentSession().getNamedQuery("MoveJobDesc.findByUnit");
    query.setParameter("unit", unit);
    return (MoveJobDesc) query.uniqueResult();
  }
}
