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
    @NamedQuery(name = "Stock.findByItemCodeAndContainerAndTimeReceived",
        query = "SELECT object(s) FROM Stock s " +
            "WHERE s.item = :itemCode AND s.container = :containerId and s.timeReceived = :receiveDate")
})
@Entity
@Table(name = "Stock", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id")
},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, item"),
        @Index(columnList = "item"),
        @Index(columnList = "container"),
        @Index(columnList = "id, item, container, timeReceived"),
        @Index(columnList = "id, item, container")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Stock extends AbstractEntity implements Serializable {


  private Long id;
  private String container; //0
  private Integer sequence; //1
  private Date rotation0;//2
  private Date rotation1;//3
  private Date rotation2;//4
  private Date rotation3;//5
  private String status; //6
  private String clientCode; //7
  private String item; //8
  private String itemConf; //9
  private Double qty; //10
  private Integer allocRef; //11
  private String batchRef; //12
  private String bondRef; //13
  private Date timeCreated; //14
  private Date timeReceived; //15
  private Date timePicked; //16
  private Date timeAssambled; //17
  private Date timeLoaded; //18
  private String receiptRef; //19
  private String receiptLine; //20
  private Boolean pendingDeallocFlag = false; //21
  private Integer comp; //22
  private String serialnumber; //23
  private String originalItemConf; //24
  private String countryOfOrigin; //25
  private String countryOfManfactr; //26
  private Date dbDate = new Date();

  public Stock() {

  }

  public Stock(List<String> list) throws Exception {


    this.setContainer(list.get(0));
    this.setSequence((Integer) TypeParser.fromCSVFile(Integer.class, list.get(1)));
    this.setRotation0((Date) TypeParser.fromCSVFile(Date.class, list.get(2)));
    this.setRotation1((Date) TypeParser.fromCSVFile(Date.class, list.get(3)));
    this.setRotation2((Date) TypeParser.fromCSVFile(Date.class, list.get(4)));
    this.setRotation3((Date) TypeParser.fromCSVFile(Date.class, list.get(5)));
    this.setStatus(list.get(6));
    this.setClientCode(list.get(7));
    this.setItem(list.get(8));
    this.setItemConf(list.get(9));
    this.setQty((Double) TypeParser.fromCSVFile(Double.class, list.get(10)));
    this.setAllocRef((Integer) TypeParser.fromCSVFile(Integer.class, list.get(11)));
    this.setBatchRef(list.get(12));
    this.setBondRef(list.get(13));
    this.setTimeCreated((Date) TypeParser.fromCSVFile(Date.class, list.get(14)));
    this.setTimeReceived((Date) TypeParser.fromCSVFile(Date.class, list.get(15)));
    this.setTimePicked((Date) TypeParser.fromCSVFile(Date.class, list.get(16)));
    this.setTimeAssambled((Date) TypeParser.fromCSVFile(Date.class, list.get(17)));
    this.setTimeLoaded((Date) TypeParser.fromCSVFile(Date.class, list.get(18)));
    this.setReceiptRef(list.get(19));
    this.setReceiptLine(list.get(20));
    this.setPendingDeallocFlag((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(21)));
    this.setComp((Integer) TypeParser.fromCSVFile(Integer.class, list.get(22)));
    this.setSerialnumber(list.get(23));
    this.setOriginalItemConf(list.get(24));
    this.setCountryOfOrigin(list.get(25));
    this.setCountryOfManfactr(list.get(26));
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

  @Column(name = "item", nullable = false)
  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  @Column(name = "container", nullable = false)
  public String getContainer() {
    return container;
  }

  public void setContainer(String container) {
    this.container = container;
  }

  @Column(name = "qty", nullable = false)
  public Double getQty() {
    return qty;
  }

  public void setQty(Double qty) {
    this.qty = qty;
  }

  @Column(name = "sequence")
  public Integer getSequence() {
    return sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  @Column(name = "rotation0")
  public Date getRotation0() {
    return rotation0;
  }

  public void setRotation0(Date rotation0) {
    this.rotation0 = rotation0;
  }

  @Column(name = "rotation1")
  public Date getRotation1() {
    return rotation1;
  }

  public void setRotation1(Date rotation1) {
    this.rotation1 = rotation1;
  }

  @Column(name = "rotation2")
  public Date getRotation2() {
    return rotation2;
  }

  public void setRotation2(Date rotation2) {
    this.rotation2 = rotation2;
  }

  @Column(name = "rotation3")
  public Date getRotation3() {
    return rotation3;
  }

  public void setRotation3(Date rotation3) {
    this.rotation3 = rotation3;
  }

  @Column(name = "status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Column(name = "clientCode")
  public String getClientCode() {
    return clientCode;
  }

  public void setClientCode(String clientCode) {
    this.clientCode = clientCode;
  }

  @Column(name = "configurationcode", nullable = false)
  public String getItemConf() {
    return itemConf;
  }

  public void setItemConf(String itemConf) {
    this.itemConf = itemConf;
  }

  @Column(name = "allocRef")
  public Integer getAllocRef() {
    return allocRef;
  }

  public void setAllocRef(Integer allocRef) {
    this.allocRef = allocRef;
  }

  @Column(name = "batchRef")
  public String getBatchRef() {
    return batchRef;
  }

  public void setBatchRef(String batchRef) {
    this.batchRef = batchRef;
  }

  @Column(name = "bondRef")
  public String getBondRef() {
    return bondRef;
  }

  public void setBondRef(String bondRef) {
    this.bondRef = bondRef;
  }

  @Column(name = "timeCreated")
  public Date getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Date timeCreated) {
    this.timeCreated = timeCreated;
  }

  @Column(name = "timeReceived")
  public Date getTimeReceived() {
    return timeReceived;
  }

  public void setTimeReceived(Date timeReceived) {
    this.timeReceived = timeReceived;
  }

  @Column(name = "timePicked")
  public Date getTimePicked() {
    return timePicked;
  }

  public void setTimePicked(Date timePicked) {
    this.timePicked = timePicked;
  }

  @Column(name = "timeAssambled")
  public Date getTimeAssambled() {
    return timeAssambled;
  }

  public void setTimeAssambled(Date timeAssambled) {
    this.timeAssambled = timeAssambled;
  }

  @Column(name = "timeLoaded")
  public Date getTimeLoaded() {
    return timeLoaded;
  }

  public void setTimeLoaded(Date timeLoaded) {
    this.timeLoaded = timeLoaded;
  }

  @Column(name = "receiptRef")
  public String getReceiptRef() {
    return receiptRef;
  }

  public void setReceiptRef(String receiptRef) {
    this.receiptRef = receiptRef;
  }

  @Column(name = "receiptLine")
  public String getReceiptLine() {
    return receiptLine;
  }

  public void setReceiptLine(String receiptLine) {
    this.receiptLine = receiptLine;
  }

  @Column(name = "pendingDeallocFlag")
  public Boolean getPendingDeallocFlag() {
    return pendingDeallocFlag;
  }

  public void setPendingDeallocFlag(Boolean pendingDeallocFlag) {
    this.pendingDeallocFlag = pendingDeallocFlag;
  }

  @Column(name = "comp")
  public Integer getComp() {
    return comp;
  }

  public void setComp(Integer comp) {
    this.comp = comp;
  }

  @Column(name = "serialnumber")
  public String getSerialnumber() {
    return serialnumber;
  }

  public void setSerialnumber(String serialnumber) {
    this.serialnumber = serialnumber;
  }

  @Column(name = "originalItemConf")
  public String getOriginalItemConf() {
    return originalItemConf;
  }

  public void setOriginalItemConf(String originalItemConf) {
    this.originalItemConf = originalItemConf;
  }

  @Column(name = "countryOfOrigin")
  public String getCountryOfOrigin() {
    return countryOfOrigin;
  }

  public void setCountryOfOrigin(String countryOfOrigin) {
    this.countryOfOrigin = countryOfOrigin;
  }

  @Column(name = "countryOfManfactr")
  public String getCountryOfManfactr() {
    return countryOfManfactr;
  }

  public void setCountryOfManfactr(String countryOfManfactr) {
    this.countryOfManfactr = countryOfManfactr;
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
    return "Stock{" +
        "id=" + id +
        ", container='" + container + '\'' +
        ", sequence=" + sequence +
        ", rotation0=" + rotation0 +
        ", rotation1=" + rotation1 +
        ", rotation2=" + rotation2 +
        ", rotation3=" + rotation3 +
        ", status='" + status + '\'' +
        ", clientCode='" + clientCode + '\'' +
        ", item='" + item + '\'' +
        ", itemConf='" + itemConf + '\'' +
        ", qty=" + qty +
        ", allocRef=" + allocRef +
        ", batchRef='" + batchRef + '\'' +
        ", bondRef='" + bondRef + '\'' +
        ", timeCreated=" + timeCreated +
        ", timeReceived=" + timeReceived +
        ", timePicked=" + timePicked +
        ", timeAssambled=" + timeAssambled +
        ", timeLoaded=" + timeLoaded +
        ", receiptRef='" + receiptRef + '\'' +
        ", receiptLine='" + receiptLine + '\'' +
        ", pendingDeallocFlag=" + pendingDeallocFlag +
        ", comp=" + comp +
        ", serialnumber='" + serialnumber + '\'' +
        ", originalItemConf='" + originalItemConf + '\'' +
        ", countryOfOrigin='" + countryOfOrigin + '\'' +
        ", countryOfManfactr='" + countryOfManfactr + '\'' +
        ", dbDate=" + dbDate +
        '}';
  }

}
