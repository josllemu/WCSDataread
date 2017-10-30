package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Container;
import org.hibernate.query.Query;

import java.util.Collection;

public class ContainerDAO extends GenericDAOImplementation<Container, Long> {

  @Override
  public void saveOrUpdate(Container entity) throws Exception {
    Container candidate = findByContainer(entity.getContainer());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Container> entities) throws Exception {
    int count = 0;
    for (Container l : entities) {
      try {
        saveOrUpdate(l);
      } catch (Exception e) {
        throw new Exception("Could not save or update: " + l + " with message: " + e.getMessage());
      }
      if (++count % 20 == 0) {
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
        commit();
      }
    }
    if (count % 20 != 0)
    commit();
  }

  public Container findByContainer(String containerId) {
    Query query = currentSession().getNamedQuery("Container.findByContainer");
    query.setParameter("containerId", containerId);
    return (Container) query.uniqueResult();
  }
}
