package dk.lemu.tools.dao;

import dk.lemu.tools.entity.ContainerType;
import org.hibernate.query.Query;

import java.util.Collection;

public class ContainerTypeDAO extends GenericDAOImplementation<ContainerType, Long> {

  @Override
  public void saveOrUpdate(ContainerType entity) throws Exception {
    ContainerType candidate = findByType(entity.getContainerTypeCode());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<ContainerType> entities) throws Exception {
    int count = 0;
    for (ContainerType l : entities) {
      saveOrUpdate(l);
      if (++count % 20 == 0) {
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
      }
    }
    commit();
  }

  public ContainerType findByType(String typeId) {
    Query query = currentSession().getNamedQuery("ContainerType.findByType");
    query.setParameter("typeId", typeId);
    return (ContainerType) query.uniqueResult();
  }
}
