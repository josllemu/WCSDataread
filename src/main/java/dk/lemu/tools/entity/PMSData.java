package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "PMSData.findByZoneParm1AndParm2", query = "SELECT object(o) FROM PMSData o " +
        "WHERE o.zone = :zone AND o.parm1 = :parm1 AND o.parm2 = :parm2")
})
@Entity
@Table(name = "PMSData", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"zone", "parm1", "parm2"})},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, zone, parm1, parm2")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PMSData extends AbstractEntity implements Serializable {

  private Long id;
  private Integer zone; //0
  private String jobType; //1
  private String area; //2
  private Integer parm1; //3
  private Integer parm2; //4
  private Integer parm3; //5
  private Integer parm4; //6
  private Integer parm5; //7
  private Integer parm6; //8
  private Integer parm7; //9
  private Integer parm8; //10

  public PMSData() {

  }

  public PMSData(List<String> list) throws Exception {
    this.setZone((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setJobType(list.get(1));
    this.setArea(list.get(2));
    this.setParm1((Integer) TypeParser.fromCSVFile(Integer.class, list.get(3)));
    this.setParm2((Integer) TypeParser.fromCSVFile(Integer.class, list.get(4)));
    this.setParm3((Integer) TypeParser.fromCSVFile(Integer.class, list.get(5)));
    this.setParm4((Integer) TypeParser.fromCSVFile(Integer.class, list.get(6)));
    this.setParm5((Integer) TypeParser.fromCSVFile(Integer.class, list.get(7)));
    this.setParm6((Integer) TypeParser.fromCSVFile(Integer.class, list.get(8)));
    this.setParm7((Integer) TypeParser.fromCSVFile(Integer.class, list.get(9)));
    this.setParm8((Integer) TypeParser.fromCSVFile(Integer.class, list.get(10)));


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

  @Column(name = "zone")
  public Integer getZone() {
    return zone;
  }

  public void setZone(Integer zone) {
    this.zone = zone;
  }

  @Column(name = "jobType")
  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  @Column(name = "area")
  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
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

  @Override
  public String toString() {
    return "PMSData{" +
        "id=" + id +
        ", zone=" + zone +
        ", jobType='" + jobType + '\'' +
        ", area='" + area + '\'' +
        ", parm1=" + parm1 +
        ", parm2=" + parm2 +
        ", parm3=" + parm3 +
        ", parm4=" + parm4 +
        ", parm5=" + parm5 +
        ", parm6=" + parm6 +
        ", parm7=" + parm7 +
        ", parm8=" + parm8 +
        '}';
  }
}

