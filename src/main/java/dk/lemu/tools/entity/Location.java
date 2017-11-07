package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "Location.findByLocation",
        query = "SELECT object(lc) FROM Location lc " +
            "WHERE lc.location = :locationId")
})
@Entity
@Table(name = "Location",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, location"),
        @Index(columnList = "id, location, type")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Location extends AbstractContainer implements Serializable {


  private String location; //0
  private Date errorTime; //1
  private Date auditTime; //2
  private Double x; //3
  private Double y; //4
  private Double z; //5
  private Double height; //6
  private Double weight; //7
  private String errorStatus; //8
  private String type; //9
  private String status; //10
  private String auditStatus; //11
  private String picking; //12
  private String checkDigits; //13
  private String fullStatus; //14
  private Double width = 0.0; //15
  private Double depth = 0.0; //16
  private String piChecked = "."; //17
  private String posnChecked = "."; //18


  private Integer locType = AbstractContainer.TYPE_LOCATION;

  public Location() {
  }

  public Location(List<String> list) {
    this.setLocation(list.get(0));
    this.setErrorTime((Date) TypeParser.fromCSVFile(Date.class, list.get(1)));
    this.setAuditTime((Date) TypeParser.fromCSVFile(Date.class, list.get(2)));
    this.setX((Double) TypeParser.fromCSVFile(Double.class, list.get(3)));
    this.setY((Double) TypeParser.fromCSVFile(Double.class, list.get(4)));
    this.setZ((Double) TypeParser.fromCSVFile(Double.class, list.get(5)));
    this.setHeight((Double) TypeParser.fromCSVFile(Double.class, list.get(6)));
    this.setWeight((Double) TypeParser.fromCSVFile(Double.class, list.get(7)));
    this.setErrorStatus(list.get(8));
    this.setType(list.get(9));
    this.setStatus(list.get(10));
    this.setAuditStatus(list.get(11));
    this.setPicking(list.get(12));
    this.setCheckDigits(list.get(13));
    this.setFullStatus(list.get(14));
    this.setWidth((Double) TypeParser.fromCSVFile(Double.class, list.get(15)));
    this.setDepth((Double) TypeParser.fromCSVFile(Double.class, list.get(16)));
    this.setPiChecked(list.get(17));
    this.setPosnChecked(list.get(18));

  }

  @Override
  @Column(name = "locType", nullable = false)
  public Integer getLocType() {
    return locType;
  }

  @Column(name = "location", nullable = false, unique = true, length = 50)
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Column(name = "errorTime")
  public Date getErrorTime() {
    return errorTime;
  }

  public void setErrorTime(Date errorTime) {
    this.errorTime = errorTime;
  }

  @Column(name = "auditTime")
  public Date getAuditTime() {
    return auditTime;
  }

  public void setAuditTime(Date auditTime) {
    this.auditTime = auditTime;
  }

  @Column(name = "x")
  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  @Column(name = "y")
  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }

  @Column(name = "z")
  public Double getZ() {
    return z;
  }

  public void setZ(Double z) {
    this.z = z;
  }

  @Column(name = "height")
  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  @Column(name = "weight")
  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  @Column(name = "errorStatus", length = 5)
  public String getErrorStatus() {
    return errorStatus;
  }

  public void setErrorStatus(String errorStatus) {
    this.errorStatus = errorStatus;
  }

  @Column(name = "type", length = 5)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Column(name = "status", length = 5)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Column(name = "auditStatus", length = 5)
  public String getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(String auditStatus) {
    this.auditStatus = auditStatus;
  }

  @Column(name = "picking", length = 5)
  public String getPicking() {
    return picking;
  }

  public void setPicking(String picking) {
    this.picking = picking;
  }

  @Column(name = "checkDigits", length = 5)
  public String getCheckDigits() {
    return checkDigits;
  }

  public void setCheckDigits(String checkDigits) {
    this.checkDigits = checkDigits;
  }

  @Column(name = "fullStatus", length = 5)
  public String getFullStatus() {
    return fullStatus;
  }

  public void setFullStatus(String fullStatus) {
    this.fullStatus = fullStatus;
  }

  @Column(name = "width")
  public Double getWidth() {
    return width;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  @Column(name = "depth")
  public Double getDepth() {
    return depth;
  }

  public void setDepth(Double depth) {
    this.depth = depth;
  }

  @Column(name = "piChecked", length = 5)
  public String getPiChecked() {
    return piChecked;
  }

  public void setPiChecked(String piChecked) {
    this.piChecked = piChecked;
  }

  @Column(name = "posnChecked", length = 5)
  public String getPosnChecked() {
    return posnChecked;
  }

  public void setPosnChecked(String posnChecked) {
    this.posnChecked = posnChecked;
  }

  @Override
  public void setLocType(Integer locType) {
    this.locType = locType;
  }

  @Override
  public String toString() {
    return "Location{" +
        "location='" + location + '\'' +
        ", errorTime=" + errorTime +
        ", auditTime=" + auditTime +
        ", x=" + x +
        ", y=" + y +
        ", z=" + z +
        ", height=" + height +
        ", weight=" + weight +
        ", errorStatus='" + errorStatus + '\'' +
        ", type='" + type + '\'' +
        ", status='" + status + '\'' +
        ", auditStatus='" + auditStatus + '\'' +
        ", picking='" + picking + '\'' +
        ", checkDigits='" + checkDigits + '\'' +
        ", fullStatus='" + fullStatus + '\'' +
        ", width=" + width +
        ", depth=" + depth +
        ", piChecked='" + piChecked + '\'' +
        ", posnChecked='" + posnChecked + '\'' +
        ", locType=" + locType +
        '}';
  }
}
