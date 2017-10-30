package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "OperatorEvent.findByUnit", query = "SELECT object(o) FROM OperatorEvent o WHERE o.unit = :unit")
})
@Entity
@Table(name = "OperatorEvent", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "unit")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "unit"),
        @Index(columnList = "id, unit")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OperatorEvent extends AbstractEntity implements Serializable {

  private Long id;
  private Long hisID;
  private String jobType;
  private Date timestamp;
  private Long timeUsage;
  private User user;
  private Zone Zone;
  private Location FromLocation;
  private Location ViaLocation;
  private Location ToLocation;
  private WMSOrder orderId;
//  OrderNumber
  private Integer AllocRef;
  private WMSOrderLine lineId;
  private Integer Priority;
  private Item item;
  private Container FromContainer;
  private Container ToContainer;
  private Double FromQtyBefore;
  private Double FromQtyAfter;
  private Double ToQtyBefore;
  private Double ToQtyAfter;
  private String Barcode;
  private String Category;
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

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public Long getTimeUsage() {
    return timeUsage;
  }

  public void setTimeUsage(Long timeUsage) {
    this.timeUsage = timeUsage;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public dk.lemu.tools.entity.Zone getZone() {
    return Zone;
  }

  public void setZone(dk.lemu.tools.entity.Zone zone) {
    Zone = zone;
  }

  public Location getFromLocation() {
    return FromLocation;
  }

  public void setFromLocation(Location fromLocation) {
    FromLocation = fromLocation;
  }

  public Location getViaLocation() {
    return ViaLocation;
  }

  public void setViaLocation(Location viaLocation) {
    ViaLocation = viaLocation;
  }

  public Location getToLocation() {
    return ToLocation;
  }

  public void setToLocation(Location toLocation) {
    ToLocation = toLocation;
  }

  public WMSOrder getOrderId() {
    return orderId;
  }

  public void setOrderId(WMSOrder orderId) {
    this.orderId = orderId;
  }

  public Integer getAllocRef() {
    return AllocRef;
  }

  public void setAllocRef(Integer allocRef) {
    AllocRef = allocRef;
  }

  public WMSOrderLine getLineId() {
    return lineId;
  }

  public void setLineId(WMSOrderLine lineId) {
    this.lineId = lineId;
  }

  public Integer getPriority() {
    return Priority;
  }

  public void setPriority(Integer priority) {
    Priority = priority;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Container getFromContainer() {
    return FromContainer;
  }

  public void setFromContainer(Container fromContainer) {
    FromContainer = fromContainer;
  }

  public Container getToContainer() {
    return ToContainer;
  }

  public void setToContainer(Container toContainer) {
    ToContainer = toContainer;
  }

  public Double getFromQtyBefore() {
    return FromQtyBefore;
  }

  public void setFromQtyBefore(Double fromQtyBefore) {
    FromQtyBefore = fromQtyBefore;
  }

  public Double getFromQtyAfter() {
    return FromQtyAfter;
  }

  public void setFromQtyAfter(Double fromQtyAfter) {
    FromQtyAfter = fromQtyAfter;
  }

  public Double getToQtyBefore() {
    return ToQtyBefore;
  }

  public void setToQtyBefore(Double toQtyBefore) {
    ToQtyBefore = toQtyBefore;
  }

  public Double getToQtyAfter() {
    return ToQtyAfter;
  }

  public void setToQtyAfter(Double toQtyAfter) {
    ToQtyAfter = toQtyAfter;
  }

  public String getBarcode() {
    return Barcode;
  }

  public void setBarcode(String barcode) {
    Barcode = barcode;
  }

  public String getCategory() {
    return Category;
  }

  public void setCategory(String category) {
    Category = category;
  }

  public Date getDbDato() {
    return dbDato;
  }

  public void setDbDato(Date dbDato) {
    this.dbDato = dbDato;
  }

  @Override
  public String toString() {
    return "OperatorEvent{" +
        "id=" + id +
        ", hisID=" + hisID +
        ", jobType='" + jobType + '\'' +
        ", timestamp=" + timestamp +
        ", timeUsage=" + timeUsage +
        ", user=" + user +
        ", Zone=" + Zone +
        ", FromLocation=" + FromLocation +
        ", ViaLocation=" + ViaLocation +
        ", ToLocation=" + ToLocation +
        ", orderId=" + (orderId != null ? orderId.getOrderId() : null) +
        ", orderId=" + (orderId != null ? orderId.getOrderNumber() : null) +
        ", AllocRef=" + AllocRef +
        ", lineId=" + lineId +
        ", Priority=" + Priority +
        ", item=" + item +
        ", FromContainer=" + FromContainer +
        ", ToContainer=" + ToContainer +
        ", FromQtyBefore=" + FromQtyBefore +
        ", FromQtyAfter=" + FromQtyAfter +
        ", ToQtyBefore=" + ToQtyBefore +
        ", ToQtyAfter=" + ToQtyAfter +
        ", Barcode='" + Barcode + '\'' +
        ", Category='" + Category + '\'' +
        ", dbDato=" + dbDato +
        '}';
  }
}
