
package dk.lemu.tools.dao;

import dk.lemu.tools.entity.ConfigurationCode;
import org.hibernate.query.Query;

import java.util.Collection;

public class ConfigurationCodeDAO extends GenericDAOImplementation <ConfigurationCode, Long>{

  @Override
  public void saveOrUpdate(ConfigurationCode entity) throws Exception {
    ConfigurationCode candidate = findByConfigurationCode(entity.getCode());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<ConfigurationCode> entities) throws Exception {
    int count=0;
    for (ConfigurationCode l : entities) {
      saveOrUpdate(l);
      if ( ++count % 20 == 0 ) {
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
      }
    }
  }

  public ConfigurationCode findByConfigurationCode(String itemCode) {
    Query query = currentSession().getNamedQuery("ConfigurationCode.findbyConfigurationCode");
    query.setParameter("code_id", itemCode);
    return (ConfigurationCode) query.uniqueResult();
  }
}

