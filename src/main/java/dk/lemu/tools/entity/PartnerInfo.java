package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "PartnerInfo.findByOrderAndOrderSub", query = "SELECT object(o) FROM PartnerInfo o WHERE  o.orderID = :orderID AND o.orderSUB = :orderSUB")
})
@Entity
@Table(name = "PartnerInfo", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "orderID, orderSUB"),
        @Index(columnList = "id, orderID, orderSUB")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PartnerInfo extends AbstractEntity implements Serializable {

  private Long id;
  private Integer orderID; //0
  private String orderSUB; //1
  private String orderNumber; //2
  private String requistion; //3
  private String contactName; //4
  private String contactNumber; //5
  private String orderName; //6
  private String orderName1; //7
  private String orderName2; //8
  private String orderName3; //9

  public PartnerInfo() {

  }

  public PartnerInfo(List<String> list) throws Exception {


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

  @Column(name = "orderID")
  public Integer getOrderID() {
    return orderID;
  }

  public void setOrderID(Integer orderID) {
    this.orderID = orderID;
  }

  @Column(name = "orderSUB")
  public String getOrderSUB() {
    return orderSUB;
  }

  public void setOrderSUB(String orderSUB) {
    this.orderSUB = orderSUB;
  }

  @Column(name = "orderNumber")
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Column(name = "requistion")
  public String getRequistion() {
    return requistion;
  }

  public void setRequistion(String requistion) {
    this.requistion = requistion;
  }

  @Column(name = "contactName")
  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  @Column(name = "contactNumber")
  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  @Column(name = "orderName")
  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }

  @Column(name = "orderName1")
  public String getOrderName1() {
    return orderName1;
  }

  public void setOrderName1(String orderName1) {
    this.orderName1 = orderName1;
  }

  @Column(name = "orderName2")
  public String getOrderName2() {
    return orderName2;
  }

  public void setOrderName2(String orderName2) {
    this.orderName2 = orderName2;
  }

  @Column(name = "orderName3")
  public String getOrderName3() {
    return orderName3;
  }

  public void setOrderName3(String orderName3) {
    this.orderName3 = orderName3;
  }

  @Override
  public String toString() {
    return "PartnerInfo{" +
        "id=" + id +
        ", orderID=" + orderID +
        ", orderSUB='" + orderSUB + '\'' +
        ", orderNumber='" + orderNumber + '\'' +
        ", requistion='" + requistion + '\'' +
        ", contactName='" + contactName + '\'' +
        ", contactNumber='" + contactNumber + '\'' +
        ", orderName='" + orderName + '\'' +
        ", orderName1='" + orderName1 + '\'' +
        ", orderName2='" + orderName2 + '\'' +
        ", orderName3='" + orderName3 + '\'' +
        '}';
  }
}

