package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
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
  private String username; //0
  private Integer type; //1
  private Integer sequence; //2
  private String password; //3
  private String profile; //4
  private Date expiryDate; //5
  private Integer timeout; //6
  private String action; //7
  private Integer pwdlife; //8
  private Integer status; //9
  private String options; //10
  private String shortcut; //11
  private String locale; //12


  public User() {

  }

  public User(List<String> list) throws Exception {
    this.setUsername((String) TypeParser.fromCSVFile(String.class, list.get(0)));
    this.setType((Integer) TypeParser.fromCSVFile(Integer.class, list.get(1)));
    this.setSequence((Integer) TypeParser.fromCSVFile(Integer.class, list.get(2)));
    this.setPassword((String) TypeParser.fromCSVFile(String.class, list.get(3)));
    this.setProfile((String) TypeParser.fromCSVFile(String.class, list.get(4)));
    this.setExpiryDate((Date) TypeParser.fromCSVFile(Date.class, list.get(5)));
    this.setTimeout((Integer) TypeParser.fromCSVFile(Integer.class, list.get(6)));
    this.setAction((String) TypeParser.fromCSVFile(String.class, list.get(7)));
    this.setPwdlife((Integer) TypeParser.fromCSVFile(Integer.class, list.get(8)));
    this.setStatus((Integer) TypeParser.fromCSVFile(Integer.class, list.get(9)));
    this.setOptions((String) TypeParser.fromCSVFile(String.class, list.get(10)));
    this.setShortcut((String) TypeParser.fromCSVFile(String.class, list.get(11)));
    this.setLocale((String) TypeParser.fromCSVFile(String.class, list.get(12)));


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

  @Column(name = "username", unique = true, nullable = false, length = 50)
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

  @Column(name = "password", length = 50)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name = "profile", length = 50)
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

  @Column(name = "action", length = 50)
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

  @Column(name = "options", length = 5)
  public String getOptions() {
    return options;
  }

  public void setOptions(String options) {
    this.options = options;
  }

  @Column(name = "shortcut", length = 5)
  public String getShortcut() {
    return shortcut;
  }

  public void setShortcut(String shortcut) {
    this.shortcut = shortcut;
  }

  @Column(name = "locale", length = 15)
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

