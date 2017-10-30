package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "WMSOrderLine.findByUnit", query = "SELECT object(o) FROM WMSOrderLine o WHERE o.unit = :unit")
})
@Entity
@Table(name = "WMSOrderLine", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "unit")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "unit"),
        @Index(columnList = "id, unit")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WMSOrderLine extends AbstractEntity implements Serializable {

  private Long id;
  private String unit;







  public WMSOrderLine() {

  }

  public WMSOrderLine(List<String> list) throws Exception {


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

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }
}
