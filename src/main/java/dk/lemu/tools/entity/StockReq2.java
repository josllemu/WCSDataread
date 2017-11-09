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
    @NamedQuery(name = "StockReq2.findByAllocRef", query = "SELECT object(o) FROM StockReq2 o WHERE o.allocRef = :allocRef")
})
@Entity
@Table(name = "StockReq2",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "allocRef"),
        @Index(columnList = "id, allocRef")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StockReq2 extends AbstractEntity implements Serializable {

  private Long id;
  private Integer allocRef; //0
  private String clientCode; //1
  private String itemCode; //2
  private String itemConf; //3
  private String parm1; //4
  private String parm2; //5
  private String parm3; //6
  private String parmN; //7
  private String type; //8
  private String category; //9
  private Integer constant; //10
  private String nullable; //11
  private String describtion; //12
  private String select1; //13
  private String select2; //14
  private String select3; //15
  private String select4; //16
  private String select5; //17
  private String form; //18
  private Boolean empty; //19
  private Date dbDate = new Date();


  public StockReq2() {

  }

  public StockReq2(List<String> list) throws Exception {
    this.setAllocRef((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setClientCode((String) TypeParser.fromCSVFile(String.class, list.get(1)));
    this.setItemCode((String) TypeParser.fromCSVFile(String.class, list.get(2)));
    this.setItemConf((String) TypeParser.fromCSVFile(String.class, list.get(3)));
    this.setParm1((String) TypeParser.fromCSVFile(String.class, list.get(4)));
    this.setParm2((String) TypeParser.fromCSVFile(String.class, list.get(5)));
    this.setParm3((String) TypeParser.fromCSVFile(String.class, list.get(6)));
    this.setParmN((String) TypeParser.fromCSVFile(String.class, list.get(7)));
    this.setType((String) TypeParser.fromCSVFile(String.class, list.get(8)));
    this.setCategory((String) TypeParser.fromCSVFile(String.class, list.get(9)));
    this.setConstant((Integer) TypeParser.fromCSVFile(Integer.class, list.get(10)));
    this.setNullable((String) TypeParser.fromCSVFile(String.class, list.get(11)));
    this.setDescribtion((String) TypeParser.fromCSVFile(String.class, list.get(12)));
    this.setSelect1((String) TypeParser.fromCSVFile(String.class, list.get(13)));
    this.setSelect2((String) TypeParser.fromCSVFile(String.class, list.get(14)));
    this.setSelect3((String) TypeParser.fromCSVFile(String.class, list.get(15)));
    this.setSelect4((String) TypeParser.fromCSVFile(String.class, list.get(16)));
    this.setSelect5((String) TypeParser.fromCSVFile(String.class, list.get(17)));
    this.setForm((String) TypeParser.fromCSVFile(String.class, list.get(18)));
    this.setEmpty((Boolean) TypeParser.fromCSVFile(Boolean.class, list.get(19)));
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

  @Column(name = "allocRef", unique = true, nullable = false)
  public Integer getAllocRef() {
    return allocRef;
  }

  public void setAllocRef(Integer allocRef) {
    this.allocRef = allocRef;
  }

  @Column(name = "clientCode", length = 50)
  public String getClientCode() {
    return clientCode;
  }

  public void setClientCode(String clientCode) {
    this.clientCode = clientCode;
  }

  @Column(name = "itemCode", length = 50)
  public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  @Column(name = "itemConf", length = 50)
  public String getItemConf() {
    return itemConf;
  }

  public void setItemConf(String itemConf) {
    this.itemConf = itemConf;
  }

  @Column(name = "parm1", length = 10)
  public String getParm1() {
    return parm1;
  }

  public void setParm1(String parm1) {
    this.parm1 = parm1;
  }

  @Column(name = "parm2", length = 50)
  public String getParm2() {
    return parm2;
  }

  public void setParm2(String parm2) {
    this.parm2 = parm2;
  }

  @Column(name = "parm3", length = 50)
  public String getParm3() {
    return parm3;
  }

  public void setParm3(String parm3) {
    this.parm3 = parm3;
  }

  @Column(name = "parmN", length = 5)
  public String getParmN() {
    return parmN;
  }

  public void setParmN(String parmN) {
    this.parmN = parmN;
  }

  @Column(name = "type", length = 5)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Column(name = "category", length = 15)
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Column(name = "constant", length = 15)
  public Integer getConstant() {
    return constant;
  }

  public void setConstant(Integer constant) {
    this.constant = constant;
  }

  @Column(name = "nullable", length = 25)
  public String getNullable() {
    return nullable;
  }

  public void setNullable(String nullable) {
    this.nullable = nullable;
  }

  @Column(name = "describtion", length = 100)
  public String getDescribtion() {
    return describtion;
  }

  public void setDescribtion(String describtion) {
    this.describtion = describtion;
  }

  @Column(name = "select1", length = 5)
  public String getSelect1() {
    return select1;
  }

  public void setSelect1(String select1) {
    this.select1 = select1;
  }

  @Column(name = "select2", length = 5)
  public String getSelect2() {
    return select2;
  }

  public void setSelect2(String select2) {
    this.select2 = select2;
  }

  @Column(name = "select3", length = 5)
  public String getSelect3() {
    return select3;
  }

  public void setSelect3(String select3) {
    this.select3 = select3;
  }

  @Column(name = "select4", length = 5)
  public String getSelect4() {
    return select4;
  }

  public void setSelect4(String select4) {
    this.select4 = select4;
  }

  @Column(name = "select5", length = 5)
  public String getSelect5() {
    return select5;
  }

  public void setSelect5(String select5) {
    this.select5 = select5;
  }

  @Column(name = "form", length = 10)
  public String getForm() {
    return form;
  }

  public void setForm(String form) {
    this.form = form;
  }

  @Column(name = "empty")
  public Boolean getEmpty() {
    return empty;
  }

  public void setEmpty(Boolean empty) {
    this.empty = empty;
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
    return "StockReq2{" +
        "id=" + id +
        ", allocRef=" + allocRef +
        ", clientCode='" + clientCode + '\'' +
        ", itemCode=" + itemCode +
        ", itemConf='" + itemConf + '\'' +
        ", parm1='" + parm1 + '\'' +
        ", parm2='" + parm2 + '\'' +
        ", parm3='" + parm3 + '\'' +
        ", parmN='" + parmN + '\'' +
        ", type='" + type + '\'' +
        ", category='" + category + '\'' +
        ", constant=" + constant +
        ", nullable='" + nullable + '\'' +
        ", describtion='" + describtion + '\'' +
        ", select1='" + select1 + '\'' +
        ", select2='" + select2 + '\'' +
        ", select3='" + select3 + '\'' +
        ", select4='" + select4 + '\'' +
        ", select5='" + select5 + '\'' +
        ", form='" + form + '\'' +
        ", empty=" + empty +
        ", dbDate=" + dbDate +
        '}';
  }
}

