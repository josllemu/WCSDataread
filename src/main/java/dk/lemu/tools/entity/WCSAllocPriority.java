package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "WCSAllocPriority",
    indexes = {
        @Index(columnList = "id")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WCSAllocPriority extends AbstractEntity implements Serializable {

  private Long id;
  private String column1; //0
  private Integer column2; //1
  private Integer column3; //2
  private Integer column4; //3
  private Integer column5; //4
  private Integer column6; //5
  private Integer column7; //6
  private Integer column8; //7
  private Integer column9; //8
  private Double column10; //9
  private Double column11; //10
  private Double column12; //11
  private Double column13; //12
  private Integer column14; //13
  private Date dbDate = new Date();



  public WCSAllocPriority() {

  }

  public WCSAllocPriority(List<String> list) throws Exception {
    this.setColumn1((String) TypeParser.fromCSVFile(String.class, list.get(0)));
    this.setColumn2((Integer) TypeParser.fromCSVFile(Integer.class, list.get(1)));
    this.setColumn3((Integer) TypeParser.fromCSVFile(Integer.class, list.get(2)));
    this.setColumn4((Integer) TypeParser.fromCSVFile(Integer.class, list.get(3)));
    this.setColumn5((Integer) TypeParser.fromCSVFile(Integer.class, list.get(4)));
    this.setColumn6((Integer) TypeParser.fromCSVFile(Integer.class, list.get(5)));
    this.setColumn7((Integer) TypeParser.fromCSVFile(Integer.class, list.get(6)));
    this.setColumn8((Integer) TypeParser.fromCSVFile(Integer.class, list.get(7)));
    this.setColumn9((Integer) TypeParser.fromCSVFile(Integer.class, list.get(8)));
    this.setColumn10((Double) TypeParser.fromCSVFile(Double.class, list.get(9)));
    this.setColumn11((Double) TypeParser.fromCSVFile(Double.class, list.get(10)));
    this.setColumn12((Double) TypeParser.fromCSVFile(Double.class, list.get(11)));
    this.setColumn13((Double) TypeParser.fromCSVFile(Double.class, list.get(12)));
    this.setColumn14((Integer) TypeParser.fromCSVFile(Integer.class, list.get(13)));

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

  @Column(name = "column1", length = 50)
  public String getColumn1() {
    return column1;
  }

  public void setColumn1(String column1) {
    this.column1 = column1;
  }

  @Column(name = "column2")
  public Integer getColumn2() {
    return column2;
  }

  public void setColumn2(Integer column2) {
    this.column2 = column2;
  }

  @Column(name = "column3")
  public Integer getColumn3() {
    return column3;
  }

  public void setColumn3(Integer column3) {
    this.column3 = column3;
  }

  @Column(name = "column4")
  public Integer getColumn4() {
    return column4;
  }

  public void setColumn4(Integer column4) {
    this.column4 = column4;
  }

  @Column(name = "column5")
  public Integer getColumn5() {
    return column5;
  }

  public void setColumn5(Integer column5) {
    this.column5 = column5;
  }

  @Column(name = "column6")
  public Integer getColumn6() {
    return column6;
  }

  public void setColumn6(Integer column6) {
    this.column6 = column6;
  }

  @Column(name = "column7")
  public Integer getColumn7() {
    return column7;
  }

  public void setColumn7(Integer column7) {
    this.column7 = column7;
  }

  @Column(name = "column8")
  public Integer getColumn8() {
    return column8;
  }

  public void setColumn8(Integer column8) {
    this.column8 = column8;
  }

  @Column(name = "column9")
  public Integer getColumn9() {
    return column9;
  }

  public void setColumn9(Integer column9) {
    this.column9 = column9;
  }

  @Column(name = "column10")
  public Double getColumn10() {
    return column10;
  }

  public void setColumn10(Double column10) {
    this.column10 = column10;
 }

  @Column(name = "column11")
  public Double getColumn11() {
    return column11;
  }

  public void setColumn11(Double column11) {
    this.column11 = column11;
  }

  @Column(name = "column12")
  public Double getColumn12() {
    return column12;
  }

  public void setColumn12(Double column12) {
    this.column12 = column12;
  }

  public Double getColumn13() {
    return column13;
  }

  @Column(name = "column13")
  public void setColumn13(Double column13) {
    this.column13 = column13;
  }

  public Integer getColumn14() {
    return column14;
  }

  @Column(name = "column14")
  public void setColumn14(Integer column14) {
    this.column14 = column14;
  }

  public Date getDbDate() {
    return dbDate;
  }

  public void setDbDate(Date dbDate) {
    this.dbDate = dbDate;
  }

  @Override
  public String toString() {
    return "WCSAllocPriority{" +
        "id=" + id +
        ", column1='" + column1 + '\'' +
        ", column2=" + column2 +
        ", column3=" + column3 +
        ", column4=" + column4 +
        ", column5=" + column5 +
        ", column6=" + column6 +
        ", column7=" + column7 +
        ", column8=" + column8 +
        ", column9=" + column9 +
        ", column10=" + column10 +
        ", column11=" + column11 +
        ", column12=" + column12 +
        ", column13=" + column13 +
        ", column14=" + column14 +
        ", dbDate=" + dbDate +
        '}';
  }
}

