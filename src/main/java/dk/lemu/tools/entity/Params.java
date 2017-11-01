package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "Params.findByParms", query = "SELECT object(o) FROM Params o WHERE o.parms = :parms")
})
@Entity
@Table(name = "Params", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "parms")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "parms"),
        @Index(columnList = "id, parms")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Params extends AbstractEntity implements Serializable {

  private Long id;
  private String parms; //0
  private String value; //1


  public Params() {

  }

  public Params(List<String> list) throws Exception {


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

  @Column(name = "parms", unique = true)
  public String getParms() {
    return parms;
  }

  public void setParms(String parms) {
    this.parms = parms;
  }

  @Column(name = "value")
  public String getValues() {
    return value;
  }

  public void setValues(String values) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Params{" +
        "id=" + id +
        ", parms='" + parms + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}

