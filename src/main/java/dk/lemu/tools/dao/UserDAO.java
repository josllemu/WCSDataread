package dk.lemu.tools.dao;

import dk.lemu.tools.entity.User;
import org.hibernate.query.Query;

import java.util.Collection;

public class UserDAO extends GenericDAOImplementation<User, Long> {

  @Override
  public void saveOrUpdate(User entity) throws Exception {
    User candidate = findByUserName(entity.getUsername());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<User> entities) throws Exception {
    int count = 0;
    for (User l : entities) {

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

  public User findByUserName(String username) {
    Query query = currentSession().getNamedQuery("User.findByUserName");
    query.setParameter("username", username);
    return (User) query.uniqueResult();
  }
}
