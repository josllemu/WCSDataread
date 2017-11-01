package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "OperatorEvent.findByHisID", query = "SELECT object(o) FROM OperatorEvent o WHERE o.hisID = :his_ID")
})
@Entity
@Table(name = "OperatorEvent",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "hisID"),
        @Index(columnList = "id, hisID")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OperatorEvent extends AbstractEntity implements Serializable {

  private Long id;
  private Long hisID; //0
  private String jobType; //1
  private Date timestamp; //2
  private Long timeUsage; //3
  private String user; //4
  private String zone; //5
  private Location fromLocation; //6
  private Location viaLocation; //7
  private Location toLocation; //8
  private String orderId; //9
  private String orderNumber; //10
  private Integer allocRef; //11
  private String lineId; //12
  private Integer priority; //13
  private String item; //14
  private String fromContainer; //15
  private String toContainer; //16
  private Double fromQtyBefore; //17
  private Double fromQtyAfter; //18
  private Double toQtyBefore; //19
  private Double toQtyAfter; //20
  private String barcode; //21
  private String category; //22
  private Date dbDato = new Date();

  public OperatorEvent() {

  }

  public OperatorEvent(List<String> list) throws Exception {


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

  @Column(name = "hisID", unique = true, nullable = false)
  public Long getHisID() {
    return hisID;
  }

  public void setHisID(Long hisID) {
    this.hisID = hisID;
  }

  @Column(name = "jobType")
  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  @Column(name = "timestamp")
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @Column(name = "timeUsage")
  public Long getTimeUsage() {
    return timeUsage;
  }

  public void setTimeUsage(Long timeUsage) {
    this.timeUsage = timeUsage;
  }

  @Column(name = "user")
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  @Column(name = "zone")
  public String getZone() {
    return zone;
  }

  public void setZone(String zone) {
    this.zone = zone;
  }

  @Column(name = "fromLocation")
  public Location getFromLocation() {
    return fromLocation;
  }

  public void setFromLocation(Location fromLocation) {
    this.fromLocation = fromLocation;
  }

  @Column(name = "viaLocation")
  public Location getViaLocation() {
    return viaLocation;
  }

  public void setViaLocation(Location viaLocation) {
    this.viaLocation = viaLocation;
  }

  @Column(name = "toLocation")
  public Location getToLocation() {
    return toLocation;
  }

  public void setToLocation(Location toLocation) {
    this.toLocation = toLocation;
  }

  @Column(name = "orderId")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  @Column(name = "allocRef")
  public Integer getAllocRef() {
    return allocRef;
  }

  public void setAllocRef(Integer allocRef) {
    this.allocRef = allocRef;
  }

  @Column(name = "lineId")
  public String getLineId() {
    return lineId;
  }

  public void setLineId(String lineId) {
    this.lineId = lineId;
  }

  @Column(name = "priority")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  @Column(name = "item")
  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  @Column(name = "fromContainer")
  public String getFromContainer() {
    return fromContainer;
  }

  public void setFromContainer(String fromContainer) {
    this.fromContainer = fromContainer;
  }

  @Column(name = "toContainer")
  public String getToContainer() {
    return toContainer;
  }

  public void setToContainer(String toContainer) {
    this.toContainer = toContainer;
  }

  @Column(name = "fromQtyBefore")
  public Double getFromQtyBefore() {
    return fromQtyBefore;
  }

  public void setFromQtyBefore(Double fromQtyBefore) {
    this.fromQtyBefore = fromQtyBefore;
  }

  @Column(name = "fromQtyAfter")
  public Double getFromQtyAfter() {
    return fromQtyAfter;
  }

  public void setFromQtyAfter(Double fromQtyAfter) {
    this.fromQtyAfter = fromQtyAfter;
  }

  @Column(name = "toQtyBefore")
  public Double getToQtyBefore() {
    return toQtyBefore;
  }

  public void setToQtyBefore(Double toQtyBefore) {
    this.toQtyBefore = toQtyBefore;
  }

  @Column(name = "toQtyAfter")
  public Double getToQtyAfter() {
    return toQtyAfter;
  }

  public void setToQtyAfter(Double toQtyAfter) {
    this.toQtyAfter = toQtyAfter;
  }

  @Column(name = "barcode")
  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  @Column(name = "category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Column(name = "dbDato")
  public Date getDbDato() {
    return dbDato;
  }

  public void setDbDato(Date dbDato) {
    this.dbDato = dbDato;
  }

  @Column(name = "orderNumber")
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Override
  public String toString() {
    return "OperatorEvent{" +
        "id=" + id +
        ", hisID=" + hisID +
        ", jobType='" + jobType + '\'' +
        ", timestamp=" + timestamp +
        ", timeUsage=" + timeUsage +
        ", user='" + user + '\'' +
        ", zone='" + zone + '\'' +
        ", fromLocation=" + fromLocation +
        ", viaLocation=" + viaLocation +
        ", toLocation=" + toLocation +
        ", orderId='" + orderId + '\'' +
        ", orderNumber='" + orderNumber + '\'' +
        ", allocRef=" + allocRef +
        ", lineId='" + lineId + '\'' +
        ", priority=" + priority +
        ", item='" + item + '\'' +
        ", fromContainer='" + fromContainer + '\'' +
        ", toContainer='" + toContainer + '\'' +
        ", fromQtyBefore=" + fromQtyBefore +
        ", fromQtyAfter=" + fromQtyAfter +
        ", toQtyBefore=" + toQtyBefore +
        ", toQtyAfter=" + toQtyAfter +
        ", barcode='" + barcode + '\'' +
        ", category='" + category + '\'' +
        ", dbDato=" + dbDato +
        '}';
  }
}

