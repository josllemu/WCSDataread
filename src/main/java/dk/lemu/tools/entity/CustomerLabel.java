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
    @NamedQuery(name = "CustomerLabel.findByShippingCode", query = "SELECT object(o) FROM CustomerLabel o WHERE o.shippingCode = :shipping_Code")
})
@Entity
@Table(name = "CustomerLabel",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "shippingCode"),
        @Index(columnList = "id, shippingCode")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CustomerLabel extends AbstractEntity implements Serializable {

  private Long id;
  private Integer seq; //0
  private String carrier; //1
  private String name1; //2
  private String name2; //3
  private String address; //4
  private String zipTown; //5
  private Integer packageNo; //6
  private Double weight; //7
  private String route; //8
  private String salesCompanyID; //9
  private String orderType; //10
  private String zipCodeArea; //11
  private String salesOrderNum; //12
  private String orderNumber; //13
  private Date packDate; //14
  private String despatchRemarks; //15
  private String remarks; //16
  private String cODText; //17
  private String shippingCode; //18
  private String shippingCodeText; //19

  private Date dbDate = new Date();

  public CustomerLabel() {

  }

  public CustomerLabel(List<String> list) throws Exception {

    this.setSeq((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setCarrier(list.get(1));
    this.setName1(list.get(2));
    this.setName2(list.get(3));
    this.setAddress(list.get(4));
    this.setZipTown(list.get(5));
    this.setPackageNo((Integer) TypeParser.fromCSVFile(Integer.class, list.get(6)));
    this.setWeight((Double) TypeParser.fromCSVFile(Double.class, list.get(7)));
    this.setRoute(list.get(8));
    this.setSalesCompanyID(list.get(9));
    this.setOrderType(list.get(10));
    this.setZipCodeArea(list.get(11));
    this.setSalesOrderNum(list.get(12));
    this.setOrderNumber(list.get(13));
    this.setPackDate((Date) TypeParser.fromCSVFile(Date.class, list.get(14)));
    this.setDespatchRemarks(list.get(15));
    this.setRemarks(list.get(16));
    this.setcODText(list.get(17));
    this.setShippingCode(list.get(18));
    this.setShippingCodeText(list.get(19));
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

  @Column(name = "seq")
  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  @Column(name = "carrier", length = 50)
  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  @Column(name = "name1", length = 50)
  public String getName1() {
    return name1;
  }

  public void setName1(String name1) {
    this.name1 = name1;
  }

  @Column(name = "name2", length = 50)
  public String getName2() {
    return name2;
  }

  public void setName2(String name2) {
    this.name2 = name2;
  }

  @Column(name = "address", length = 50)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Column(name = "zipTown", length = 50)
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

  @Column(name = "route", length = 5)
  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  @Column(name = "salesCompanyID", length = 50)
  public String getSalesCompanyID() {
    return salesCompanyID;
  }

  public void setSalesCompanyID(String salesCompanyID) {
    this.salesCompanyID = salesCompanyID;
  }

  @Column(name = "orderType", length = 50)
  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  @Column(name = "zipCodeArea", length = 10)
  public String getZipCodeArea() {
    return zipCodeArea;
  }

  public void setZipCodeArea(String zipCodeArea) {
    this.zipCodeArea = zipCodeArea;
  }

  @Column(name = "salesOrderNum", length = 50)
  public String getSalesOrderNum() {
    return salesOrderNum;
  }

  public void setSalesOrderNum(String salesOrderNum) {
    this.salesOrderNum = salesOrderNum;
  }

  @Column(name = "orderNumber", length = 50)
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

  @Column(name = "despatchRemarks", length = 50)
  public String getDespatchRemarks() {
    return despatchRemarks;
  }

  public void setDespatchRemarks(String despatchRemarks) {
    this.despatchRemarks = despatchRemarks;
  }

  @Column(name = "remarks", length = 50)
  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  @Column(name = "cODText", length = 50)
  public String getcODText() {
    return cODText;
  }

  public void setcODText(String cODText) {
    this.cODText = cODText;
  }

  @Column(name = "shippingCode", unique = true, nullable = false, length = 50)
  public String getShippingCode() {
    return shippingCode;
  }

  public void setShippingCode(String shippingCode) {
    this.shippingCode = shippingCode;
  }

  @Column(name = "shippingCodeText", length = 50)
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

