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
    @NamedQuery(name = "Movements.findByContainerAndCreateTime", query = "SELECT object(o) FROM Movements o " +
        "WHERE o.containerId = :containerId AND o.createTime = :createTime")
})
@Entity
@Table(name = "Movements", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"containerId", "createTime"})},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, containerId, createTime")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Movements extends AbstractEntity implements Serializable {

  private Long id;
  private String origSource; //0
  private String finalSource; //1
  private String destination; //2
  private String finalDest; //3
  private String mhe; //4
  private Date createTime; //5
  private Date activeTime; //6
  private Date stageTime; //7
  private Integer type; //8
  private Integer reason; //9
  private Integer priority; //10
  private Integer txFlag; //11
  private Integer groupInfo; //12
  private Integer stage; //13
  private String containerId; //14
  private String category; //15
  private Integer aisle; //16
  private Integer handler; //17
  private Integer origPriority; //18
  private Integer mission; //19
  private Integer wave; //20
  private Integer loadInfo; //21
  private Integer loadPart; //22

  public Movements() {

  }

  public Movements(List<String> list) throws Exception {

    this.setOrigSource(list.get(0));
    this.setFinalSource(list.get(1));
    this.setDestination(list.get(2));
    this.setFinalDest(list.get(3));
    this.setMhe(list.get(4));
    this.setCreateTime((Date) TypeParser.fromCSVFile(Date.class, list.get(5)));
    this.setActiveTime((Date) TypeParser.fromCSVFile(Date.class, list.get(6)));
    this.setStageTime((Date) TypeParser.fromCSVFile(Date.class, list.get(7)));
    this.setType((Integer) TypeParser.fromCSVFile(Integer.class, list.get(8)));
    this.setReason((Integer) TypeParser.fromCSVFile(Integer.class, list.get(9)));
    this.setPriority((Integer) TypeParser.fromCSVFile(Integer.class, list.get(10)));
    this.setTxFlag((Integer) TypeParser.fromCSVFile(Integer.class, list.get(11)));
    this.setGroupInfo((Integer) TypeParser.fromCSVFile(Integer.class, list.get(12)));
    this.setStage((Integer) TypeParser.fromCSVFile(Integer.class, list.get(13)));
    this.setContainerId(list.get(14));
    this.setCategory(list.get(15));
    this.setAisle((Integer) TypeParser.fromCSVFile(Integer.class, list.get(16)));
    this.setHandler((Integer) TypeParser.fromCSVFile(Integer.class, list.get(17)));
    this.setOrigPriority((Integer) TypeParser.fromCSVFile(Integer.class, list.get(18)));
    this.setMission((Integer) TypeParser.fromCSVFile(Integer.class, list.get(19)));
    this.setWave((Integer) TypeParser.fromCSVFile(Integer.class, list.get(20)));
    this.setLoadInfo((Integer) TypeParser.fromCSVFile(Integer.class, list.get(21)));
    this.setLoadPart((Integer) TypeParser.fromCSVFile(Integer.class, list.get(22)));
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

  @Column(name = "origSource", length = 50)
  public String getOrigSource() {
    return origSource;
  }

  public void setOrigSource(String origSource) {
    this.origSource = origSource;
  }

  @Column(name = "finalSource", length = 50)
  public String getFinalSource() {
    return finalSource;
  }

  public void setFinalSource(String finalSource) {
    this.finalSource = finalSource;
  }

  @Column(name = "destination", length = 50)
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  @Column(name = "finalDest", length = 50)
  public String getFinalDest() {
    return finalDest;
  }

  public void setFinalDest(String finalDest) {
    this.finalDest = finalDest;
  }

  @Column(name = "mhe", length = 50)
  public String getMhe() {
    return mhe;
  }

  public void setMhe(String mhe) {
    this.mhe = mhe;
  }

  @Column(name = "createTime")
  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Column(name = "activeTime")
  public Date getActiveTime() {
    return activeTime;
  }

  public void setActiveTime(Date activeTime) {
    this.activeTime = activeTime;
  }

  @Column(name = "stageTime")
  public Date getStageTime() {
    return stageTime;
  }

  public void setStageTime(Date stageTime) {
    this.stageTime = stageTime;
  }

  @Column(name = "type")
  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  @Column(name = "reason")
  public Integer getReason() {
    return reason;
  }

  public void setReason(Integer reason) {
    this.reason = reason;
  }

  @Column(name = "priority")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  @Column(name = "txFlag")
  public Integer getTxFlag() {
    return txFlag;
  }

  public void setTxFlag(Integer txFlag) {
    this.txFlag = txFlag;
  }

  @Column(name = "groupInfo")
  public Integer getGroupInfo() {
    return groupInfo;
  }

  public void setGroupInfo(Integer groupInfo) {
    this.groupInfo = groupInfo;
  }

  @Column(name = "stage")
  public Integer getStage() {
    return stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  @Column(name = "containerId", length = 50)
  public String getContainerId() {
    return containerId;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }

  @Column(name = "category", length = 50)
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Column(name = "aisle")
  public Integer getAisle() {
    return aisle;
  }

  public void setAisle(Integer aisle) {
    this.aisle = aisle;
  }

  @Column(name = "handler")
  public Integer getHandler() {
    return handler;
  }

  public void setHandler(Integer handler) {
    this.handler = handler;
  }

  @Column(name = "origPriority")
  public Integer getOrigPriority() {
    return origPriority;
  }

  public void setOrigPriority(Integer origPriority) {
    this.origPriority = origPriority;
  }

  @Column(name = "mission")
  public Integer getMission() {
    return mission;
  }

  public void setMission(Integer mission) {
    this.mission = mission;
  }

  @Column(name = "wave")
  public Integer getWave() {
    return wave;
  }

  public void setWave(Integer wave) {
    this.wave = wave;
  }

  @Column(name = "loadInfo")
  public Integer getLoadInfo() {
    return loadInfo;
  }

  public void setLoadInfo(Integer loadInfo) {
    this.loadInfo = loadInfo;
  }

  @Column(name = "loadPart")
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
        ", finalSource='" + finalSource + '\'' +
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
        ", groupInfo=" + groupInfo +
        ", stage=" + stage +
        ", containerId='" + containerId + '\'' +
        ", category='" + category + '\'' +
        ", aisle=" + aisle +
        ", handler=" + handler +
        ", origPriority=" + origPriority +
        ", mission=" + mission +
        ", wave=" + wave +
        ", loadInfo=" + loadInfo +
        ", loadPart=" + loadPart +
        '}';
  }
}

