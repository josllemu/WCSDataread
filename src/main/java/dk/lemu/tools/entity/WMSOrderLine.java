package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "WMSOrderLine.findByOrderAndLine", query = "SELECT object(o) FROM WMSOrderLine o WHERE o.orderId = :orderId AND o.line = :line")
})
@Entity
@Table(name = "WMSOrderLine",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"orderId","line","allocRef"})},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "orderId"),
        @Index(columnList = "allocRef"),
        @Index(columnList = "id, orderId, line"),
        @Index(columnList = "id, orderId, line, allocRef")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WMSOrderLine extends AbstractEntity implements Serializable {

  private Long id;
  private Integer orderId; //0
  private Integer line; //1
  private String status; //2
  private Integer allocRef; //3
  private Integer expected; //4
  private Integer actual; //5
  private Integer receipt; //6
  private Integer special; //7
  private Integer olrpSent; //8
  private Integer contGroup; //9
  private String itemCode; //10
  private String codeNumber; //11
  private String text; //12
  private String purchaseOrder; //13
  private String blocked; //14
  private String statusToHost; //15
  private String hostname; //16
  private Integer allowForce; //17
  private Integer certificate; //18
  private Integer eachAllocRef; //19
  private String altUnit; //20
  private Integer altCount; //21



  public WMSOrderLine() {

  }

  public WMSOrderLine(List<String> list) throws Exception {


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

  @Column(name = "orderId")
  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  @Column(name = "line")
  public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  @Column(name = "status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Column(name = "allocRef", unique = true, nullable = false)
  public Integer getAllocRef() {
    return allocRef;
  }

  public void setAllocRef(Integer allocRef) {
    this.allocRef = allocRef;
  }

  @Column(name = "expected")
  public Integer getExpected() {
    return expected;
  }

  public void setExpected(Integer expected) {
    this.expected = expected;
  }

  @Column(name = "actual")
  public Integer getActual() {
    return actual;
  }

  public void setActual(Integer actual) {
    this.actual = actual;
  }

  @Column(name = "receipt")
  public Integer getReceipt() {
    return receipt;
  }

  public void setReceipt(Integer receipt) {
    this.receipt = receipt;
  }

  @Column(name = "special")
  public Integer getSpecial() {
    return special;
  }

  public void setSpecial(Integer special) {
    this.special = special;
  }

  @Column(name = "olrpSent")
  public Integer getOlrpSent() {
    return olrpSent;
  }

  public void setOlrpSent(Integer olrpSent) {
    this.olrpSent = olrpSent;
  }

  @Column(name = "contGroup")
  public Integer getContGroup() {
    return contGroup;
  }

  public void setContGroup(Integer contGroup) {
    this.contGroup = contGroup;
  }

  @Column(name = "itemCode")
  public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  @Column(name = "codeNumber")
  public String getCodeNumber() {
    return codeNumber;
  }

  public void setCodeNumber(String codeNumber) {
    this.codeNumber = codeNumber;
  }

  @Column(name = "text")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Column(name = "purchaseOrder")
  public String getPurchaseOrder() {
    return purchaseOrder;
  }

  public void setPurchaseOrder(String purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
  }

  @Column(name = "blocked")
  public String getBlocked() {
    return blocked;
  }

  public void setBlocked(String blocked) {
    this.blocked = blocked;
  }

  @Column(name = "statusToHost")
  public String getStatusToHost() {
    return statusToHost;
  }

  public void setStatusToHost(String statusToHost) {
    this.statusToHost = statusToHost;
  }

  @Column(name = "hostname")
  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  @Column(name = "allowForce")
  public Integer getAllowForce() {
    return allowForce;
  }

  public void setAllowForce(Integer allowForce) {
    this.allowForce = allowForce;
  }

  @Column(name = "certificate")
  public Integer getCertificate() {
    return certificate;
  }

  public void setCertificate(Integer certificate) {
    this.certificate = certificate;
  }

  @Column(name = "eachAllocRef")
  public Integer getEachAllocRef() {
    return eachAllocRef;
  }

  public void setEachAllocRef(Integer eachAllocRef) {
    this.eachAllocRef = eachAllocRef;
  }

  @Column(name = "altUnit")
  public String getAltUnit() {
    return altUnit;
  }

  public void setAltUnit(String altUnit) {
    this.altUnit = altUnit;
  }

  @Column(name = "altCount")
  public Integer getAltCount() {
    return altCount;
  }

  public void setAltCount(Integer altCount) {
    this.altCount = altCount;
  }

  @Override
  public String toString() {
    return "WMSOrderLine{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", line='" + line + '\'' +
        ", status='" + status + '\'' +
        ", allocRef=" + allocRef +
        ", expected=" + expected +
        ", actual=" + actual +
        ", receipt=" + receipt +
        ", special=" + special +
        ", olrpSent=" + olrpSent +
        ", contGroup=" + contGroup +
        ", itemCode='" + itemCode + '\'' +
        ", codeNumber='" + codeNumber + '\'' +
        ", text='" + text + '\'' +
        ", purchaseOrder='" + purchaseOrder + '\'' +
        ", blocked='" + blocked + '\'' +
        ", statusToHost='" + statusToHost + '\'' +
        ", hostname='" + hostname + '\'' +
        ", allowForce=" + allowForce +
        ", certificate=" + certificate +
        ", eachAllocRef=" + eachAllocRef +
        ", altUnit='" + altUnit + '\'' +
        ", altCount=" + altCount +
        '}';
  }
}

