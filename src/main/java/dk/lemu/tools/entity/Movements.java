package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "Movements.findByOrigSourceAndCreateTime", query = "SELECT object(o) FROM Movements o " +
        "WHERE o.origSource = :origSource AND o.createTime = :createTime")
})
@Entity
@Table(name = "Movements", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, origSource, createTime")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Movements extends AbstractEntity implements Serializable {

  private Long id;
  private String origSource;
  private String source;
  private String destination;
  private String finalDest;
  private String mhe;
  private Date createTime;
  private Date activeTime;
  private Date stageTime;
  private Integer type;
  private Integer reason;
  private Integer priority;
  private Integer txFlag;
  private Integer group;
  private Integer stage;
  private String containerId;
  private String category;
  private Integer aisle;
  private Integer handler;
  private Integer origPriority;
  private Integer mission;
  private Integer wave;
  private Integer load;
  private Integer loadPart;

  public Movements() {

  }

  public Movements(List<String> list) throws Exception {


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

  public String getOrigSource() {
    return origSource;
  }

  public void setOrigSource(String origSource) {
    this.origSource = origSource;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getFinalDest() {
    return finalDest;
  }

  public void setFinalDest(String finalDest) {
    this.finalDest = finalDest;
  }

  public String getMhe() {
    return mhe;
  }

  public void setMhe(String mhe) {
    this.mhe = mhe;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getActiveTime() {
    return activeTime;
  }

  public void setActiveTime(Date activeTime) {
    this.activeTime = activeTime;
  }

  public Date getStageTime() {
    return stageTime;
  }

  public void setStageTime(Date stageTime) {
    this.stageTime = stageTime;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getReason() {
    return reason;
  }

  public void setReason(Integer reason) {
    this.reason = reason;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Integer getTxFlag() {
    return txFlag;
  }

  public void setTxFlag(Integer txFlag) {
    this.txFlag = txFlag;
  }

  public Integer getGroup() {
    return group;
  }

  public void setGroup(Integer group) {
    this.group = group;
  }

  public Integer getStage() {
    return stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  public String getContainerId() {
    return containerId;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Integer getAisle() {
    return aisle;
  }

  public void setAisle(Integer aisle) {
    this.aisle = aisle;
  }

  public Integer getHandler() {
    return handler;
  }

  public void setHandler(Integer handler) {
    this.handler = handler;
  }

  public Integer getOrigPriority() {
    return origPriority;
  }

  public void setOrigPriority(Integer origPriority) {
    this.origPriority = origPriority;
  }

  public Integer getMission() {
    return mission;
  }

  public void setMission(Integer mission) {
    this.mission = mission;
  }

  public Integer getWave() {
    return wave;
  }

  public void setWave(Integer wave) {
    this.wave = wave;
  }

  public Integer getLoad() {
    return load;
  }

  public void setLoad(Integer load) {
    this.load = load;
  }

  public Integer getLoadPart() {
    return loadPart;
  }

  public void setLoadPart(Integer loadPart) {
    this.loadPart = loadPart;
  }

  @Override
  public String toString() {
    return "Movements{" +
        "id=" + id +
        ", origSource='" + origSource + '\'' +
        ", source='" + source + '\'' +
        ", destination='" + destination + '\'' +
        ", finalDest='" + finalDest + '\'' +
        ", mhe='" + mhe + '\'' +
        ", createTime=" + createTime +
        ", activeTime=" + activeTime +
        ", stageTime=" + stageTime +
        ", type=" + type +
        ", reason=" + reason +
        ", priority=" + priority +
        ", txFlag=" + txFlag +
        ", group=" + group +
        ", stage=" + stage +
        ", containerId='" + containerId + '\'' +
        ", category='" + category + '\'' +
        ", aisle=" + aisle +
        ", handler=" + handler +
        ", origPriority=" + origPriority +
        ", mission=" + mission +
        ", wave=" + wave +
        ", load=" + load +
        ", loadPart=" + loadPart +
        '}';
  }
}

