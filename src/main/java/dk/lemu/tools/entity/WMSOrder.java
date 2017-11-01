package dk.lemu.tools.entity;

import dk.lemu.tools.dao.ItemDAO;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "WMSOrder.findByOrderId", query = "SELECT object(o) FROM WMSOrder o WHERE o.orderId = :order_Id"),
    @NamedQuery(name = "WMSOrder.findByOrderNumber", query = "SELECT object(o) FROM WMSOrder o WHERE o.orderNumber = :order_Number"),
    @NamedQuery(name = "WMSOrder.findByDelNoteId", query = "SELECT object(o) FROM WMSOrder o WHERE o.delNoteId = :delNoteId")

})
@Entity
@Table(name = "WMSOrder", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"orderId","orderNumber","delNoteId"})},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "orderId"),
        @Index(columnList = "orderNumber"),
        @Index(columnList = "delNoteId"),
        @Index(columnList = "id, orderId, orderNumber"),
        @Index(columnList = "id, orderId"),
        @Index(columnList = "id, orderNumber"),
        @Index(columnList = "id, delNoteId"),
        @Index(columnList = "id, orderId, orderNumber, delNoteId")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WMSOrder extends AbstractEntity implements Serializable {

  private Long id;
  private Integer orderId; //0
  private String typeId; //1
  private String status; //2
  private Integer priority; //3
  private Integer noLines; //4
  private Date createdDate; //5
  private Integer orderNumber; //6
  private String delNoteId; //7
  private String refText; //8
  private Integer contGroup; //9
  private String statusToHost; //10
  private String hostName; //11
  private Integer boxes; //12
  private Integer pallets; //13
  private Integer packageNo; //14
  private Integer stage; //15
  private String workStation; //16
  private Boolean printRequired; //17
  private Date dbDate = new Date();

  public WMSOrder() {

  }

  public WMSOrder(List<String> list) throws Exception {
    ItemDAO itemDAO = new ItemDAO();


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

  @Column(name = "orderId", unique = true,  nullable = false)
  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  @Column(name = "typeId")
  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  @Column(name = "status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Column(name = "priority")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  @Column(name = "noLines")
  public Integer getNoLines() {
    return noLines;
  }

  public void setNoLines(Integer noLines) {
    this.noLines = noLines;
  }

  @Column(name = "createdDate")
  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Column(name = "orderNumber", unique = true,  nullable = false)
  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Column(name = "delNoteId", unique = true,  nullable = false)
  public String getDelNoteId() {
    return delNoteId;
  }

  public void setDelNoteId(String delNoteId) {
    this.delNoteId = delNoteId;
  }

  @Column(name = "refText")
  public String getRefText() {
    return refText;
  }

  public void setRefText(String refText) {
    this.refText = refText;
  }

  @Column(name = "contGroup")
  public Integer getContGroup() {
    return contGroup;
  }

  public void setContGroup(Integer contGroup) {
    this.contGroup = contGroup;
  }

  @Column(name = "statusToHost")
  public String getStatusToHost() {
    return statusToHost;
  }

  public void setStatusToHost(String statusToHost) {
    this.statusToHost = statusToHost;
  }

  @Column(name = "hostName")
  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  @Column(name = "boxes")
  public Integer getBoxes() {
    return boxes;
  }

  public void setBoxes(Integer boxes) {
    this.boxes = boxes;
  }

  @Column(name = "pallets")
  public Integer getPallets() {
    return pallets;
  }

  public void setPallets(Integer pallets) {
    this.pallets = pallets;
  }

  @Column(name = "packageNo")
  public Integer getPackageNo() {
    return packageNo;
  }

  public void setPackageNo(Integer packageNo) {
    this.packageNo = packageNo;
  }

  @Column(name = "stage")
  public Integer getStage() {
    return stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  @Column(name = "workStation")
  public String getWorkStation() {
    return workStation;
  }

  public void setWorkStation(String workStation) {
    this.workStation = workStation;
  }

  @Column(name = "printRequired")
  public Boolean getPrintRequired() {
    return printRequired;
  }

  public void setPrintRequired(Boolean printRequired) {
    this.printRequired = printRequired;
  }

  @Column(name = "dbDate")
  public Date getDbDate() {
    return dbDate;
  }

  public void setDbDate(Date dbDate) {
    this.dbDate = dbDate;
  }

  @Override
  public String toString() {
    return "WMSOrder{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", typeId='" + typeId + '\'' +
        ", status='" + status + '\'' +
        ", priority=" + priority +
        ", noLines=" + noLines +
        ", createdDate=" + createdDate +
        ", orderNumber=" + orderNumber +
        ", delNoteId='" + delNoteId + '\'' +
        ", refText='" + refText + '\'' +
        ", contGroup=" + contGroup +
        ", statusToHost='" + statusToHost + '\'' +
        ", hostName='" + hostName + '\'' +
        ", boxes=" + boxes +
        ", pallets=" + pallets +
        ", packageNo=" + packageNo +
        ", stage=" + stage +
        ", workStation='" + workStation + '\'' +
        ", printRequired=" + printRequired +
        ", dbDate=" + dbDate +
        '}';
  }
}

