package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "StockSpread",
    indexes = {
        @Index(columnList = "id")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StockSpread extends AbstractEntity implements Serializable {

  private Long id;
  private Integer zone; //0
  private Integer aisle; //1
  private Double quantity; //2
  private Date rotationDate; //3
  private String clientCode; //4
  private String itemCode; //5
  private Date dbDate = new Date();


  public StockSpread() {

  }

  public StockSpread(List<String> list) throws Exception {
    this.setZone((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setAisle((Integer) TypeParser.fromCSVFile(Integer.class, list.get(1)));
    this.setQuantity((Double) TypeParser.fromCSVFile(Double.class, list.get(2)));
    this.setRotationDate((Date) TypeParser.fromCSVFile(Date.class, list.get(3)));
    this.setClientCode((String) TypeParser.fromCSVFile(String.class, list.get(4)));
    this.setItemCode((String) TypeParser.fromCSVFile(String.class, list.get(5)));

    this.setDbDate(new Date());


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

  @Column(name = "zone")
  public Integer getZone() {
    return zone;
  }

  public void setZone(Integer zone) {
    this.zone = zone;
  }

  @Column(name = "aisle")
  public Integer getAisle() {
    return aisle;
  }

  public void setAisle(Integer aisle) {
    this.aisle = aisle;
  }

  @Column(name = "quantity")
  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  @Column(name = "rotationDate")
  public Date getRotationDate() {
    return rotationDate;
  }

  public void setRotationDate(Date rotationDate) {
    this.rotationDate = rotationDate;
  }

  @Column(name = "clientCode")
  public String getClientCode() {
    return clientCode;
  }

  public void setClientCode(String clientCode) {
    this.clientCode = clientCode;
  }

  @Column(name = "itemCode")
  public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
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
    return "StockSpread{" +
        "id=" + id +
        ", zone=" + zone +
        ", aisle=" + aisle +
        ", quantity=" + quantity +
        ", rotationDate=" + rotationDate +
        ", clientCode='" + clientCode + '\'' +
        ", itemCode='" + itemCode + '\'' +
        ", dbDate=" + dbDate +
        '}';
  }
}

