package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
    @NamedQuery(name = "Config.findByConfiguration", query = "SELECT object(o) FROM Config o WHERE o.configuration = :configuration")
})
@Entity
@Table(name = "Config",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "configuration"),
        @Index(columnList = "id, configuration")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Config extends AbstractEntity implements Serializable {

  private Long id;
  private String configuration = "Singleton";
  private String path;
  private String folder;
  private String logPath;
  private String restartPoint;

  public Config() {

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

  @Column(name = "configuration", unique = true)
  public String getConfiguration() {
    return configuration;
  }

  public void setConfiguration(String configuration) {
    this.configuration = configuration;
  }

  @Column(name = "path", unique = true)
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  @Column(name = "folder", unique = true)
  public String getFolder() {
    return folder;
  }

  public void setFolder(String folder) {
    this.folder = folder;
  }

  @Column(name = "logPath", unique = true)
  public String getLogPath() {
    return logPath;
  }

  public void setLogPath(String logPath) {
    this.logPath = logPath;
  }

  @Column(name = "restartPoint", unique = true)
  public String getRestartPoint() {
    return restartPoint;
  }

  public void setRestartPoint(String restartPoint) {
    this.restartPoint = restartPoint;
  }

  @Override
  public String toString() {
    return "Config{" +
        "id=" + id +
        ", configuration='" + configuration + '\'' +
        ", path='" + path + '\'' +
        ", folder='" + folder + '\'' +
        ", logPath='" + logPath + '\'' +
        ", restartPoint='" + restartPoint + '\'' +
        '}';
  }
}

