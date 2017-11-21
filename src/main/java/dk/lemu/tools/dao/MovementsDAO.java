package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Movements;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.Date;

public class MovementsDAO extends GenericDAOImplementation<Movements, Long> {

  @Override
  public void saveOrUpdate(Movements entity) throws Exception {
    Movements candidate = findByContainerAndCreateTime(entity.getContainerId(), entity.getCreateTime());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Movements> entities) throws Exception {
    int count = 0;
    for (Movements l : entities) {

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

  public Movements findByContainerAndCreateTime(String origSource, Date createTime) {
    Query query = currentSession().getNamedQuery("Movements.findByContainerAndCreateTime");
    query.setParameter("containerId", origSource);
    query.setParameter("createTime", createTime);
    return (Movements) query.uniqueResult();
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from Movements where createTime < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
