package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "PartnerAddress.findByOrderAndOrderSub", query = "SELECT object(o) FROM PartnerAddress o " +
        "WHERE o.orderID = :orderID AND o.orderSUB = :orderSUB")
})
@Entity
@Table(name = "PartnerAddress", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"orderID", "orderSUB"})},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "orderID, orderSUB"),
        @Index(columnList = "id, orderID, orderSUB")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PartnerAddress extends AbstractEntity implements Serializable {

  private Long id;
  private String orderID; //0
  private String orderSUB; //1
  private String cvr; //2
  private String phone; //3
  private String fax; //4
  private String email; //5
  private String name1; //6
  private String name2; //7
  private String name3; //8
  private String address1; //9
  private String address2; //10
  private String zip; //11
  private String town; //12
  private String country; //13
  private String column1; //14

  public PartnerAddress() {

  }

  public PartnerAddress(List<String> list) throws Exception {
    this.setOrderID((String) TypeParser.fromCSVFile(String.class, list.get(0)));
    this.setOrderSUB(list.get(1));
    this.setCvr(list.get(2));
    this.setPhone(list.get(3));
    this.setFax(list.get(4));
    this.setEmail(list.get(5));
    this.setName1(list.get(6));
    this.setName2(list.get(7));
    this.setName3(list.get(8));
    this.setAddress1(list.get(9));
    this.setAddress2(list.get(10));
    this.setZip(list.get(11));
    this.setTown(list.get(12));
    this.setCountry(list.get(13));
    this.setTown(list.get(14));

  }

  @Id
  @GenericGenerator(name = "josl", strategy = "increment")
  @GeneratedValue(generator = "josl")
  @Column(name = "Id", unique = true, nullable = false, length = 50)
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

  @Column(name = "cvr", length = 50)
  public String getCvr() {
    return cvr;
  }

  public void setCvr(String cvr) {
    this.cvr = cvr;
  }

  @Column(name = "phone", length = 50)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Column(name = "fax", length = 50)
  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  @Column(name = "email", length = 50)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  @Column(name = "name3", length = 50)
  public String getName3() {
    return name3;
  }

  public void setName3(String name3) {
    this.name3 = name3;
  }

  @Column(name = "address1", length = 50)
  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  @Column(name = "address2", length = 50)
  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  @Column(name = "zip", length = 15)
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  @Column(name = "town", length = 50)
  public String getTown() {
    return town;
  }

  public void setTown(String town) {
    this.town = town;
  }

  @Column(name = "country", length = 10)
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Column(name = "column1", length = 50)
  public String getColumn1() {
    return column1;
  }

  public void setColumn1(String column1) {
    this.column1 = column1;
  }

  @Override
  public String toString() {
    return "PartnerAddress{" +
        "id=" + id +
        ", orderID=" + orderID +
        ", orderSUB='" + orderSUB + '\'' +
        ", cvr='" + cvr + '\'' +
        ", phone='" + phone + '\'' +
        ", fax='" + fax + '\'' +
        ", email='" + email + '\'' +
        ", name1='" + name1 + '\'' +
        ", name2='" + name2 + '\'' +
        ", name3='" + name3 + '\'' +
        ", address1='" + address1 + '\'' +
        ", address2='" + address2 + '\'' +
        ", zip='" + zip + '\'' +
        ", town='" + town + '\'' +
        ", country='" + country + '\'' +
        ", column1='" + column1 + '\'' +
        '}';
  }
}

