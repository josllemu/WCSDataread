package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "PartnerInfo.findByOrderAndOrderSub", query = "SELECT object(o) FROM PartnerInfo o " +
        "WHERE  o.orderID = :orderID AND o.orderSUB = :orderSUB")
})
@Entity
@Table(name = "PartnerInfo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"orderID", "orderSUB"})},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "orderID, orderSUB"),
        @Index(columnList = "id, orderID, orderSUB")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PartnerInfo extends AbstractEntity implements Serializable {

  private Long id;
  private String orderID; //0
  private String orderSUB; //1
  private String orderNumber; //2
  private String requistion; //3
  private String contactName; //4
  private String contactNumber; //5
  private String orderName; //6

  public PartnerInfo() {

  }

  public PartnerInfo(List<String> list) throws Exception {
    this.setOrderID((String) TypeParser.fromCSVFile(String.class, list.get(0)));
    this.setOrderSUB(list.get(1));
    this.setOrderNumber(list.get(2));
    this.setRequistion(list.get(3));
    this.setContactName(list.get(4));
    this.setContactNumber(list.get(5));
    for (int i = 6; i>=list.size(); i++) {
      this.setOrderName(this.getOrderName() != null ?
          this.getOrderNumber() + "~" +list.get(i) :
          list.get(i));
    }



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

  @Column(name = "orderID", length = 50)
  public String getOrderID() {
    return orderID;
  }

  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }

  @Column(name = "orderSUB", length = 50)
  public String getOrderSUB() {
    return orderSUB;
  }

  public void setOrderSUB(String orderSUB) {
    this.orderSUB = orderSUB;
  }

  @Column(name = "orderNumber", length = 50)
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Column(name = "requistion", length = 50)
  public String getRequistion() {
    return requistion;
  }

  public void setRequistion(String requistion) {
    this.requistion = requistion;
  }

  @Column(name = "contactName", length = 50)
  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  @Column(name = "contactNumber", length = 50)
  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  @Column(name = "orderName", length = 50)
  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
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

        '}';
  }
}

