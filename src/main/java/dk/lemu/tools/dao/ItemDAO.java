package dk.lemu.tools.dao;

import dk.lemu.tools.entity.Item;
import org.hibernate.query.Query;

import java.util.Collection;

public class ItemDAO extends GenericDAOImplementation<Item, Long> {

  @Override
  public void saveOrUpdate(Item entity) throws Exception {
    Item candidate = findByItemCode(entity.getItem_code());
    if (candidate != null) {
      entity.setId(candidate.getId());
      currentSession().merge(entity);
    } else {
      currentSession().save(entity);
    }
  }

  @Override
  public void multiSaveOrUpdate(Collection<Item> entities) throws Exception {
    int count = 0;
    for (Item l : entities) {
      saveOrUpdate(l);
      if (++count % 20 == 0) {
        //flush a batch of updates and release memory:
        currentSession().flush();
        currentSession().clear();
      }
    }
    commit();
  }

  public Item findByItemCode(String itemCode) {
    Query query = currentSession().getNamedQuery("Item.findbyItemCode");
    query.setParameter("itemCode", itemCode);
    return (Item) query.uniqueResult();
  }
}
