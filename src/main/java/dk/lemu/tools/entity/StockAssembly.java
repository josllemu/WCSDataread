package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "StockAssembly.findByOrder", query = "SELECT object(o) FROM StockAssembly o WHERE o.orderNumber = :orderNumber")
})
@Entity
@Table(name = "StockAssembly",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "orderNumber"),
        @Index(columnList = "id, orderNumber")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StockAssembly extends AbstractEntity implements Serializable {

  private Long id;
  private Integer std; //0
  private Integer orderNumber; //1
  private Boolean nullable; //2
  private Integer zone; //3
  private String place; //4
  private String location; //5
  private String parmC; //6
  private Integer parm0; //7


  public StockAssembly() {

  }

  public StockAssembly(List<String> list) throws Exception {


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

  @Column(name = "getStd")
  public Integer getStd() {
    return std;
  }

  public void setStd(Integer std) {
    this.std = std;
  }

  @Column(name = "orderNumber", unique = true, nullable = false)
  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Column(name = "nullable")
  public Boolean getNullable() {
    return nullable;
  }

  public void setNullable(Boolean nullable) {
    this.nullable = nullable;
  }

  @Column(name = "zone")
  public Integer getZone() {
    return zone;
  }

  public void setZone(Integer zone) {
    this.zone = zone;
  }

  @Column(name = "place")
  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  @Column(name = "location")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Column(name = "parmC")
  public String getParmC() {
    return parmC;
  }

  public void setParmC(String parmC) {
    this.parmC = parmC;
  }

  @Column(name = "parm0")
  public Integer getParm0() {
    return parm0;
  }

  public void setParm0(Integer parm0) {
    this.parm0 = parm0;
  }

  @Override
  public String toString() {
    return "StockAssembly{" +
        "id=" + id +
        ", std=" + std +
        ", orderNumber=" + orderNumber +
        ", nullable=" + nullable +
        ", zone=" + zone +
        ", place='" + place + '\'' +
        ", location='" + location + '\'' +
        ", parmC='" + parmC + '\'' +
        ", parm0=" + parm0 +
        '}';
  }
}

