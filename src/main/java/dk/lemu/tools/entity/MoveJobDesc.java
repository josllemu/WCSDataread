package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
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
@Table(name = "MoveJobDesc",
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
    this.setMoveJob(list.get(0));
    this.setJobNo((Integer) TypeParser.fromCSVFile(Integer.class, list.get(1)));
    this.setDescription(list.get(2));

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

  @Column(name = "moveJob", unique = true, nullable = false, length = 50)
  public String getMoveJob() {
    return moveJob;
  }

  public void setMoveJob(String moveJob) {
    this.moveJob = moveJob;
  }

  @Column(name = "jobNo")
  public Integer getJobNo() {
    return jobNo;
  }

  public void setJobNo(Integer jobNo) {
    this.jobNo = jobNo;
  }

  @Column(name = "description", length = 50)
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

