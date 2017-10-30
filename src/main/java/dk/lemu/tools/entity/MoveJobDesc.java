package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "MoveJobDesc.findByMoveJob", query = "SELECT object(o) FROM MoveJobDesc o WHERE o.moveJob = :moveJob")
})
@Entity
@Table(name = "MoveJobDesc", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "moveJob")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "moveJob"),
        @Index(columnList = "id, moveJob")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MoveJobDesc extends AbstractEntity implements Serializable {

  private Long id;
  private String moveJob; //0
  private Integer jobNo; //1
  private String description; //2


  public MoveJobDesc() {

  }

  public MoveJobDesc(List<String> list) throws Exception {


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

  public String getMoveJob() {
    return moveJob;
  }

  public void setMoveJob(String moveJob) {
    this.moveJob = moveJob;
  }

  public Integer getJobNo() {
    return jobNo;
  }

  public void setJobNo(Integer jobNo) {
    this.jobNo = jobNo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "MoveJobDesc{" +
        "id=" + id +
        ", moveJob='" + moveJob + '\'' +
        ", jobNo=" + jobNo +
        ", description='" + description + '\'' +
        '}';
  }

}

