package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "PutAway.findByContainerId", query = "SELECT object(o) FROM PutAway o WHERE o.containerId = :containerId")
})
@Entity
@Table(name = "PutAway",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "containerId"),
        @Index(columnList = "id, containerId")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PutAway extends AbstractEntity implements Serializable {

  private Long id;
  private String containerId; //0
  private Integer seqno; //1
  private String destLocn; //2
  private String destContainer; //3
  private Double quantity; //4
  private String mhe; //5
  private Integer stage; //6
  private String category; //7
  private Date creationTime; //8
  private String destContType; //9
  private String velocityCode; //10
  private Integer xCode; //11



  public PutAway() {

  }

  public PutAway(List<String> list) throws Exception {


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

  @Column(name = "containerId", unique = true, nullable = false)
  public String getContainerId() {
    return containerId;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }

  @Column(name = "seqno")
  public Integer getSeqno() {
    return seqno;
  }

  public void setSeqno(Integer seqno) {
    this.seqno = seqno;
  }

  @Column(name = "destLocn")
  public String getDestLocn() {
    return destLocn;
  }

  public void setDestLocn(String destLocn) {
    this.destLocn = destLocn;
  }

  @Column(name = "destContainer")
  public String getDestContainer() {
    return destContainer;
  }

  public void setDestContainer(String destContainer) {
    this.destContainer = destContainer;
  }

  @Column(name = "quantity")
  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  @Column(name = "mhe")
  public String getMhe() {
    return mhe;
  }

  public void setMhe(String mhe) {
    this.mhe = mhe;
  }

  @Column(name = "stage")
  public Integer getStage() {
    return stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  @Column(name = "category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Column(name = "creationTime")
  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  @Column(name = "destContType")
  public String getDestContType() {
    return destContType;
  }

  public void setDestContType(String destContType) {
    this.destContType = destContType;
  }

  @Column(name = "velocityCode")
  public String getVelocityCode() {
    return velocityCode;
  }

  public void setVelocityCode(String velocityCode) {
    this.velocityCode = velocityCode;
  }

  @Column(name = "xCode")
  public Integer getxCode() {
    return xCode;
  }

  public void setxCode(Integer xCode) {
    this.xCode = xCode;
  }

  @Override
  public String toString() {
    return "PutAway{" +
        "id=" + id +
        ", containerId='" + containerId + '\'' +
        ", seqno=" + seqno +
        ", destLocn='" + destLocn + '\'' +
        ", destContainer='" + destContainer + '\'' +
        ", quantity=" + quantity +
        ", mhe='" + mhe + '\'' +
        ", stage=" + stage +
        ", category='" + category + '\'' +
        ", creationTime=" + creationTime +
        ", destContType='" + destContType + '\'' +
        ", velocityCode='" + velocityCode + '\'' +
        ", xCode=" + xCode +
        '}';
  }
}

