
package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
    @NamedQuery(name = "ConfigurationCode.findbyConfigurationCode", query = "SELECT object(cc) FROM ConfigurationCode cc " +
        "WHERE cc.code = :code_id")
})
@Entity
@Table(name = "configurationcode", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id")},
    indexes = {
        @Index(columnList = "id")})

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ConfigurationCode extends AbstractEntity implements Serializable {

  private Long id;
  private String code;

  @Id
  @GenericGenerator(name="josl" , strategy="increment")
  @GeneratedValue(generator="josl")
  @Column(name = "Id", unique = true, nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "code", unique = true, nullable = false)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "ConfigurationCode{" +
        "id=" + id +
        ", code='" + code + '\'' +
        '}';
  }

}

