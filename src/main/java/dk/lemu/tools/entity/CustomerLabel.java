package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "CustomerLabel.findByShippingCode", query = "SELECT object(o) FROM CustomerLabel o WHERE o.shippingCode = :shipping_Code")
})
@Entity
@Table(name = "CustomerLabel", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "shippingCode")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "shippingCode"),
        @Index(columnList = "id, shippingCode")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CustomerLabel extends AbstractEntity implements Serializable {

  private Long id;
  private Integer seq;
  private String carrier;
  private String name1;
  private String name2;
  private String address;
  private String zipTown;
  private Integer packageNo;
  private Double weight;
  private String route;
  private String salesCompanyID;
  private String orderType;
  private String zipCodeArea;
  private String salesOrderNum;
  private String orderNumber;
  private Date packDate;
  private String despatchRemarks;
  private String remarks;
  private String cODText;
  private String shippingCode;
  private String shippingCodeText;

  private Date dbDate = new Date();

  public CustomerLabel() {

  }

  public CustomerLabel(List<String> list) throws Exception {


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

  @Column(name = "seq")
  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  @Column(name = "carrier")
  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  @Column(name = "name1")
  public String getName1() {
    return name1;
  }

  public void setName1(String name1) {
    this.name1 = name1;
  }

  @Column(name = "name2")
  public String getName2() {
    return name2;
  }

  public void setName2(String name2) {
    this.name2 = name2;
  }

  @Column(name = "address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Column(name = "zipTown")
  public String getZipTown() {
    return zipTown;
  }

  public void setZipTown(String zipTown) {
    this.zipTown = zipTown;
  }

  @Column(name = "packageNo")
  public Integer getPackageNo() {
    return packageNo;
  }

  public void setPackageNo(Integer packageNo) {
    this.packageNo = packageNo;
  }

  @Column(name = "weight")
  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  @Column(name = "route")
  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  @Column(name = "salesCompanyID")
  public String getSalesCompanyID() {
    return salesCompanyID;
  }

  public void setSalesCompanyID(String salesCompanyID) {
    this.salesCompanyID = salesCompanyID;
  }

  @Column(name = "orderType")
  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  @Column(name = "zipCodeArea")
  public String getZipCodeArea() {
    return zipCodeArea;
  }

  public void setZipCodeArea(String zipCodeArea) {
    this.zipCodeArea = zipCodeArea;
  }

  @Column(name = "salesOrderNum")
  public String getSalesOrderNum() {
    return salesOrderNum;
  }

  public void setSalesOrderNum(String salesOrderNum) {
    this.salesOrderNum = salesOrderNum;
  }

  @Column(name = "orderNumber")
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Column(name = "packDate")
  public Date getPackDate() {
    return packDate;
  }

  public void setPackDate(Date packDate) {
    this.packDate = packDate;
  }

  @Column(name = "despatchRemarks")
  public String getDespatchRemarks() {
    return despatchRemarks;
  }

  public void setDespatchRemarks(String despatchRemarks) {
    this.despatchRemarks = despatchRemarks;
  }

  @Column(name = "remarks")
  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  @Column(name = "cODText")
  public String getcODText() {
    return cODText;
  }

  public void setcODText(String cODText) {
    this.cODText = cODText;
  }

  @Column(name = "shippingCode", unique = true, nullable = false)
  public String getShippingCode() {
    return shippingCode;
  }

  public void setShippingCode(String shippingCode) {
    this.shippingCode = shippingCode;
  }

  @Column(name = "shippingCodeText")
  public String getShippingCodeText() {
    return shippingCodeText;
  }

  public void setShippingCodeText(String shippingCodeText) {
    this.shippingCodeText = shippingCodeText;
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
    return "CustomerLabel{" +
        "id=" + id +
        ", seq=" + seq +
        ", carrier='" + carrier + '\'' +
        ", name1='" + name1 + '\'' +
        ", name2='" + name2 + '\'' +
        ", address='" + address + '\'' +
        ", zipTown='" + zipTown + '\'' +
        ", packageNo=" + packageNo +
        ", weight=" + weight +
        ", route='" + route + '\'' +
        ", salesCompanyID='" + salesCompanyID + '\'' +
        ", orderType='" + orderType + '\'' +
        ", zipCodeArea='" + zipCodeArea + '\'' +
        ", salesOrderNum='" + salesOrderNum + '\'' +
        ", orderNumber='" + orderNumber + '\'' +
        ", packDate=" + packDate +
        ", despatchRemarks='" + despatchRemarks + '\'' +
        ", remarks='" + remarks + '\'' +
        ", cODText='" + cODText + '\'' +
        ", shippingCode='" + shippingCode + '\'' +
        ", shippingCodeText='" + shippingCodeText + '\'' +
        ", dbDate=" + dbDate +
        '}';
  }
}

