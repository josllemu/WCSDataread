package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Item;
import dk.lemu.tools.entity.ItemConf;
import dk.lemu.tools.entity.ItemExt;
import org.hibernate.query.Query;

import java.util.Collection;

public class ItemExtDAO extends GenericDAOImplementation <ItemExt, Long>{

  @Override
  public void saveOrUpdate(ItemExt entity) throws Exception {
    ItemExt candidate = findByItem(entity.getItem());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<ItemExt> entities) throws Exception {
    int count=0;
    for (ItemExt l : entities) {

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

  public ItemExt findByItem(Item item) {
    Query query = currentSession().getNamedQuery("ItemExt.findbyItem");
    query.setParameter("item_id", item);
    return (ItemExt) query.uniqueResult();
  }
}
