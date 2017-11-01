package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "Item.findbyItemCode", query = "SELECT object(i) FROM Item i WHERE i.item_code = :itemCode")
})
@Entity
@Table(name = "Item", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "item_code")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, item_code")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Item extends AbstractEntity implements Serializable {


  private Long id;
  private String item_code; //0
  private String client_code; //1
  private String description; //2
  private String brand_code; //3
  private String shelf_life; //4
  private Double alcohol_by_volume; //5
  private String duty_code; //6
  private String segregation_code; //7

  public Item() {

  }

  public Item(List<String> list) throws Exception {
    this.setItem_code(list.get(0));
    this.setClient_code(list.get(1));
    this.setDescription(list.get(2));
    this.setBrand_code(list.get(3));
    this.setShelf_life(list.get(4));
    this.setAlcohol_by_volume((Double) TypeParser.fromCSVFile(Double.class, list.get(5)));
    this.setDuty_code(list.get(6));
    this.setSegregation_code(list.get(7));
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

  @Column(name = "item_code", unique = true, nullable = false)
  public String getItem_code() {
    return item_code;
  }

  public void setItem_code(String item_code) {
    this.item_code = item_code;
  }

  @Column(name = "client_code", nullable = false)
  public String getClient_code() {
    return client_code;
  }

  public void setClient_code(String client_code) {
    this.client_code = client_code;
  }

  @Column(name = "description", length = 500)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "brand_code")
  public String getBrand_code() {
    return brand_code;
  }

  public void setBrand_code(String brand_code) {
    this.brand_code = brand_code;
  }

  @Column(name = "shelf_life")
  public String getShelf_life() {
    return shelf_life;
  }

  public void setShelf_life(String shelf_life) {
    this.shelf_life = shelf_life;
  }

  @Column(name = "alcohol_by_volume")
  public Double getAlcohol_by_volume() {
    return alcohol_by_volume;
  }

  public void setAlcohol_by_volume(Double alcohol_by_volume) {
    this.alcohol_by_volume = alcohol_by_volume;
  }

  @Column(name = "duty_code")
  public String getDuty_code() {
    return duty_code;
  }

  public void setDuty_code(String duty_code) {
    this.duty_code = duty_code;
  }

  @Column(name = "segregation_code")
  public String getSegregation_code() {
    return segregation_code;
  }

  public void setSegregation_code(String segregation_code) {
    this.segregation_code = segregation_code;
  }


  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", item_code='" + item_code + '\'' +
        ", client_code='" + client_code + '\'' +
        ", description='" + description + '\'' +
        ", brand_code='" + brand_code + '\'' +
        ", shelf_life='" + shelf_life + '\'' +
        ", alcohol_by_volume='" + alcohol_by_volume + '\'' +
        ", duty_code='" + duty_code + '\'' +
        ", segregation_code='" + segregation_code + '\'' +
        '}';
  }

}
