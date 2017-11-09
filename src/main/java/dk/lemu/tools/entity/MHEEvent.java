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
    @NamedQuery(name = "MHEEvent.findByMHEId", query = "SELECT object(o) FROM MHEEvent o WHERE o.mheId = :mheId")
})
@Entity
@Table(name = "MHEEvent",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "mheId"),
        @Index(columnList = "id, mheId")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MHEEvent extends AbstractEntity implements Serializable {

  private Long id;
  private Integer mheId; //0
  private Date eventTime; //1
  private String value1; //2
  private Integer value2; //3
  private String value3; //4
  private String value4; //5

  public MHEEvent() {

  }

  public MHEEvent(List<String> list) throws Exception {
    this.setMheId((Integer) TypeParser.fromCSVFile(Integer.class, list.get(0)));
    this.setEventTime((Date) TypeParser.fromCSVFile(Date.class, list.get(1)));
    this.setValue1(list.get(2));
    this.setValue2((Integer) TypeParser.fromCSVFile(Integer.class, list.get(3)));
    this.setValue3(list.get(4));
    this.setValue4(list.get(5));

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

  @Column(name = "mheId", unique = true, nullable = false)
  public Integer getMheId() {
    return mheId;
  }

  public void setMheId(Integer mheId) {
    this.mheId = mheId;
  }

  @Column(name = "eventTime")
  public Date getEventTime() {
    return eventTime;
  }

  public void setEventTime(Date eventTime) {
    this.eventTime = eventTime;
  }

  @Column(name = "value1", length = 50)
  public String getValue1() {
    return value1;
  }

  public void setValue1(String value1) {
    this.value1 = value1;
  }

  @Column(name = "value2")
  public Integer getValue2() {
    return value2;
  }

  public void setValue2(Integer value2) {
    this.value2 = value2;
  }

  @Column(name = "value3", length = 50)
  public String getValue3() {
    return value3;
  }

  public void setValue3(String value3) {
    this.value3 = value3;
  }

  @Column(name = "value4", length = 50)
  public String getValue4() {
    return value4;
  }

  public void setValue4(String value4) {
    this.value4 = value4;
  }

  @Override
  public String toString() {
    return "MHEEvent{" +
        "id=" + id +
        ", mheId=" + mheId +
        ", eventTime=" + eventTime +
        ", value1='" + value1 + '\'' +
        ", value2=" + value2 +
        ", value3='" + value3 + '\'' +
        ", value4='" + value4 + '\'' +
        '}';
  }
}

