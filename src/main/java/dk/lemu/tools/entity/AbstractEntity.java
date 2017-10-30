package dk.lemu.tools.entity;


import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue
  @Column(name = "Id")
  private Long id;

  @Version
  private long version;

  @Column(name = "Version", nullable = false)
  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

}