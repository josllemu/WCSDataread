package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "ContainerSize.findByUnit", query = "SELECT object(o) FROM ContainerSize o WHERE o.unit = :unit")
})
@Entity
@Table(name = "ContainerSize", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "unit")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "unit"),
        @Index(columnList = "id, unit")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ContainerSize extends AbstractEntity implements Serializable {

  private Long id;
  private Integer unit; //0
  private String parmP; //1
  private Integer size1; //2
  private Integer size2; //3
  private Integer parm4; //4

  public ContainerSize() {

  }

  public ContainerSize(List<String> list) throws Exception {
    this.setUnit((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setParmP(list.get(1));
    this.setSize1((Integer) TypeParser.fromCSVFile(Integer.class, list.get(2)));
    this.setSize2((Integer) TypeParser.fromCSVFile(Integer.class, list.get(3)));
    this.setParm4((Integer) TypeParser.fromCSVFile(Integer.class, list.get(4)));


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

  @Column(name = "unit", unique = true)
  public Integer getUnit() {
    return unit;
  }

  public void setUnit(Integer unit) {
    this.unit = unit;
  }

  @Column(name = "parmP")
  public String getParmP() {
    return parmP;
  }

  public void setParmP(String parmP) {
    this.parmP = parmP;
  }

  @Column(name = "size1")
  public Integer getSize1() {
    return size1;
  }

  public void setSize1(Integer size1) {
    this.size1 = size1;
  }

  @Column(name = "size2")
  public Integer getSize2() {
    return size2;
  }

  public void setSize2(Integer size2) {
    this.size2 = size2;
  }

  @Column(name = "parm4")
  public Integer getParm4() {
    return parm4;
  }

  public void setParm4(Integer parm4) {
    this.parm4 = parm4;
  }
}

