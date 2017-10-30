package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "LMGSSCC.findById", query = "SELECT object(o) FROM LMGSSCC o WHERE o.id = :id")
})
@Entity
@Table(name = "LMGSSCC", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id")},
    indexes = {
        @Index(columnList = "id")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LMGSSCC extends AbstractEntity implements Serializable {

  private Long id;







  public LMGSSCC() {

  }

  public LMGSSCC(List<String> list) throws Exception {


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

}

