package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "MHEErrorDesc.findByDescription", query = "SELECT object(o) FROM MHEErrorDesc o WHERE o.description = :description")
})
@Entity
@Table(name = "MHEErrorDesc",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "description"),
        @Index(columnList = "id, description")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MHEErrorDesc extends AbstractEntity implements Serializable {

  private Long id;
  private Integer type; //0
  private Integer errorCode; //1
  private Integer errorSubCode; //2
  private String description; //3

  public MHEErrorDesc() {

  }

  public MHEErrorDesc(List<String> list) throws Exception {
    this.setType((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setErrorCode((Integer) TypeParser.fromCSVFile(Integer.class, list.get(1)));
    this.setErrorSubCode((Integer) TypeParser.fromCSVFile(Integer.class, list.get(2)));
    this.setDescription(list.get(3));
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

  @Column(name = "type")
  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  @Column(name = "errorCode")
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  @Column(name = "errorSubCode")
  public Integer getErrorSubCode() {
    return errorSubCode;
  }

  public void setErrorSubCode(Integer errorSubCode) {
    this.errorSubCode = errorSubCode;
  }

  @Column(name = "description", unique = true)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "MHEErrorDesc{" +
        "id=" + id +
        ", type=" + type +
        ", errorCode=" + errorCode +
        ", errorSubCode=" + errorSubCode +
        ", description='" + description + '\'' +
        '}';
  }
}


