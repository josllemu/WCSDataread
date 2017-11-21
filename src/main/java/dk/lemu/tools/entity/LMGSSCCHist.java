package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "LMGSSCCHist.findBySSCC", query = "SELECT object(o) FROM LMGSSCCHist o WHERE o.sscc = :sscc")
})
@Entity
@Table(name = "LMGSSCCHist",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "container"),
        @Index(columnList = "sscc"),
        @Index(columnList = "id, container"),
        @Index(columnList = "id, container, sscc"),
        @Index(columnList = "id, sscc")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LMGSSCCHist extends AbstractEntity implements Serializable {

  private Long id;
  private String container; //0 //qualified ID is with running numbering, no reference to Container
  private Integer sequenceNumber; //1
  private String sscc; //2 with no leading zeroes, no direct link to CustomerLabel because of this
  private Integer packageNo; //3

  public LMGSSCCHist() {

  }

  public LMGSSCCHist(List<String> list) throws Exception {
    this.setContainer(list.get(0));
    this.setSequenceNumber((Integer) TypeParser.fromCSVFile(Integer.class, list.get(1)));
    this.setSscc(list.get(2));
    this.setPackageNo((Integer) TypeParser.fromCSVFile(Integer.class, list.get(3)));

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


  @Column(name = "container", length = 50)
  public String getContainer() {
    return container;
  }

  public void setContainer(String container) {
    this.container = container;
  }

  @Column(name = "sequenceNumber")
  public Integer getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  @Column(name = "sscc", length = 50)
  public String getSscc() {
    return sscc;
  }

  public void setSscc(String sscc) {
    this.sscc = sscc;
  }

  @Column(name = "packageNo")
  public Integer getPackageNo() {
    return packageNo;
  }

  public void setPackageNo(Integer packageNo) {
    this.packageNo = packageNo;
  }

  @Override
  public String toString() {
    return "LMGSSCCHist{" +
        "id=" + id +
        ", container='" + container + '\'' +
        ", sequenceNumber=" + sequenceNumber +
        ", sscc='" + sscc + '\'' +
        ", packageNo=" + packageNo +
        '}';
  }
}
