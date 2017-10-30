package dk.lemu.tools.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractContainer extends AbstractEntity implements Serializable {
  public final static Integer TYPE_LOCATION = 0;
  public final static Integer TYPE_CONTAINER = 1;
  public final static Integer TYPE_VIRTUEL = 2;

  private Long id;

  private Integer locType;

  @Id
  @GenericGenerator(name = "josl", strategy = "increment")
  @GeneratedValue(generator = "josl")
  @Column(name = "id", unique = true, nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "locType", nullable = false)
  public Integer getLocType() {
    return locType;
  }

  public void setLocType(Integer locType) {
    this.locType = locType;
  }


}
