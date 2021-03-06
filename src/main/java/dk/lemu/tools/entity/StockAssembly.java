package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
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
  private String orderNumber; //1
  private Boolean nullable; //2
  private Integer zone; //3
  private String place; //4
  private String location; //5
  private String parmC; //6
  private Integer parm0; //7


  public StockAssembly() {

  }

  public StockAssembly(List<String> list) throws Exception {
    this.setStd((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setOrderNumber((String) TypeParser.fromCSVFile(String.class, list.get(1)));
    this.setNullable((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(2)));
    this.setZone((Integer) TypeParser.fromCSVFile(Integer.class, list.get(3)));
    this.setPlace((String) TypeParser.fromCSVFile(String.class, list.get(4)));
    this.setLocation((String) TypeParser.fromCSVFile(String.class, list.get(5)));
    this.setParmC((String) TypeParser.fromCSVFile(String.class, list.get(6)));
    this.setParm0((Integer) TypeParser.fromCSVFile(Integer.class, list.get(7)));

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
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
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

  @Column(name = "place", length = 20)
  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  @Column(name = "location", length = 15)
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Column(name = "parmC", length = 5)
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

