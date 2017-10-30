package dk.lemu.tools.dao;

import dk.lemu.tools.entity.ItemConf;
import org.hibernate.query.Query;

import java.util.Collection;

public class ItemConfDAO extends GenericDAOImplementation <ItemConf, Long>{

  @Override
  public void saveOrUpdate(ItemConf entity) throws Exception {
    ItemConf candidate = findByItem(entity.getItem());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<ItemConf> entities) throws Exception {
    int count=0;
    for (ItemConf l : entities) {

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

  public ItemConf findByItem(String item) {
    Query query = currentSession().getNamedQuery("ItemConf.findbyItem");
    query.setParameter("item_id", item);
    return (ItemConf) query.uniqueResult();
  }
}
