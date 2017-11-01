package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "MHEInfo.findByUnit", query = "SELECT object(o) FROM MHEInfo o WHERE o.unit = :unit")
})
@Entity
@Table(name = "MHEInfo", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "unit")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "unit"),
        @Index(columnList = "id, unit")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MHEInfo extends AbstractEntity implements Serializable {

  private Long id;
  private String unit; //0 //Workstation or location
  private Integer parm1; //1
  private Integer parm2; //2
  private Integer parm3; //3
  private Integer parm4; //4
  private Integer parm5; //5
  private Integer parm6; //6
  private Integer parm7; //7
  private Integer parm8; //8
  private Integer parm9; //9
  private String area1; //10
  private String area2; //11
  private String area3; //12
  private String area4; //13
  private String empty; //14
  private String type1; //15
  private String type2; //16
  private String type3; //17
  private String name; //18
  private String dualOnly; //19
  private String nullable; //20
  private String handling; //21
  private Integer dec1; //22
  private Integer dec2; //23


  public MHEInfo() {

  }

  public MHEInfo(List<String> list) throws Exception {


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

  @Column(name = "unit")
  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Column(name = "parm1")
  public Integer getParm1() {
    return parm1;
  }

  public void setParm1(Integer parm1) {
    this.parm1 = parm1;
  }

  @Column(name = "parm2")
  public Integer getParm2() {
    return parm2;
  }

  public void setParm2(Integer parm2) {
    this.parm2 = parm2;
  }

  @Column(name = "parm3")
  public Integer getParm3() {
    return parm3;
  }

  public void setParm3(Integer parm3) {
    this.parm3 = parm3;
  }

  @Column(name = "parm4")
  public Integer getParm4() {
    return parm4;
  }

  public void setParm4(Integer parm4) {
    this.parm4 = parm4;
  }

  @Column(name = "parm5")
  public Integer getParm5() {
    return parm5;
  }

  public void setParm5(Integer parm5) {
    this.parm5 = parm5;
  }

  @Column(name = "parm6")
  public Integer getParm6() {
    return parm6;
  }

  public void setParm6(Integer parm6) {
    this.parm6 = parm6;
  }

  @Column(name = "parm7")
  public Integer getParm7() {
    return parm7;
  }

  public void setParm7(Integer parm7) {
    this.parm7 = parm7;
  }

  @Column(name = "parm8")
  public Integer getParm8() {
    return parm8;
  }

  public void setParm8(Integer parm8) {
    this.parm8 = parm8;
  }

  @Column(name = "parm9")
  public Integer getParm9() {
    return parm9;
  }

  public void setParm9(Integer parm9) {
    this.parm9 = parm9;
  }

  @Column(name = "area1")
  public String getArea1() {
    return area1;
  }

  public void setArea1(String area1) {
    this.area1 = area1;
  }

  @Column(name = "area2")
  public String getArea2() {
    return area2;
  }

  public void setArea2(String area2) {
    this.area2 = area2;
  }

  @Column(name = "area3")
  public String getArea3() {
    return area3;
  }

  public void setArea3(String area3) {
    this.area3 = area3;
  }

  @Column(name = "area4")
  public String getArea4() {
    return area4;
  }

  public void setArea4(String area4) {
    this.area4 = area4;
  }

  @Column(name = "empty")
  public String getEmpty() {
    return empty;
  }

  public void setEmpty(String empty) {
    this.empty = empty;
  }

  @Column(name = "type1")
  public String getType1() {
    return type1;
  }

  public void setType1(String type1) {
    this.type1 = type1;
  }

  @Column(name = "type2")
  public String getType2() {
    return type2;
  }

  public void setType2(String type2) {
    this.type2 = type2;
  }

  @Column(name = "type3")
  public String getType3() {
    return type3;
  }

  public void setType3(String type3) {
    this.type3 = type3;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "dualOnly")
  public String getDualOnly() {
    return dualOnly;
  }

  public void setDualOnly(String dualOnly) {
    this.dualOnly = dualOnly;
  }

  @Column(name = "nullable")
  public String getNullable() {
    return nullable;
  }

  public void setNullable(String nullable) {
    this.nullable = nullable;
  }

  @Column(name = "handling")
  public String getHandling() {
    return handling;
  }

  public void setHandling(String handling) {
    this.handling = handling;
  }

  @Column(name = "dec1")
  public Integer getDec1() {
    return dec1;
  }

  public void setDec1(Integer dec1) {
    this.dec1 = dec1;
  }

  @Column(name = "dec2")
  public Integer getDec2() {
    return dec2;
  }

  public void setDec2(Integer dec2) {
    this.dec2 = dec2;
  }

  @Override
  public String toString() {
    return "MHEInfo{" +
        "id=" + id +
        ", unit='" + unit + '\'' +
        ", parm1=" + parm1 +
        ", parm2=" + parm2 +
        ", parm3=" + parm3 +
        ", parm4=" + parm4 +
        ", parm5=" + parm5 +
        ", parm6=" + parm6 +
        ", parm7=" + parm7 +
        ", parm8=" + parm8 +
        ", parm9=" + parm9 +
        ", area1='" + area1 + '\'' +
        ", area2='" + area2 + '\'' +
        ", area3='" + area3 + '\'' +
        ", area4='" + area4 + '\'' +
        ", empty='" + empty + '\'' +
        ", type1='" + type1 + '\'' +
        ", type2='" + type2 + '\'' +
        ", type3='" + type3 + '\'' +
        ", name='" + name + '\'' +
        ", dualOnly='" + dualOnly + '\'' +
        ", nullable='" + nullable + '\'' +
        ", handling='" + handling + '\'' +
        ", dec1=" + dec1 +
        ", dec2=" + dec2 +
        '}';
  }
}


