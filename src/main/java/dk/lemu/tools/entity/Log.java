package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedQueries({
    @NamedQuery(name = "Log.findByPath", query = "SELECT object(o) FROM Log o WHERE o.path = :path")
})
@Entity
@Table(name = "Log", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"path", "runDay"})},

    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "path"),
        @Index(columnList = "id, path")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Log extends AbstractEntity implements Serializable {

  private Long id;
  private String description;
  private String path;
  private Date runDay = new Date();
  private Long runTime;
  private Long numLines;
  private String fileName;
  private Long size;

  public Log() {

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

  @Column(name = "path", length = 150)
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  @Column(name = "runDay")
  public Date getRunDay() {
    return runDay;
  }

  public void setRunDay(Date runDay) {
    this.runDay = runDay;
  }

  @Column(name = "runTime")
  public Long getRunTime() {
    return runTime;
  }

  public void setRunTime(Long runTime) {
    this.runTime = runTime;
  }

  @Column(name = "numLines")
  public Long getNumLines() {
    return numLines;
  }

  public void setNumLines(Long numLines) {
    this.numLines = numLines;
  }

  @Column(name = "description", length = 500)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "fileName", length = 40)
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @Column(name = "size")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "Log{" +
        "id=" + id +
        ", description='" + description + '\'' +
        ", path='" + path + '\'' +
        ", runDay=" + runDay +
        ", runTime=" + runTime +
        ", numLines=" + numLines +
        ", fileName='" + fileName + '\'' +
        ", size=" + size +
        '}';
  }
}

