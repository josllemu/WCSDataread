package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "ItemConf.findbyItem", query = "SELECT object(ic) FROM ItemConf ic WHERE ic.item = :item_id")
})
@Entity
@Table(name = "itemconf", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "item")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "item"),
        @Index(columnList = "id, item")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ItemConf extends AbstractEntity implements Serializable {

  private Long id;
  private String item; //0
  private String client_code; //1
  private String itemConf; //2
  private String description; //3
  private String subConf; //4
  private Integer subFactor = 0; //5
  private Double height; //6
  private Double length; //7
  private Double width; //8
  private String barcode; //9
  private Integer grossWtTolPos; //10
  private Integer grossWtTolNeg; //11
  private Double gross_weight; //12
  private Double maxStackWt; //13
  private Double minStackArea; //14
  private Integer invCheckLev; //15
  private Double itemVol; //16
  private String velocity_code; //17
  private Integer vacuumCode; //18
  private Boolean serialNumReqd; //19
  private Boolean newItem; //20
  private Integer stackability; //21
  private Double netWeight; //22
  private Double measured_qty; //23
  private String barcode2; //24
  private String barcode3; //25
  private String barcode4; //26

  public ItemConf() {

  }

  public ItemConf(List<String> list) throws Exception {


    this.setItem(list.get(0));
    this.setClient_code(list.get(1));
    this.setItemConf(list.get(2));
    this.setDescription(list.get(3));
    this.setSubConf(list.get(4));
    this.setSubFactor((Integer) TypeParser.fromCSVFile(Integer.class, list.get(5)));
    this.setHeight((Double) TypeParser.fromCSVFile(Double.class, list.get(6)));
    this.setLength((Double) TypeParser.fromCSVFile(Double.class, list.get(7)));
    this.setWidth((Double) TypeParser.fromCSVFile(Double.class, list.get(8)));
    this.setBarcode(list.get(9));
    this.setGrossWtTolPos((Integer) TypeParser.fromCSVFile(Integer.class, list.get(10)));
    this.setGrossWtTolNeg((Integer) TypeParser.fromCSVFile(Integer.class, list.get(11)));
    this.setGross_weight((Double) TypeParser.fromCSVFile(Double.class, list.get(12)));
    this.setMaxStackWt((Double) TypeParser.fromCSVFile(Double.class, list.get(13)));
    this.setMinStackArea((Double) TypeParser.fromCSVFile(Double.class, list.get(14)));
    this.setInvCheckLev((Integer) TypeParser.fromCSVFile(Integer.class, list.get(15)));
    this.setItemVol((Double) TypeParser.fromCSVFile(Double.class, list.get(16)));
    this.setVelocity_code(list.get(17));
    this.setVacuumCode((Integer) TypeParser.fromCSVFile(Integer.class, list.get(18)));
    this.setSerialNumReqd((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(19)));
    this.setNewItem((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(20)));
    this.setStackability((Integer) TypeParser.fromCSVFile(Integer.class, list.get(21)));
    this.setNetWeight((Double) TypeParser.fromCSVFile(Double.class, list.get(22)));
    this.setMeasured_qty((Double) TypeParser.fromCSVFile(Double.class, list.get(23)));
    this.setBarcode2(list.get(24));
    this.setBarcode3(list.get(25));
    this.setBarcode4(list.get(26));

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

  @Column(name = "item")
  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  @Column(name = "client_code", nullable = false)
  public String getClient_code() {
    return client_code;
  }

  public void setClient_code(String client_code) {
    this.client_code = client_code;
  }

  @Column(name = "itemConf", nullable = false)
  public String getItemConf() {
    return itemConf;
  }

  public void setItemConf(String itemConf) {
    this.itemConf = itemConf;
  }

  @Column(name = "serialNumReqd")
  public Boolean getSerialNumReqd() {
    return serialNumReqd;
  }

  public void setSerialNumReqd(Boolean serialNumReqd) {
    this.serialNumReqd = serialNumReqd;
  }

  @Column(name = "velocity_code")
  public String getVelocity_code() {
    return velocity_code;
  }

  public void setVelocity_code(String velocity_code) {
    this.velocity_code = velocity_code;
  }

  @Column(name = "barcode", nullable = false)
  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  @Column(name = "height")
  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  @Column(name = "length")
  public Double getLength() {
    return length;
  }

  public void setLength(Double length) {
    this.length = length;
  }

  @Column(name = "width")
  public Double getWidth() {
    return width;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  @Column(name = "gross_weight")
  public Double getGross_weight() {
    return gross_weight;
  }

  public void setGross_weight(Double gross_weight) {
    this.gross_weight = gross_weight;
  }

  @Column(name = "measured_qty")
  public Double getMeasured_qty() {
    return measured_qty;
  }

  public void setMeasured_qty(Double measured_qty) {
    this.measured_qty = measured_qty;
  }

  @Column(name = "barcode2")
  public String getBarcode2() {
    return barcode2;
  }

  public void setBarcode2(String barcode2) {
    this.barcode2 = barcode2;
  }

  @Column(name = "barcode3")
  public String getBarcode3() {
    return barcode3;
  }

  public void setBarcode3(String barcode3) {
    this.barcode3 = barcode3;
  }

  @Column(name = "barcode4")
  public String getBarcode4() {
    return barcode4;
  }

  public void setBarcode4(String barcode4) {
    this.barcode4 = barcode4;
  }

  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "subConf")
  public String getSubConf() {
    return subConf;
  }

  public void setSubConf(String subConf) {
    this.subConf = subConf;
  }

  @Column(name = "subFactor")
  public Integer getSubFactor() {
    return subFactor;
  }

  public void setSubFactor(Integer subFactor) {
    this.subFactor = subFactor;
  }

  @Column(name = "grossWtTolPos")
  public Integer getGrossWtTolPos() {
    return grossWtTolPos;
  }

  public void setGrossWtTolPos(Integer grossWtTolPos) {
    this.grossWtTolPos = grossWtTolPos;
  }

  @Column(name = "grossWtTolNeg")
  public Integer getGrossWtTolNeg() {
    return grossWtTolNeg;
  }

  public void setGrossWtTolNeg(Integer grossWtTolNeg) {
    this.grossWtTolNeg = grossWtTolNeg;
  }

  @Column(name = "maxStackWt")
  public Double getMaxStackWt() {
    return maxStackWt;
  }

  public void setMaxStackWt(Double maxStackWt) {
    this.maxStackWt = maxStackWt;
  }

  @Column(name = "minStackArea")
  public Double getMinStackArea() {
    return minStackArea;
  }

  public void setMinStackArea(Double minStackArea) {
    this.minStackArea = minStackArea;
  }

  @Column(name = "invCheckLev")
  public Integer getInvCheckLev() {
    return invCheckLev;
  }

  public void setInvCheckLev(Integer invCheckLev) {
    this.invCheckLev = invCheckLev;
  }

  @Column(name = "itemVol")
  public Double getItemVol() {
    return itemVol;
  }

  public void setItemVol(Double itemVol) {
    this.itemVol = itemVol;
  }

  @Column(name = "vacuumCode")
  public Integer getVacuumCode() {
    return vacuumCode;
  }

  public void setVacuumCode(Integer vacuumCode) {
    this.vacuumCode = vacuumCode;
  }

  @Column(name = "newItem")
  public Boolean getNewItem() {
    return newItem;
  }

  public void setNewItem(Boolean newItem) {
    this.newItem = newItem;
  }

  @Column(name = "stackability")
  public Integer getStackability() {
    return stackability;
  }

  public void setStackability(Integer stackability) {
    this.stackability = stackability;
  }

  @Column(name = "netWeight")
  public Double getNetWeight() {
    return netWeight;
  }

  public void setNetWeight(Double netWeight) {
    this.netWeight = netWeight;
  }

  @Override
  public String toString() {
    return "ItemConf{" +
        "id=" + id +
        ", item='" + item + '\'' +
        ", client_code='" + client_code + '\'' +
        ", itemConf='" + itemConf + '\'' +
        ", description='" + description + '\'' +
        ", subConf='" + subConf + '\'' +
        ", subFactor=" + subFactor +
        ", height=" + height +
        ", length=" + length +
        ", width=" + width +
        ", barcode='" + barcode + '\'' +
        ", grossWtTolPos=" + grossWtTolPos +
        ", grossWtTolNeg=" + grossWtTolNeg +
        ", gross_weight=" + gross_weight +
        ", maxStackWt=" + maxStackWt +
        ", minStackArea=" + minStackArea +
        ", invCheckLev=" + invCheckLev +
        ", itemVol=" + itemVol +
        ", velocity_code='" + velocity_code + '\'' +
        ", vacuumCode=" + vacuumCode +
        ", serialNumReqd=" + serialNumReqd +
        ", newItem=" + newItem +
        ", stackability=" + stackability +
        ", netWeight=" + netWeight +
        ", measured_qty=" + measured_qty +
        ", barcode2='" + barcode2 + '\'' +
        ", barcode3='" + barcode3 + '\'' +
        ", barcode4='" + barcode4 + '\'' +
        '}';
  }
}
