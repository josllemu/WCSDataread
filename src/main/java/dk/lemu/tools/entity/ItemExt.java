package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "ItemExt.findbyItem", query = "SELECT object(ie) FROM ItemExt ie WHERE ie.item = :item_id")
})
@Entity
@Table(name = "ItemExt",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "item"),
        @Index(columnList = "id, item")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ItemExt extends AbstractEntity implements Serializable {

  private Long id;
  private String item; //0
  private String itemConf; //1
  private String clientCode; //2
  private Integer result; //3
  private Integer minRefill1; //4
  private Integer maxRefill1; //5
  private Integer minRefill2; //6
  private Integer maxRefill2; //7
  private Integer qAType; //8
  private Integer recptMaxDiff; //9
  private Boolean certificate;//10
  private Integer precisionValue; //11
  private Boolean usedForHotel; //12
  private Boolean generalCargo; //13
  private Integer countInBox; //14
  private Integer countOfBox; //15
  private Double palletHeight; //16
  private String storageArea; //17
  private String handlingText; //18
  private String storageType1; //19
  private String storageType2; //20
  private String baseUnitVol; //21
  private String qaText; //22
  private String textDiff; //23
  private String baseWeightUnit; //24
  private String baseLenghtUnit; //25
  private String operator; //26
  private Boolean special; //27
  private Boolean userGuide; //28
  private Boolean dangerous; //29
  private Integer daysCount; //30

  public ItemExt() {

  }

  public ItemExt(List<String> list) throws Exception {


    this.setItem(list.get(0));
    this.setClientCode(list.get(1));
    this.setItemConf(list.get(2));
    this.setResult((Integer) TypeParser.fromCSVFile(Integer.class, list.get(3)));
    this.setMinRefill1((Integer) TypeParser.fromCSVFile(Integer.class, list.get(4)));
    this.setMaxRefill1((Integer) TypeParser.fromCSVFile(Integer.class, list.get(5)));
    this.setMinRefill2((Integer) TypeParser.fromCSVFile(Integer.class, list.get(6)));
    this.setMaxRefill2((Integer) TypeParser.fromCSVFile(Integer.class, list.get(7)));
    this.setqAType((Integer) TypeParser.fromCSVFile(Integer.class, list.get(8)));
    this.setRecptMaxDiff((Integer) TypeParser.fromCSVFile(Integer.class, list.get(9)));
    this.setCertificate((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(10)));
    this.setPrecisionValue((Integer) TypeParser.fromCSVFile(Integer.class, list.get(11)));
    this.setUsedForHotel((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(12)));
    this.setGeneralCargo((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(13)));
    this.setCountInBox((Integer) TypeParser.fromCSVFile(Integer.class, list.get(14)));
    this.setCountOfBox((Integer) TypeParser.fromCSVFile(Integer.class, list.get(15)));
    this.setPalletHeight((Double) TypeParser.fromCSVFile(Double.class, list.get(16)));
    this.setStorageArea(list.get(17));
    this.setHandlingText(list.get(18));
    this.setStorageType1(list.get(19));
    this.setStorageType2(list.get(20));
    this.setBaseUnitVol(list.get(21));
    this.setQaText(list.get(22));
    this.setTextDiff(list.get(23));
    this.setBaseWeightUnit(list.get(24));
    this.setBaseLenghtUnit(list.get(25));
    this.setOperator(list.get(26));
    this.setSpecial((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(27)));
    this.setUserGuide((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(28)));
    this.setDangerous((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(29)));
    this.setDaysCount((Integer) TypeParser.fromCSVFile(Integer.class, list.get(30)));


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

  @Column(name = "item", unique = true, nullable = false, length = 50)
  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  @Column(name = "clientCode", nullable = false, length = 50)
  public String getClientCode() {
    return clientCode;
  }

  public void setClientCode(String clientCode) {
    this.clientCode = clientCode;
  }

  @Column(name = "itemConf", nullable = false, length = 50)
  public String getItemConf() {
    return itemConf;
  }

  public void setItemConf(String itemConf) {
    this.itemConf = itemConf;
  }

  @Column(name = "result")
  public Integer getResult() {
    return result;
  }

  public void setResult(Integer result) {
    this.result = result;
  }

  @Column(name = "minRefill1")
  public Integer getMinRefill1() {
    return minRefill1;
  }

  public void setMinRefill1(Integer minRefill1) {
    this.minRefill1 = minRefill1;
  }

  @Column(name = "maxRefill1")
  public Integer getMaxRefill1() {
    return maxRefill1;
  }

  public void setMaxRefill1(Integer maxRefill1) {
    this.maxRefill1 = maxRefill1;
  }

  @Column(name = "minRefill2")
  public Integer getMinRefill2() {
    return minRefill2;
  }

  public void setMinRefill2(Integer minRefill2) {
    this.minRefill2 = minRefill2;
  }

  @Column(name = "maxRefill2")
  public Integer getMaxRefill2() {
    return maxRefill2;
  }

  public void setMaxRefill2(Integer maxRefill2) {
    this.maxRefill2 = maxRefill2;
  }

  @Column(name = "qAType")
  public Integer getqAType() {
    return qAType;
  }

  public void setqAType(Integer qAType) {
    this.qAType = qAType;
  }

  @Column(name = "recptMaxDiff")
  public Integer getRecptMaxDiff() {
    return recptMaxDiff;
  }

  public void setRecptMaxDiff(Integer recptMaxDiff) {
    this.recptMaxDiff = recptMaxDiff;
  }

  @Column(name = "certificate")
  public Boolean getCertificate() {
    return certificate;
  }

  public void setCertificate(Boolean certificate) {
    this.certificate = certificate;
  }

  @Column(name = "precisionValue")
  public Integer getPrecisionValue() {
    return precisionValue;
  }

  public void setPrecisionValue(Integer precisionValue) {
    this.precisionValue = precisionValue;
  }

  @Column(name = "usedForHotel")
  public Boolean getUsedForHotel() {
    return usedForHotel;
  }

  public void setUsedForHotel(Boolean usedForHotel) {
    this.usedForHotel = usedForHotel;
  }

  @Column(name = "generalCargo")
  public Boolean getGeneralCargo() {
    return generalCargo;
  }

  public void setGeneralCargo(Boolean generalCargo) {
    this.generalCargo = generalCargo;
  }

  @Column(name = "countInBox")
  public Integer getCountInBox() {
    return countInBox;
  }

  public void setCountInBox(Integer countInBox) {
    this.countInBox = countInBox;
  }

  @Column(name = "countOfBox")
  public Integer getCountOfBox() {
    return countOfBox;
  }

  public void setCountOfBox(Integer countOfBox) {
    this.countOfBox = countOfBox;
  }

  @Column(name = "palletHeight")
  public Double getPalletHeight() {
    return palletHeight;
  }

  public void setPalletHeight(Double palletHeight) {
    this.palletHeight = palletHeight;
  }

  @Column(name = "storageArea", length = 50)
  public String getStorageArea() {
    return storageArea;
  }

  public void setStorageArea(String storageArea) {
    this.storageArea = storageArea;
  }

  @Column(name = "handlingText", length = 10)
  public String getHandlingText() {
    return handlingText;
  }

  public void setHandlingText(String handlingText) {
    this.handlingText = handlingText;
  }

  @Column(name = "storageType1", length = 10)
  public String getStorageType1() {
    return storageType1;
  }

  public void setStorageType1(String storageType1) {
    this.storageType1 = storageType1;
  }

  @Column(name = "storageType2", length = 10)
  public String getStorageType2() {
    return storageType2;
  }

  public void setStorageType2(String storageType2) {
    this.storageType2 = storageType2;
  }

  @Column(name = "baseUnitVol", length = 10)
  public String getBaseUnitVol() {
    return baseUnitVol;
  }

  public void setBaseUnitVol(String baseUnitVol) {
    this.baseUnitVol = baseUnitVol;
  }

  @Column(name = "qaText", length = 100)
  public String getQaText() {
    return qaText;
  }

  public void setQaText(String qaText) {
    this.qaText = qaText;
  }

  @Column(name = "textDiff", length = 50)
  public String getTextDiff() {
    return textDiff;
  }

  public void setTextDiff(String textDiff) {
    this.textDiff = textDiff;
  }

  @Column(name = "baseWeightUnit", length = 10)
  public String getBaseWeightUnit() {
    return baseWeightUnit;
  }

  public void setBaseWeightUnit(String baseWeightUnit) {
    this.baseWeightUnit = baseWeightUnit;
  }

  @Column(name = "baseLenghtUnit", length = 10)
  public String getBaseLenghtUnit() {
    return baseLenghtUnit;
  }

  public void setBaseLenghtUnit(String baseLenghtUnit) {
    this.baseLenghtUnit = baseLenghtUnit;
  }

  @Column(name = "operator", length = 50)
  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  @Column(name = "special")
  public Boolean getSpecial() {
    return special;
  }

  public void setSpecial(Boolean special) {
    this.special = special;
  }

  @Column(name = "userGuide")
  public Boolean getUserGuide() {
    return userGuide;
  }

  public void setUserGuide(Boolean userGuide) {
    this.userGuide = userGuide;
  }

  @Column(name = "dangerous")
  public Boolean getDangerous() {
    return dangerous;
  }

  public void setDangerous(Boolean dangerous) {
    this.dangerous = dangerous;
  }

  @Column(name = "daysCount")
  public Integer getDaysCount() {
    return daysCount;
  }

  public void setDaysCount(Integer daysCount) {
    this.daysCount = daysCount;
  }

  @Override
  public String toString() {
    return "ItemExt{" +
        "id=" + id +
        ", item='" + item + '\'' +
        ", itemConf='" + itemConf + '\'' +
        ", clientCode='" + clientCode + '\'' +
        ", result=" + result +
        ", minRefill1=" + minRefill1 +
        ", maxRefill1=" + maxRefill1 +
        ", minRefill2=" + minRefill2 +
        ", maxRefill2=" + maxRefill2 +
        ", qAType=" + qAType +
        ", recptMaxDiff=" + recptMaxDiff +
        ", certificate=" + certificate +
        ", precisionValue=" + precisionValue +
        ", usedForHotel=" + usedForHotel +
        ", generalCargo=" + generalCargo +
        ", countInBox=" + countInBox +
        ", countOfBox=" + countOfBox +
        ", palletHeight=" + palletHeight +
        ", storageArea='" + storageArea + '\'' +
        ", handlingText='" + handlingText + '\'' +
        ", storageType1='" + storageType1 + '\'' +
        ", storageType2='" + storageType2 + '\'' +
        ", baseUnitVol='" + baseUnitVol + '\'' +
        ", qaText='" + qaText + '\'' +
        ", textDiff='" + textDiff + '\'' +
        ", baseWeightUnit='" + baseWeightUnit + '\'' +
        ", baseLenghtUnit='" + baseLenghtUnit + '\'' +
        ", operator='" + operator + '\'' +
        ", special=" + special +
        ", userGuide=" + userGuide +
        ", dangerous=" + dangerous +
        ", daysCount=" + daysCount +
        '}';
  }
}
