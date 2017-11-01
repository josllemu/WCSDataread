package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "PickReq.findByAllocRef", query = "SELECT object(o) FROM PickReq o WHERE o.allocRef = :allocRef")
})
@Entity
@Table(name = "PickReq",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "allocRef"),
        @Index(columnList = "id, allocRef")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PickReq extends AbstractEntity implements Serializable {

  private Long id;
  private Integer allocRef; //0
  private Integer pickGroup; //1
  private Integer subGroup; //2
  private Integer stage; //3
  private String mhe; //4
  private Integer sequenceNo; //5
  private String containerId; //6
  private Integer buildOrder; //7
  private Date creationTime; //8
  private Integer priority; //9
  private String destContainer; //10
  private Integer origSourceZone; //11
  private Integer pickZone; //12
  private String pickType; //13
  private String pickCategory; //14
  private Integer holdReason; //15
  private Date stageTime; //16

  private Date dbDate = new Date();


  public PickReq() {

  }

  public PickReq(List<String> list) throws Exception {


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

  @Column(name = "allocRef", unique = true, nullable = false)
  public Integer getAllocRef() {
    return allocRef;
  }

  public void setAllocRef(Integer allocRef) {
    this.allocRef = allocRef;
  }

  @Column(name = "pickGroup")
  public Integer getPickGroup() {
    return pickGroup;
  }

  public void setPickGroup(Integer pickGroup) {
    this.pickGroup = pickGroup;
  }

  @Column(name = "subGroup")
  public Integer getSubGroup() {
    return subGroup;
  }

  public void setSubGroup(Integer subGroup) {
    this.subGroup = subGroup;
  }

  @Column(name = "stage")
  public Integer getStage() {
    return stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  @Column(name = "mhe")
  public String getMhe() {
    return mhe;
  }

  public void setMhe(String mhe) {
    this.mhe = mhe;
  }

  @Column(name = "sequenceNo")
  public Integer getSequenceNo() {
    return sequenceNo;
  }

  public void setSequenceNo(Integer sequenceNo) {
    this.sequenceNo = sequenceNo;
  }

  @Column(name = "containerId")
  public String getContainerId() {
    return containerId;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }

  @Column(name = "buildOrder")
  public Integer getBuildOrder() {
    return buildOrder;
  }

  public void setBuildOrder(Integer buildOrder) {
    this.buildOrder = buildOrder;
  }

  @Column(name = "creationTime")
  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  @Column(name = "priority")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  @Column(name = "destContainer")
  public String getDestContainer() {
    return destContainer;
  }

  public void setDestContainer(String destContainer) {
    this.destContainer = destContainer;
  }

  @Column(name = "origSourceZone")
  public Integer getOrigSourceZone() {
    return origSourceZone;
  }

  public void setOrigSourceZone(Integer origSourceZone) {
    this.origSourceZone = origSourceZone;
  }

  @Column(name = "pickZone")
  public Integer getPickZone() {
    return pickZone;
  }

  public void setPickZone(Integer pickZone) {
    this.pickZone = pickZone;
  }

  @Column(name = "pickType")
  public String getPickType() {
    return pickType;
  }

  public void setPickType(String pickType) {
    this.pickType = pickType;
  }

  @Column(name = "pickCategory")
  public String getPickCategory() {
    return pickCategory;
  }

  public void setPickCategory(String pickCategory) {
    this.pickCategory = pickCategory;
  }

  @Column(name = "holdReason")
  public Integer getHoldReason() {
    return holdReason;
  }

  public void setHoldReason(Integer holdReason) {
    this.holdReason = holdReason;
  }

  @Column(name = "stageTime")
  public Date getStageTime() {
    return stageTime;
  }

  public void setStageTime(Date stageTime) {
    this.stageTime = stageTime;
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
    return "PickReq{" +
        "id=" + id +
        ", allocRef=" + allocRef +
        ", pickGroup=" + pickGroup +
        ", subGroup=" + subGroup +
        ", stage=" + stage +
        ", mhe='" + mhe + '\'' +
        ", sequenceNo=" + sequenceNo +
        ", containerId='" + containerId + '\'' +
        ", buildOrder=" + buildOrder +
        ", creationTime=" + creationTime +
        ", priority=" + priority +
        ", destContainer='" + destContainer + '\'' +
        ", origSourceZone=" + origSourceZone +
        ", pickZone=" + pickZone +
        ", pickType='" + pickType + '\'' +
        ", pickCategory='" + pickCategory + '\'' +
        ", holdReason=" + holdReason +
        ", stageTime=" + stageTime +
        ", dbDate=" + dbDate +
        '}';
  }
}

