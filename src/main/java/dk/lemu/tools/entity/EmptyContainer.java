package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "EmptyContainer.findByCategory", query = "SELECT object(o) FROM EmptyContainer o WHERE o.category = :category")
})
@Entity
@Table(name = "EmptyContainer", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "category")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "category"),
        @Index(columnList = "id, category")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EmptyContainer extends AbstractEntity implements Serializable {

  private Long id;
  private String category; //0
  private Integer parm1; //1
  private Integer parm2; //2

  public EmptyContainer() {

  }

  public EmptyContainer(List<String> list) throws Exception {
    this.setCategory(list.get(14));
    this.setParm1((Integer) TypeParser.fromCSVFile(Integer.class, list.get(14)));
    this.setParm2((Integer) TypeParser.fromCSVFile(Integer.class, list.get(14)));


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

  @Column(name = "category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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

  @Override
  public String toString() {
    return "EmptyContainer{" +
        "id=" + id +
        ", category='" + category + '\'' +
        ", parm1=" + parm1 +
        ", parm2=" + parm2 +
        '}';
  }
}

