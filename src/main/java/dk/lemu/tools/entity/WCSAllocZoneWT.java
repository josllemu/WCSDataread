package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "WCSAllocZoneWT.findByZonePriorityAndWeight", query = "SELECT object(o) FROM WCSAllocZoneWT o " +
        "WHERE o.zone = :zone AND o.priority = :priority AND o.weight = :weight")
})
@Entity
@Table(name = "WCSAllocZoneWT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"zone","priority","weight"})},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, zone, priority, weight")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WCSAllocZoneWT extends AbstractEntity implements Serializable {

  private Long id;
  private String orderType; //0
  private Integer zone; //1
  private Integer priority; //2
  private Double weight; //3
  private String value; //4
  private Boolean heigestAmount; //5


  public WCSAllocZoneWT() {

  }

  public WCSAllocZoneWT(List<String> list) throws Exception {
    this.setOrderType((String) TypeParser.fromCSVFile(String.class, list.get(0)));
    this.setZone((Integer) TypeParser.fromCSVFile(Integer.class, list.get(1)));
    this.setPriority((Integer) TypeParser.fromCSVFile(Integer.class, list.get(2)));
    this.setWeight((Double) TypeParser.fromCSVFile(Double.class, list.get(3)));
    this.setValue((String) TypeParser.fromCSVFile(String.class, list.get(4)));
    this.setHeigestAmount((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(5)));


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

  @Column(name = "orderType")
  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  @Column(name = "zone")
  public Integer getZone() {
    return zone;
  }

  public void setZone(Integer zone) {
    this.zone = zone;
  }

  @Column(name = "priority")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  @Column(name = "weight")
  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  @Column(name = "value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Column(name = "heigestAmount")
  public Boolean getHeigestAmount() {
    return heigestAmount;
  }

  public void setHeigestAmount(Boolean heigestAmount) {
    this.heigestAmount = heigestAmount;
  }

  @Override
  public String toString() {
    return "WCSAllocZoneWT{" +
        "id=" + id +
        ", orderType='" + orderType + '\'' +
        ", zone=" + zone +
        ", priority=" + priority +
        ", weight=" + weight +
        ", value='" + value + '\'' +
        ", heigestAmount=" + heigestAmount +
        '}';
  }
}

