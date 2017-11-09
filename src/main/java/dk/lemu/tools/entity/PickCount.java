package dk.lemu.tools.entity;

import dk.lemu.tools.dao.ItemDAO;
import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "PickCount.findbyItem", query = "SELECT object(pc) FROM PickCount pc WHERE pc.item = :item_id")
})
@Entity
@Table(name = "PickCount",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "item"),
        @Index(columnList = "id, item")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PickCount extends AbstractEntity implements Serializable {

  private Long id;
  private String clientCode; //0
  private String item; //1
  private Date lastUpdateTime; //3
  private Integer month1; //4
  private Integer month2; //5
  private Integer month3; //6


  public PickCount() {

  }

  public PickCount(List<String> list) throws Exception {
    ItemDAO itemDAO = new ItemDAO();

    this.setItem(list.get(1));
    this.setClientCode(list.get(0));
    this.setLastUpdateTime((Date) TypeParser.fromCSVFile(Date.class, list.get(2)));
    this.setMonth1((Integer) TypeParser.fromCSVFile(Integer.class, list.get(3)));
    this.setMonth2((Integer) TypeParser.fromCSVFile(Integer.class, list.get(4)));
    this.setMonth3((Integer) TypeParser.fromCSVFile(Integer.class, list.get(5)));

  }

  @Id
  @GenericGenerator(name = "josl", strategy = "increment")
  @GeneratedValue(generator = "josl")
  @Column(name = "Id", unique = true, nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "item", unique = true, nullable = false, length = 50)
  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  @Column(name = "clientcode", nullable = false, length = 50)
  public String getClientCode() {
    return clientCode;
  }

  public void setClientCode(String clientCode) {
    this.clientCode = clientCode;
  }

  @Column(name = "lastUpdateTime")
  public Date getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(Date lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  @Column(name = "month1")
  public Integer getMonth1() {
    return month1;
  }

  public void setMonth1(Integer month1) {
    this.month1 = month1;
  }

  @Column(name = "month2")
  public Integer getMonth2() {
    return month2;
  }

  public void setMonth2(Integer month2) {
    this.month2 = month2;
  }

  @Column(name = "month3")
  public Integer getMonth3() {
    return month3;
  }

  public void setMonth3(Integer month3) {
    this.month3 = month3;
  }

  @Override
  public String toString() {
    return "PickCount{" +
        "id=" + id +
        ", clientCode='" + clientCode + '\'' +
        ", item='" + item + '\'' +
        ", lastUpdateTime=" + lastUpdateTime +
        ", month1=" + month1 +
        ", month2=" + month2 +
        ", month3=" + month3 +
        '}';
  }
}

