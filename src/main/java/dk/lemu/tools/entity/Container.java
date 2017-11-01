package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "Container.findByContainer",
        query = "SELECT object(c) FROM Container c " +
            "WHERE c.container = :containerId")
})
@Entity
@Table(name = "Container", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "container")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, container")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Container extends AbstractContainer implements Serializable {

  private String location; //0
  private Date storageTime; //1
  private Date audit_date; //2
  private String auditRef; //3
  private Double weight; //4
  private Double height; //5
  private String weightStatus; //6
  private String heightStatus; //7
  private String container; //8
  private String type; //9
  private String holdingContainer; //10
  private Boolean auditStatus; //11
  private Boolean wrapped; //12
  private Boolean labelled; //13
  private String lastUserMoved; //14
  private Boolean picked; //15
  private Integer Temperature; //16
  private Integer profileStatus = 0; //17
  private Integer containerStatus = 0; //18
  private Date lastAllokationTime; //19
  private String fullStatus; //20
  private String orientation; //21
  private String bitMap; //22
  private String pickGroup; //23
  private Long relocate; //24
  private Double width = 0.0; //25
  private Double length = 0.0; //26
  private Date dbDate = new Date();

  private Integer locType = AbstractContainer.TYPE_CONTAINER;

  public Container() {

  }

  public Container(List<String> list) throws Exception {

    this.setLocation(list.get(0));
    this.setStorageTime((Date) TypeParser.fromCSVFile(Date.class, list.get(1)));
    this.setAudit_date((Date) TypeParser.fromCSVFile(Date.class, list.get(2)));
    this.setAuditRef(list.get(3));
    this.setWeight((Double) TypeParser.fromCSVFile(Double.class, list.get(4)));
    this.setHeight((Double) TypeParser.fromCSVFile(Double.class, list.get(5)));
    this.setWeightStatus(list.get(6));
    this.setHeightStatus(list.get(7));
    this.setContainer(list.get(8));
    this.setType(list.get(9));
    this.setHoldingContainer(list.get(10));
    this.setAuditStatus((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(11)));
    this.setWrapped((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(12)));
    this.setLabelled((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(13)));
    this.setLastUserMoved(list.get(14));
    this.setPicked((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(15)));
    this.setTemperature((Integer) TypeParser.fromCSVFile(Integer.class, list.get(16)));
    this.setProfileStatus((Integer) TypeParser.fromCSVFile(Integer.class, list.get(17)));
    this.setContainerStatus((Integer) TypeParser.fromCSVFile(Integer.class, list.get(18)));
    this.setLastAllokationTime((Date) TypeParser.fromCSVFile(Date.class, list.get(19)));
    this.setFullStatus(list.get(20));
    this.setOrientation(list.get(21));
    this.setBitMap(list.get(22));
    this.setPickGroup(list.get(23));
    this.setRelocate((Long) TypeParser.fromCSVFile(Long.class, list.get(24)));
    this.setWidth((Double) TypeParser.fromCSVFile(Double.class, list.get(25)));
    this.setLength((Double) TypeParser.fromCSVFile(Double.class, list.get(26)));
    this.setDbDate(new Date());

  }


  @Override
  @Column(name = "locType", nullable = false)
  public Integer getLocType() {
    return locType;
  }

  @Column(name = "container", nullable = false, unique = true)
  public String getContainer() {
    return container;
  }

  public void setContainer(String container) {
    this.container = container;
  }

  @Column(name = "weight")
  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  @Column(name = "height")
  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  @Column(name = "location")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Column(name = "storagetime")
  public Date getStorageTime() {
    return storageTime;
  }

  public void setStorageTime(Date storageTime) {
    this.storageTime = storageTime;
  }

  @Column(name = "auditRef")
  public String getAuditRef() {
    return auditRef;
  }

  public void setAuditRef(String auditRef) {
    this.auditRef = auditRef;
  }

  @Column(name = "audit_date")
  public Date getAudit_date() {
    return audit_date;
  }

  public void setAudit_date(Date audit_date) {
    this.audit_date = audit_date;
  }

  @Column(name = "weightStatus")
  public String getWeightStatus() {
    return weightStatus;
  }

  public void setWeightStatus(String weightStatus) {
    this.weightStatus = weightStatus;
  }

  @Column(name = "heightStatus")
  public String getHeightStatus() {
    return heightStatus;
  }

  public void setHeightStatus(String heightStatus) {
    this.heightStatus = heightStatus;
  }

  @Column(name = "holdingContainer")
  public String getHoldingContainer() {
    return holdingContainer;
  }

  public void setHoldingContainer(String holdingContainer) {
    this.holdingContainer = holdingContainer;
  }

  @Column(name = "auditStatus")
  public Boolean getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(Boolean auditStatus) {
    this.auditStatus = auditStatus;
  }

  @Column(name = "wrapped")
  public Boolean getWrapped() {
    return wrapped;
  }

  public void setWrapped(Boolean wrapped) {
    this.wrapped = wrapped;
  }

  @Column(name = "labelled")
  public Boolean getLabelled() {
    return labelled;
  }

  public void setLabelled(Boolean labelled) {
    this.labelled = labelled;
  }

  @Column(name = "lastUserMoved")
  public String getLastUserMoved() {
    return lastUserMoved;
  }

  public void setLastUserMoved(String lastUserMoved) {
    this.lastUserMoved = lastUserMoved;
  }

  @Column(name = "picked")
  public Boolean getPicked() {
    return picked;
  }

  public void setPicked(Boolean picked) {
    this.picked = picked;
  }

  @Column(name = "Temperature")
  public Integer getTemperature() {
    return Temperature;
  }

  public void setTemperature(Integer temperature) {
    Temperature = temperature;
  }

  @Column(name = "profileStatus")
  public Integer getProfileStatus() {
    return profileStatus;
  }

  public void setProfileStatus(Integer profileStatus) {
    this.profileStatus = profileStatus;
  }

  @Column(name = "containerStatus")
  public Integer getContainerStatus() {
    return containerStatus;
  }

  public void setContainerStatus(Integer containerStatus) {
    this.containerStatus = containerStatus;
  }

  @Column(name = "lastAllokationTime")
  public Date getLastAllokationTime() {
    return lastAllokationTime;
  }

  public void setLastAllokationTime(Date lastAllokationTime) {
    this.lastAllokationTime = lastAllokationTime;
  }

  @Column(name = "fullStatus")
  public String getFullStatus() {
    return fullStatus;
  }

  public void setFullStatus(String fullStatus) {
    this.fullStatus = fullStatus;
  }

  @Column(name = "orientation")
  public String getOrientation() {
    return orientation;
  }

  public void setOrientation(String orientation) {
    this.orientation = orientation;
  }

  @Column(name = "bitMap")
  public String getBitMap() {
    return bitMap;
  }

  public void setBitMap(String bitMap) {
    this.bitMap = bitMap;
  }

  @Column(name = "pickGroup")
  public String getPickGroup() {
    return pickGroup;
  }

  public void setPickGroup(String pickGroup) {
    this.pickGroup = pickGroup;
  }

  @Column(name = "relocate")
  public Long getRelocate() {
    return relocate;
  }

  public void setRelocate(Long relocate) {
    this.relocate = relocate;
  }

  @Column(name = "width")
  public Double getWidth() {
    return width;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  public void setLength(Double length) {
    this.length = length;
  }

  @Column(name = "length")
  public Double getLength() {
    return length;
  }

  @Column(name = "type", nullable = false)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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
    return "Container{" +
        "location='" + location + '\'' +
        ", storageTime=" + storageTime +
        ", audit_date=" + audit_date +
        ", auditRef='" + auditRef + '\'' +
        ", weight=" + weight +
        ", height=" + height +
        ", weightStatus='" + weightStatus + '\'' +
        ", heightStatus='" + heightStatus + '\'' +
        ", container='" + container + '\'' +
        ", type='" + type + '\'' +
        ", holdingContainer='" + holdingContainer + '\'' +
        ", auditStatus=" + auditStatus +
        ", wrapped=" + wrapped +
        ", labelled=" + labelled +
        ", lastUserMoved='" + lastUserMoved + '\'' +
        ", picked=" + picked +
        ", Temperature=" + Temperature +
        ", profileStatus=" + profileStatus +
        ", containerStatus=" + containerStatus +
        ", lastAllokationTime=" + lastAllokationTime +
        ", fullStatus='" + fullStatus + '\'' +
        ", orientation='" + orientation + '\'' +
        ", bitMap='" + bitMap + '\'' +
        ", pickGroup='" + pickGroup + '\'' +
        ", relocate=" + relocate +
        ", width=" + width +
        ", length=" + length +
        ", dbDate=" + dbDate +
        ", locType=" + locType +
        '}';
  }

}
