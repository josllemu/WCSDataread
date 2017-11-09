package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "PickCategory.findByFunc", query = "SELECT object(o) FROM PickCategory o WHERE o.func = :func")
})
@Entity
@Table(name = "PickCategory",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "func"),
        @Index(columnList = "id, func")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PickCategory extends AbstractEntity implements Serializable {

  private Long id;
  private Integer func; //0
  private String type; //1
  private String handling; //2
  private String parmX; //3
  private Integer value; //4


  public PickCategory() {

  }

  public PickCategory(List<String> list) throws Exception {
    this.setFunc((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setType(list.get(1));
    this.setHandling(list.get(2));
    this.setParmX(list.get(3));
    this.setValue((Integer) TypeParser.fromCSVFile(Integer.class, list.get(4)));
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

  @Column(name = "func", unique = true, nullable = false)
  public Integer getFunc() {
    return func;
  }

  public void setFunc(Integer func) {
    this.func = func;
  }

  @Column(name = "type", length = 10)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Column(name = "handling", length = 50)
  public String getHandling() {
    return handling;
  }

  public void setHandling(String handling) {
    this.handling = handling;
  }

  @Column(name = "parmX", length = 50)
  public String getParmX() {
    return parmX;
  }

  public void setParmX(String parmX) {
    this.parmX = parmX;
  }

  @Column(name = "value")
  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "PickCategory{" +
        "id=" + id +
        ", func=" + func +
        ", type='" + type + '\'' +
        ", handling='" + handling + '\'' +
        ", parmX='" + parmX + '\'' +
        ", value=" + value +
        '}';
  }
}

