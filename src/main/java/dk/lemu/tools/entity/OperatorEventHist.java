package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "OperatorEventHist.findByHisID", query = "SELECT object(o) FROM OperatorEventHist o WHERE o.hisID = :his_ID")
})
@Entity
@Table(name = "OperatorEventHist",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "hisID"),
        @Index(columnList = "id, hisID")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OperatorEventHist extends AbstractEntity implements Serializable {

  private Long id;
  private Long hisID; //0
  private String jobType; //1
  private Date timestamp; //2
  private Long timeUsage; //3
  private String user; //4
  private Integer zone; //5
  private String fromLocation; //6
  private String viaLocation; //7
  private String toLocation; //8
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

  public OperatorEventHist() {

  }

  public OperatorEventHist(List<String> list) throws Exception {
    this.setHisID((Long) TypeParser.fromCSVFile(Long.class, list.get(0)));
    this.setJobType(list.get(1));
    this.setTimestamp((Date) TypeParser.fromCSVFile(Date.class, list.get(2)));
    this.setTimeUsage((Long) TypeParser.fromCSVFile(Long.class, list.get(3)));
    this.setUser(list.get(4));
    this.setZone((Integer) TypeParser.fromCSVFile(Integer.class, list.get(5)));
    this.setFromLocation(list.get(6));
    this.setViaLocation(list.get(7));
    this.setToLocation(list.get(8));
    this.setOrderId(list.get(9));
    this.setOrderNumber(list.get(10));
    this.setAllocRef((Integer) TypeParser.fromCSVFile(Integer.class, list.get(11)));
    this.setLineId(list.get(12));
    this.setPriority((Integer) TypeParser.fromCSVFile(Integer.class, list.get(13)));
    this.setItem(list.get(14));
    this.setFromContainer(list.get(15));
    this.setToLocation(list.get(16));
    this.setFromQtyBefore((Double) TypeParser.fromCSVFile(Double.class, list.get(17)));
    this.setFromQtyAfter((Double) TypeParser.fromCSVFile(Double.class, list.get(18)));
    this.setToQtyBefore((Double) TypeParser.fromCSVFile(Double.class, list.get(19)));
    this.setToQtyAfter((Double) TypeParser.fromCSVFile(Double.class, list.get(20)));
    this.setBarcode(list.get(21));
    this.setCategory(list.get(22));
    this.setDbDato(new Date());
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

  @Column(name = "hisID", nullable = false)
  public Long getHisID() {
    return hisID;
  }

  public void setHisID(Long hisID) {
    this.hisID = hisID;
  }

  @Column(name = "jobType", length = 15)
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

  @Column(name = "user", length = 50)
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  @Column(name = "zone")
  public Integer getZone() {
    return zone;
  }

  public void setZone(Integer zone) {
    this.zone = zone;
  }

  @Column(name = "fromLocation", length = 15)
  public String getFromLocation() {
    return fromLocation;
  }

  public void setFromLocation(String fromLocation) {
    this.fromLocation = fromLocation;
  }

  @Column(name = "viaLocation", length = 15)
  public String getViaLocation() {
    return viaLocation;
  }

  public void setViaLocation(String viaLocation) {
    this.viaLocation = viaLocation;
  }

  @Column(name = "toLocation", length = 15)
  public String getToLocation() {
    return toLocation;
  }

  public void setToLocation(String toLocation) {
    this.toLocation = toLocation;
  }

  @Column(name = "orderId", length = 50)
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

  @Column(name = "lineId", length = 25)
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

  @Column(name = "item", length = 50)
  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  @Column(name = "fromContainer", length = 25)
  public String getFromContainer() {
    return fromContainer;
  }

  public void setFromContainer(String fromContainer) {
    this.fromContainer = fromContainer;
  }

  @Column(name = "toContainer", length = 25)
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

  @Column(name = "barcode", length = 25)
  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  @Column(name = "category", length = 15)
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

  @Column(name = "orderNumber", length = 50)
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Override
  public String toString() {
    return "OperatorEventHist{" +
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

