package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "MHEError.findByErrorTimeErrorCodeAndType", query = "SELECT object(o) FROM MHEError o WHERE o.errorTime = :errorTime " +
        "AND o.errorCode = :errorCode AND o.type = :type")
})
@Entity
@Table(name = "MHEError", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"type", "errorTime", "errorCode"})},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, type, errorCode")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MHEError extends AbstractEntity implements Serializable {

  private Long id;
  private Date errorTime; //0
  private Integer type; //2
  private Integer count; //3
  private Integer errorCode; //4

  public MHEError() {

  }

  public MHEError(List<String> list) throws Exception {

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

  @Column(name = "errorTime")
  public Date getErrorTime() {
    return errorTime;
  }

  public void setErrorTime(Date errorTime) {
    this.errorTime = errorTime;
  }

  @Column(name = "type")
  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  @Column(name = "count")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  @Column(name = "errorCode")
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }
}

