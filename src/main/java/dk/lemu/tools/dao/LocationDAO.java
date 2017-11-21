package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Location;
import org.hibernate.query.Query;

import java.util.Collection;

public class LocationDAO extends GenericDAOImplementation<Location, Long> {

  @Override
  public void saveOrUpdate(Location entity) throws Exception {
    Location candidate = findByLocation(entity.getLocation());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }

  }

  @Override
  public void multiSaveOrUpdate(Collection<Location> entities) throws Exception {
    int count = 0;
    for (Location l : entities) {
      saveOrUpdate(l);
      if (++count % 20 == 0) {
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
      }
    }
    commit();
  }

  public Location findByLocation(String locationId) {
    Query query = currentSession().getNamedQuery("Location.findByLocation");
    query.setParameter("locationId", locationId);
    return (Location) query.uniqueResult();
  }

  public int deleteOldPost() throws Exception {
    Query query = currentSession().createQuery("delete from Container where dbDate < :ninetyDays");
    query.setParameter("ninetyDays", ninetyDaysAgo); //90 dage
    query.executeUpdate();
    int numpost = query.executeUpdate();
    commit();
    return numpost;
  }
}
