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
    @NamedQuery(name = "Zone.findByZone", query = "SELECT object(o) FROM Zone o WHERE o.zone = :zone")
})
@Entity
@Table(name = "Zone",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "zone"),
        @Index(columnList = "id, zone")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Zone extends AbstractEntity implements Serializable {

  private Long id;
  private Integer zone; //0
  private Date creationDate; //1
  private String description; //2
  private String typeModule; //3
  private String selectModule; //4
  private String genericText; //5
  private String templateText; //6
  private String fixedText; //7
  private Integer numCoords; //8
  private Integer StockSpread; //9
  private Double x; //10
  private Double y; //11
  private Double z; //12
  private Integer pickupBitmap; //13
  private Integer putdownBitmap; //14
  private String mvFinModule; //15
  private Integer usageBitmap; //16


  public Zone() {

  }

  public Zone(List<String> list) throws Exception {
    this.setZone((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setCreationDate((Date) TypeParser.fromCSVFile(Date.class, list.get(1)));
    this.setDescription((String) TypeParser.fromCSVFile(String.class, list.get(2)));
    this.setTypeModule((String) TypeParser.fromCSVFile(String.class, list.get(3)));
    this.setSelectModule((String) TypeParser.fromCSVFile(String.class, list.get(4)));
    this.setGenericText((String) TypeParser.fromCSVFile(String.class, list.get(5)));
    this.setTemplateText((String) TypeParser.fromCSVFile(String.class, list.get(6)));
    this.setFixedText((String) TypeParser.fromCSVFile(String.class, list.get(7)));
    this.setNumCoords((Integer) TypeParser.fromCSVFile(Integer.class, list.get(8)));
    this.setStockSpread((Integer) TypeParser.fromCSVFile(Integer.class, list.get(9)));
    this.setX((Double) TypeParser.fromCSVFile(Double.class, list.get(10)));
    this.setY((Double) TypeParser.fromCSVFile(Double.class, list.get(11)));
    this.setZ((Double) TypeParser.fromCSVFile(Double.class, list.get(12)));
    this.setPickupBitmap((Integer) TypeParser.fromCSVFile(Integer.class, list.get(13)));
    this.setPutdownBitmap((Integer) TypeParser.fromCSVFile(Integer.class, list.get(14)));
    this.setMvFinModule((String) TypeParser.fromCSVFile(String.class, list.get(15)));
    this.setUsageBitmap((Integer) TypeParser.fromCSVFile(Integer.class, list.get(16)));

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

  @Column(name = "zone", unique = true, nullable = false)
  public Integer getZone() {
    return zone;
  }

  public void setZone(Integer zone) {
    this.zone = zone;
  }

  @Column(name = "creationDate")
  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  @Column(name = "description", length = 100)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "typeModule", length = 50)
  public String getTypeModule() {
    return typeModule;
  }

  public void setTypeModule(String typeModule) {
    this.typeModule = typeModule;
  }

  @Column(name = "selectModule", length = 50)
  public String getSelectModule() {
    return selectModule;
  }

  public void setSelectModule(String selectModule) {
    this.selectModule = selectModule;
  }

  @Column(name = "genericText", length = 50)
  public String getGenericText() {
    return genericText;
  }

  public void setGenericText(String genericText) {
    this.genericText = genericText;
  }

  @Column(name = "templateText", length = 50)
  public String getTemplateText() {
    return templateText;
  }

  public void setTemplateText(String templateText) {
    this.templateText = templateText;
  }

  @Column(name = "fixedText", length = 50)
  public String getFixedText() {
    return fixedText;
  }

  public void setFixedText(String fixedText) {
    this.fixedText = fixedText;
  }

  @Column(name = "numCoords")
  public Integer getNumCoords() {
    return numCoords;
  }

  public void setNumCoords(Integer numCoords) {
    this.numCoords = numCoords;
  }

  @Column(name = "StockSpread")
  public Integer getStockSpread() {
    return StockSpread;
  }

  public void setStockSpread(Integer stockSpread) {
    StockSpread = stockSpread;
  }

  @Column(name = "x")
  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  @Column(name = "y")
  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }

  @Column(name = "z")
  public Double getZ() {
    return z;
  }

  public void setZ(Double z) {
    this.z = z;
  }

  @Column(name = "pickupBitmap")
  public Integer getPickupBitmap() {
    return pickupBitmap;
  }

  public void setPickupBitmap(Integer pickupBitmap) {
    this.pickupBitmap = pickupBitmap;
  }

  @Column(name = "putdownBitmap")
  public Integer getPutdownBitmap() {
    return putdownBitmap;
  }

  public void setPutdownBitmap(Integer putdownBitmap) {
    this.putdownBitmap = putdownBitmap;
  }

  @Column(name = "mvFinModule", length = 50)
  public String getMvFinModule() {
    return mvFinModule;
  }

  public void setMvFinModule(String mvFinModule) {
    this.mvFinModule = mvFinModule;
  }

  @Column(name = "usageBitmap")
  public Integer getUsageBitmap() {
    return usageBitmap;
  }

  public void setUsageBitmap(Integer usageBitmap) {
    this.usageBitmap = usageBitmap;
  }

  @Override
  public String toString() {
    return "Zone{" +
        "id=" + id +
        ", zone=" + zone +
        ", creationDate=" + creationDate +
        ", description='" + description + '\'' +
        ", typeModule='" + typeModule + '\'' +
        ", selectModule='" + selectModule + '\'' +
        ", genericText='" + genericText + '\'' +
        ", templateText='" + templateText + '\'' +
        ", fixedText='" + fixedText + '\'' +
        ", numCoords=" + numCoords +
        ", StockSpread=" + StockSpread +
        ", x=" + x +
        ", y=" + y +
        ", z=" + z +
        ", pickupBitmap=" + pickupBitmap +
        ", putdownBitmap=" + putdownBitmap +
        ", mvFinModule='" + mvFinModule + '\'' +
        ", usageBitmap=" + usageBitmap +
        '}';
  }
}

