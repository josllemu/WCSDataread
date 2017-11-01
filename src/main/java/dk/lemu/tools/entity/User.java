package dk.lemu.tools.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "User.findByUserName", query = "SELECT object(o) FROM User o WHERE o.username = :username")
})
@Entity
@Table(name = "User",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "username"),
        @Index(columnList = "id, username")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends AbstractEntity implements Serializable {

  private Long id;
  private String username;
  private Integer type;
  private Integer sequence;
  private String password;
  private String profile;
  private Date expiryDate;
  private Integer timeout;
  private String action;
  private Integer pwdlife;
  private Integer status;
  private String options;
  private String shortcut;
  private String locale;


  public User() {

  }

  public User(List<String> list) throws Exception {


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

  @Column(name = "username", unique = true, nullable = false)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Column(name = "type")
  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  @Column(name = "sequence")
  public Integer getSequence() {
    return sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  @Column(name = "password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name = "profile")
  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  @Column(name = "expiryDate")
  public Date getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }

  @Column(name = "timeout")
  public Integer getTimeout() {
    return timeout;
  }

  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }

  @Column(name = "action")
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  @Column(name = "pwdlife")
  public Integer getPwdlife() {
    return pwdlife;
  }

  public void setPwdlife(Integer pwdlife) {
    this.pwdlife = pwdlife;
  }

  @Column(name = "status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Column(name = "options")
  public String getOptions() {
    return options;
  }

  public void setOptions(String options) {
    this.options = options;
  }

  @Column(name = "shortcut")
  public String getShortcut() {
    return shortcut;
  }

  public void setShortcut(String shortcut) {
    this.shortcut = shortcut;
  }

  @Column(name = "locale")
  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", type=" + type +
        ", sequence=" + sequence +
        ", password='" + password + '\'' +
        ", profile='" + profile + '\'' +
        ", expiryDate=" + expiryDate +
        ", timeout=" + timeout +
        ", action='" + action + '\'' +
        ", pwdlife=" + pwdlife +
        ", status=" + status +
        ", options='" + options + '\'' +
        ", shortcut='" + shortcut + '\'' +
        ", locale='" + locale + '\'' +
        '}';
  }
}

