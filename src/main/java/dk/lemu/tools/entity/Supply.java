package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "Supply.findByOrder", query = "SELECT object(o) FROM Supply o WHERE o.orderId = :orderId")
})
@Entity
@Table(name = "Supply",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "orderId"),
        @Index(columnList = "id, orderId")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Supply extends AbstractEntity implements Serializable {

  private Long id;
  private String orderId; //0
  private String supplyType; //1
  private String salesOrderNumber; //2
  private String shippingType; //3
  private String pickType; //4
  private String carrier; //5
  private String salesCompanyID; //6
  private String deliveryInTotal; //7
  private String salesCompanyAddress; //8
  private String externalPartnerAddress; //9
  private String remark1; //10
  private String remark2; //11
  private String receiverName; //12
  private String receiverPhone; //13
  private String pickText; //14
  private String route; //15
  private String codText; //16
  private String distInfo1; //17
  private String distInfo2; //18
  private String zipCodeArea; //19


  public Supply() {

  }

  public Supply(List<String> list) throws Exception {
    this.setOrderId((String) TypeParser.fromCSVFile(String.class, list.get(0)));
    this.setSupplyType((String) TypeParser.fromCSVFile(String.class, list.get(1)));
    this.setSalesOrderNumber((String) TypeParser.fromCSVFile(String.class, list.get(2)));
    this.setShippingType((String) TypeParser.fromCSVFile(String.class, list.get(3)));
    this.setPickType((String) TypeParser.fromCSVFile(String.class, list.get(4)));
    this.setCarrier((String) TypeParser.fromCSVFile(String.class, list.get(5)));
    this.setSalesCompanyID((String) TypeParser.fromCSVFile(String.class, list.get(6)));
    this.setDeliveryInTotal((String) TypeParser.fromCSVFile(String.class, list.get(7)));
    this.setSalesCompanyAddress((String) TypeParser.fromCSVFile(String.class, list.get(8)));
    this.setExternalPartnerAddress((String) TypeParser.fromCSVFile(String.class, list.get(9)));
    this.setRemark1((String) TypeParser.fromCSVFile(String.class, list.get(10)));
    this.setRemark2((String) TypeParser.fromCSVFile(String.class, list.get(11)));
    this.setReceiverName((String) TypeParser.fromCSVFile(String.class, list.get(12)));
    this.setReceiverPhone((String) TypeParser.fromCSVFile(String.class, list.get(13)));
    this.setPickText((String) TypeParser.fromCSVFile(String.class, list.get(14)));
    this.setRoute((String) TypeParser.fromCSVFile(String.class, list.get(15)));
    this.setCodText((String) TypeParser.fromCSVFile(String.class, list.get(16)));
    this.setDistInfo1((String) TypeParser.fromCSVFile(String.class, list.get(17)));
    this.setDistInfo2((String) TypeParser.fromCSVFile(String.class, list.get(18)));
    this.setZipCodeArea((String) TypeParser.fromCSVFile(String.class, list.get(19)));


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

  @Column(name = "orderId", unique = true, nullable = false)
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  @Column(name = "supplyType")
  public String getSupplyType() {
    return supplyType;
  }

  public void setSupplyType(String supplyType) {
    this.supplyType = supplyType;
  }

  @Column(name = "salesOrderNumber")
  public String getSalesOrderNumber() {
    return salesOrderNumber;
  }

  public void setSalesOrderNumber(String salesOrderNumber) {
    this.salesOrderNumber = salesOrderNumber;
  }

  @Column(name = "shippingType")
  public String getShippingType() {
    return shippingType;
  }

  public void setShippingType(String shippingType) {
    this.shippingType = shippingType;
  }

  @Column(name = "pickType")
  public String getPickType() {
    return pickType;
  }

  public void setPickType(String pickType) {
    this.pickType = pickType;
  }

  @Column(name = "carrier")
  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  @Column(name = "salesCompanyID")
  public String getSalesCompanyID() {
    return salesCompanyID;
  }

  public void setSalesCompanyID(String salesCompanyID) {
    this.salesCompanyID = salesCompanyID;
  }

  @Column(name = "deliveryInTotal")
  public String getDeliveryInTotal() {
    return deliveryInTotal;
  }

  public void setDeliveryInTotal(String deliveryInTotal) {
    this.deliveryInTotal = deliveryInTotal;
  }

  @Column(name = "salesCompanyAddress")
  public String getSalesCompanyAddress() {
    return salesCompanyAddress;
  }

  public void setSalesCompanyAddress(String salesCompanyAddress) {
    this.salesCompanyAddress = salesCompanyAddress;
  }

  @Column(name = "externalPartnerAddress")
  public String getExternalPartnerAddress() {
    return externalPartnerAddress;
  }

  public void setExternalPartnerAddress(String externalPartnerAddress) {
    this.externalPartnerAddress = externalPartnerAddress;
  }

  @Column(name = "remark1")
  public String getRemark1() {
    return remark1;
  }

  public void setRemark1(String remark1) {
    this.remark1 = remark1;
  }

  @Column(name = "remark2")
  public String getRemark2() {
    return remark2;
  }

  public void setRemark2(String remark2) {
    this.remark2 = remark2;
  }

  @Column(name = "receiverName")
  public String getReceiverName() {
    return receiverName;
  }

  public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
  }

  @Column(name = "receiverPhone")
  public String getReceiverPhone() {
    return receiverPhone;
  }

  public void setReceiverPhone(String receiverPhone) {
    this.receiverPhone = receiverPhone;
  }

  @Column(name = "pickText")
  public String getPickText() {
    return pickText;
  }

  public void setPickText(String pickText) {
    this.pickText = pickText;
  }

  @Column(name = "route")
  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  @Column(name = "codText")
  public String getCodText() {
    return codText;
  }

  public void setCodText(String codText) {
    this.codText = codText;
  }

  @Column(name = "distInfo1")
  public String getDistInfo1() {
    return distInfo1;
  }

  public void setDistInfo1(String distInfo1) {
    this.distInfo1 = distInfo1;
  }

  @Column(name = "distInfo2")
  public String getDistInfo2() {
    return distInfo2;
  }

  public void setDistInfo2(String distInfo2) {
    this.distInfo2 = distInfo2;
  }

  @Column(name = "zipCodeArea")
  public String getZipCodeArea() {
    return zipCodeArea;
  }

  public void setZipCodeArea(String zipCodeArea) {
    this.zipCodeArea = zipCodeArea;
  }

  @Override
  public String toString() {
    return "Supply{" +
        "id=" + id +
        ", orderId='" + orderId + '\'' +
        ", supplyType='" + supplyType + '\'' +
        ", salesOrderNumber='" + salesOrderNumber + '\'' +
        ", shippingType='" + shippingType + '\'' +
        ", pickType='" + pickType + '\'' +
        ", carrier='" + carrier + '\'' +
        ", salesCompanyID='" + salesCompanyID + '\'' +
        ", deliveryInTotal='" + deliveryInTotal + '\'' +
        ", salesCompanyAddress='" + salesCompanyAddress + '\'' +
        ", externalPartnerAddress='" + externalPartnerAddress + '\'' +
        ", remark1='" + remark1 + '\'' +
        ", remark2='" + remark2 + '\'' +
        ", receiverName='" + receiverName + '\'' +
        ", receiverPhone='" + receiverPhone + '\'' +
        ", pickText='" + pickText + '\'' +
        ", route='" + route + '\'' +
        ", codText='" + codText + '\'' +
        ", distInfo1='" + distInfo1 + '\'' +
        ", distInfo2='" + distInfo2 + '\'' +
        ", zipCodeArea='" + zipCodeArea + '\'' +
        '}';
  }
}


