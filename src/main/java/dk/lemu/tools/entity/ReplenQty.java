package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "ReplenQty.findByAllocRef", query = "SELECT object(o) FROM ReplenQty o WHERE o.allocRef = :allocRef")
})
@Entity
@Table(name = "ReplenQty",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "allocRef"),
        @Index(columnList = "id, allocRef")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ReplenQty extends AbstractEntity implements Serializable {

  private Long id;
  private Integer zone; //0
  private Integer stage; //1
  private Integer priority; //2
  private Double currentQty; //3
  private Double requiredQty; //4
  private Double minimumQty; //5
  private Double maximumQty; //6
  private Boolean belowMinimum; //7
  private Double qtyProcent; //8
  private Integer allocRef; //9
  private String startLocation; //10
  private String endLocation; //11
  private String clientCode; //12
  private String itemCode; //13
  private String itemConf; //14


  public ReplenQty() {

  }

  public ReplenQty(List<String> list) throws Exception {


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

  @Column(name = "zone")
  public Integer getZone() {
    return zone;
  }

  public void setZone(Integer zone) {
    this.zone = zone;
  }

  @Column(name = "stage")
  public Integer getStage() {
    return stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  @Column(name = "priority")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  @Column(name = "currentQty")
  public Double getCurrentQty() {
    return currentQty;
  }

  public void setCurrentQty(Double currentQty) {
    this.currentQty = currentQty;
  }

  @Column(name = "requiredQty")
  public Double getRequiredQty() {
    return requiredQty;
  }

  public void setRequiredQty(Double requiredQty) {
    this.requiredQty = requiredQty;
  }

  @Column(name = "minimumQty")
  public Double getMinimumQty() {
    return minimumQty;
  }

  public void setMinimumQty(Double minimumQty) {
    this.minimumQty = minimumQty;
  }

  @Column(name = "maximumQty")
  public Double getMaximumQty() {
    return maximumQty;
  }

  public void setMaximumQty(Double maximumQty) {
    this.maximumQty = maximumQty;
  }

  @Column(name = "belowMinimum")
  public Boolean getBelowMinimum() {
    return belowMinimum;
  }

  public void setBelowMinimum(Boolean belowMinimum) {
    this.belowMinimum = belowMinimum;
  }

  @Column(name = "qtyProcent")
  public Double getQtyProcent() {
    return qtyProcent;
  }

  public void setQtyProcent(Double qtyProcent) {
    this.qtyProcent = qtyProcent;
  }

  @Column(name = "allocRef", unique = true, nullable = false)
  public Integer getAllocRef() {
    return allocRef;
  }

  public void setAllocRef(Integer allocRef) {
    this.allocRef = allocRef;
  }

  @Column(name = "startLocation")
  public String getStartLocation() {
    return startLocation;
  }

  public void setStartLocation(String startLocation) {
    this.startLocation = startLocation;
  }

  @Column(name = "endLocation")
  public String getEndLocation() {
    return endLocation;
  }

  public void setEndLocation(String endLocation) {
    this.endLocation = endLocation;
  }

  @Column(name = "clientCode")
  public String getClientCode() {
    return clientCode;
  }

  public void setClientCode(String clientCode) {
    this.clientCode = clientCode;
  }

  @Column(name = "itemCode")
  public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  @Column(name = "itemConf")
  public String getItemConf() {
    return itemConf;
  }

  public void setItemConf(String itemConf) {
    this.itemConf = itemConf;
  }

  @Override
  public String toString() {
    return "ReplenQty{" +
        "id=" + id +
        ", zone=" + zone +
        ", stage=" + stage +
        ", priority=" + priority +
        ", currentQty=" + currentQty +
        ", requiredQty=" + requiredQty +
        ", minimumQty=" + minimumQty +
        ", maximumQty=" + maximumQty +
        ", belowMinimum=" + belowMinimum +
        ", qtyProcent=" + qtyProcent +
        ", allocRef=" + allocRef +
        ", startLocation='" + startLocation + '\'' +
        ", endLocation='" + endLocation + '\'' +
        ", clientCode='" + clientCode + '\'' +
        ", itemCode='" + itemCode + '\'' +
        ", itemConf='" + itemConf + '\'' +
        '}';
  }
}

