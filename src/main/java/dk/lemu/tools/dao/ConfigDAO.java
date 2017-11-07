package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Config;
import org.hibernate.query.Query;

import java.util.Collection;

public class ConfigDAO extends GenericDAOImplementation<Config, Long> {

  @Override
  public void saveOrUpdate(Config entity) throws Exception {
    Config candidate = findByConfiguration(entity.getConfiguration());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Config> entities) throws Exception {
    int count = 0;
    for (Config l : entities) {

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

  public Config findByConfiguration(String configuration) {
    Query query = currentSession().getNamedQuery("Config.findByConfiguration");
    query.setParameter("configuration", configuration);
    return (Config) query.uniqueResult();
  }
}
