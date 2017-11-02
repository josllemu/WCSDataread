package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "WorkStation.findByHostName", query = "SELECT object(o) FROM WorkStation o WHERE o.hostName = :hostName")
})
@Entity
@Table(name = "WorkStation",
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "hostName"),
        @Index(columnList = "id, hostName")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WorkStation extends AbstractEntity implements Serializable {

  private Long id;
  private String hostName; //0
  private String location; //1
  private String description; //2
  private String documentPrinter; //3
  private String labelPrinter; //4
  private String mhe; //5
  private String guidePrinter; //6
  private String trotterPrinter; //7


  public WorkStation() {

  }

  public WorkStation(List<String> list) throws Exception {
    this.setHostName((String) TypeParser.fromCSVFile(String.class, list.get(0)));
    this.setLocation((String) TypeParser.fromCSVFile(String.class, list.get(1)));
    this.setDescription((String) TypeParser.fromCSVFile(String.class, list.get(2)));
    this.setDocumentPrinter((String) TypeParser.fromCSVFile(String.class, list.get(3)));
    this.setLabelPrinter((String) TypeParser.fromCSVFile(String.class, list.get(4)));
    this.setMhe((String) TypeParser.fromCSVFile(String.class, list.get(5)));
    this.setGuidePrinter((String) TypeParser.fromCSVFile(String.class, list.get(6)));
    this.setTrotterPrinter((String) TypeParser.fromCSVFile(String.class, list.get(7)));


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

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDocumentPrinter() {
    return documentPrinter;
  }

  public void setDocumentPrinter(String documentPrinter) {
    this.documentPrinter = documentPrinter;
  }

  public String getLabelPrinter() {
    return labelPrinter;
  }

  public void setLabelPrinter(String labelPrinter) {
    this.labelPrinter = labelPrinter;
  }

  public String getMhe() {
    return mhe;
  }

  public void setMhe(String mhe) {
    this.mhe = mhe;
  }

  public String getGuidePrinter() {
    return guidePrinter;
  }

  public void setGuidePrinter(String guidePrinter) {
    this.guidePrinter = guidePrinter;
  }

  public String getTrotterPrinter() {
    return trotterPrinter;
  }

  public void setTrotterPrinter(String trotterPrinter) {
    this.trotterPrinter = trotterPrinter;
  }

}

