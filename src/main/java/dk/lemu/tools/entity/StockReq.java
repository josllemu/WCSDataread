package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "StockReq.findByAllocRef", query = "SELECT object(o) FROM StockReq o WHERE o.allocRef = :allocRef")
})
@Entity
@Table(name = "StockReq",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "allocRef"),
        @Index(columnList = "id, allocRef")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StockReq extends AbstractEntity implements Serializable {

  private Long id;
  private Integer stage; //0
  private Integer allocRef; //1
  private Date requestDate; //2
  private Integer allocQty; //3
  private Integer reqdQty; //4
  private Date minRotationDate; //5
  private Date maxRotationDate; //6
  private Integer dateNum; //7
  private Integer loadRef; //8
  private Integer loadPart; //9
  private Integer pickGroup; //10
  private Integer wave; //11
  private Integer priority; //12
  private Integer rotatePriority; //13
  private Integer zonePriority; //14
  private Integer statusPriority; //15
  private Integer preferZone1; //16
  private Integer preferZone2; //17
  private Integer preferZone3; //18
  private Integer preferZone4; //19
  private Integer preferZone5; //20
  private Integer maxBatches; //21
  private Double heightRestrict; //22
  private Double weightRestrict; //23
  private String type; //24
  private String requiredStatus; //25
  private String allowedStatus; //26
  private String preferStatus; //27
  private String lessPreferStatus; //28
  private Date dbDate = new Date();


  public StockReq() {

  }

  public StockReq(List<String> list) throws Exception {


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

  @Column(name = "stage")
  public Integer getStage() {
    return stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  @Column(name = "allocRef", unique = true, nullable = false)
  public Integer getAllocRef() {
    return allocRef;
  }

  public void setAllocRef(Integer allocRef) {
    this.allocRef = allocRef;
  }

  @Column(name = "requestDate")
  public Date getRequestDate() {
    return requestDate;
  }

  public void setRequestDate(Date requestDate) {
    this.requestDate = requestDate;
  }

  @Column(name = "allocQty")
  public Integer getAllocQty() {
    return allocQty;
  }

  public void setAllocQty(Integer allocQty) {
    this.allocQty = allocQty;
  }

  @Column(name = "reqdQty")
  public Integer getReqdQty() {
    return reqdQty;
  }

  public void setReqdQty(Integer reqdQty) {
    this.reqdQty = reqdQty;
  }

  @Column(name = "minRotationDate")
  public Date getMinRotationDate() {
    return minRotationDate;
  }

  public void setMinRotationDate(Date minRotationDate) {
    this.minRotationDate = minRotationDate;
  }

  @Column(name = "maxRotationDate")
  public Date getMaxRotationDate() {
    return maxRotationDate;
  }

  public void setMaxRotationDate(Date maxRotationDate) {
    this.maxRotationDate = maxRotationDate;
  }

  @Column(name = "dateNum")
  public Integer getDateNum() {
    return dateNum;
  }

  public void setDateNum(Integer dateNum) {
    this.dateNum = dateNum;
  }

  @Column(name = "loadRef")
  public Integer getLoadRef() {
    return loadRef;
  }

  public void setLoadRef(Integer loadRef) {
    this.loadRef = loadRef;
  }

  @Column(name = "loadPart")
  public Integer getLoadPart() {
    return loadPart;
  }

  public void setLoadPart(Integer loadPart) {
    this.loadPart = loadPart;
  }

  @Column(name = "pickGroup")
  public Integer getPickGroup() {
    return pickGroup;
  }

  public void setPickGroup(Integer pickGroup) {
    this.pickGroup = pickGroup;
  }

  @Column(name = "wave")
  public Integer getWave() {
    return wave;
  }

  public void setWave(Integer wave) {
    this.wave = wave;
  }

  @Column(name = "priority")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  @Column(name = "rotatePriority")
  public Integer getRotatePriority() {
    return rotatePriority;
  }

  public void setRotatePriority(Integer rotatePriority) {
    this.rotatePriority = rotatePriority;
  }

  @Column(name = "zonePriority")
  public Integer getZonePriority() {
    return zonePriority;
  }

  public void setZonePriority(Integer zonePriority) {
    this.zonePriority = zonePriority;
  }

  @Column(name = "statusPriority")
  public Integer getStatusPriority() {
    return statusPriority;
  }

  public void setStatusPriority(Integer statusPriority) {
    this.statusPriority = statusPriority;
  }

  @Column(name = "preferZone1")
  public Integer getPreferZone1() {
    return preferZone1;
  }

  public void setPreferZone1(Integer preferZone1) {
    this.preferZone1 = preferZone1;
  }

  @Column(name = "preferZone2")
  public Integer getPreferZone2() {
    return preferZone2;
  }

  public void setPreferZone2(Integer preferZone2) {
    this.preferZone2 = preferZone2;
  }

  @Column(name = "preferZone3")
  public Integer getPreferZone3() {
    return preferZone3;
  }

  public void setPreferZone3(Integer preferZone3) {
    this.preferZone3 = preferZone3;
  }

  @Column(name = "preferZone4")
  public Integer getPreferZone4() {
    return preferZone4;
  }

  public void setPreferZone4(Integer preferZone4) {
    this.preferZone4 = preferZone4;
  }

  @Column(name = "preferZone5")
  public Integer getPreferZone5() {
    return preferZone5;
  }

  public void setPreferZone5(Integer preferZone5) {
    this.preferZone5 = preferZone5;
  }

  @Column(name = "maxBatches")
  public Integer getMaxBatches() {
    return maxBatches;
  }

  public void setMaxBatches(Integer maxBatches) {
    this.maxBatches = maxBatches;
  }

  @Column(name = "heightRestrict")
  public Double getHeightRestrict() {
    return heightRestrict;
  }

  public void setHeightRestrict(Double heightRestrict) {
    this.heightRestrict = heightRestrict;
  }

  @Column(name = "weightRestrict")
  public Double getWeightRestrict() {
    return weightRestrict;
  }

  public void setWeightRestrict(Double weightRestrict) {
    this.weightRestrict = weightRestrict;
  }

  @Column(name = "type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Column(name = "requiredStatus")
  public String getRequiredStatus() {
    return requiredStatus;
  }

  public void setRequiredStatus(String requiredStatus) {
    this.requiredStatus = requiredStatus;
  }

  @Column(name = "allowedStatus")
  public String getAllowedStatus() {
    return allowedStatus;
  }

  public void setAllowedStatus(String allowedStatus) {
    this.allowedStatus = allowedStatus;
  }

  @Column(name = "preferStatus")
  public String getPreferStatus() {
    return preferStatus;
  }

  public void setPreferStatus(String preferStatus) {
    this.preferStatus = preferStatus;
  }

  @Column(name = "lessPreferStatus")
  public String getLessPreferStatus() {
    return lessPreferStatus;
  }

  public void setLessPreferStatus(String lessPreferStatus) {
    this.lessPreferStatus = lessPreferStatus;
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
    return "StockReq{" +
        "id=" + id +
        ", stage=" + stage +
        ", allocRef=" + allocRef +
        ", requestDate=" + requestDate +
        ", allocQty=" + allocQty +
        ", reqdQty=" + reqdQty +
        ", minRotationDate=" + minRotationDate +
        ", maxRotationDate=" + maxRotationDate +
        ", dateNum=" + dateNum +
        ", loadRef=" + loadRef +
        ", loadPart=" + loadPart +
        ", pickGroup=" + pickGroup +
        ", wave=" + wave +
        ", priority=" + priority +
        ", rotatePriority=" + rotatePriority +
        ", zonePriority=" + zonePriority +
        ", statusPriority=" + statusPriority +
        ", preferZone1=" + preferZone1 +
        ", preferZone2=" + preferZone2 +
        ", preferZone3=" + preferZone3 +
        ", preferZone4=" + preferZone4 +
        ", preferZone5=" + preferZone5 +
        ", maxBatches=" + maxBatches +
        ", heightRestrict=" + heightRestrict +
        ", weightRestrict=" + weightRestrict +
        ", type='" + type + '\'' +
        ", requiredStatus='" + requiredStatus + '\'' +
        ", allowedStatus='" + allowedStatus + '\'' +
        ", preferStatus='" + preferStatus + '\'' +
        ", lessPreferStatus='" + lessPreferStatus + '\'' +
        ", dbDate=" + dbDate +
        '}';
  }
}

