package dk.lemu.tools.entity;

import dk.lemu.tools.filehandler.TypeParser;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = "ContainerType.findByType", query = "SELECT object(ct) " +
        "FROM ContainerType ct WHERE ct.containerTypeCode = :typeId")
})
@Entity
@Table(name = "ContainerType", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "containerTypeCode")},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "id, containerTypeCode")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ContainerType extends AbstractEntity implements Serializable {

  private Long id;
  private Double emptyWeight = 0.0; //0
  private Double maxWeight; //1
  private Double maxHeight; //2
  private Double intHeight; //3
  private Double intWidth; //4
  private Double intLength; //5
  private Double extHeight; //6
  private Double extWidth; //7
  private Double extLength; //8
  private String containerTypeCode; //9
  private String lu; //10
  private String size; //11
  private Integer sizeNo; //12
  private String description; //13
  private Integer var1 = 0; //14
  private String velocityCode; //15
  private String groupInfo; //16
  private Integer numBox = 0; //17
  private Integer hand3; //18
  private Integer hand4; //19

  public ContainerType() {

  }

  public ContainerType(List<String> list) {
    this.setEmptyWeight((Double) TypeParser.fromCSVFile(Double.class, list.get(0)));
    this.setMaxWeight((Double) TypeParser.fromCSVFile(Double.class, list.get(1)));
    this.setMaxHeight((Double) TypeParser.fromCSVFile(Double.class, list.get(2)));
    this.setIntHeight((Double) TypeParser.fromCSVFile(Double.class, list.get(3)));
    this.setIntWidth((Double) TypeParser.fromCSVFile(Double.class, list.get(4)));
    this.setIntLength((Double) TypeParser.fromCSVFile(Double.class, list.get(5)));
    this.setExtHeight((Double) TypeParser.fromCSVFile(Double.class, list.get(6)));
    this.setExtWidth((Double) TypeParser.fromCSVFile(Double.class, list.get(7)));
    this.setExtLength((Double) TypeParser.fromCSVFile(Double.class, list.get(8)));
    this.setContainerTypeCode(list.get(9));
    this.setLu(list.get(10));
    this.setSize(list.get(11));
    this.setSizeNo((Integer) TypeParser.fromCSVFile(Integer.class, list.get(12)));
    this.setDescription(list.get(13));
    this.setVar1((Integer) TypeParser.fromCSVFile(Integer.class, list.get(14)));
    this.setVelocityCode(list.get(15));
    this.setVelocityCode(list.get(16));
    this.setNumBox((Integer) TypeParser.fromCSVFile(Integer.class, list.get(17)));
    this.setHand3((Integer) TypeParser.fromCSVFile(Integer.class, list.get(18)));
    this.setHand4((Integer) TypeParser.fromCSVFile(Integer.class, list.get(19)));
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

  @Column(name = "containerTypeCode", nullable = false)
  public String getContainerTypeCode() {
    return containerTypeCode;
  }

  public void setContainerTypeCode(String containerTypeCode) {
    this.containerTypeCode = containerTypeCode;
  }

  @Column(name = "description", nullable = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "groupInfo")
  public String getGroupInfo() {
    return groupInfo;
  }

  public void setGroupInfo(String groupInfo) {
    this.groupInfo = groupInfo;
  }

  @Column(name = "velocityCode")
  public String getVelocityCode() {
    return velocityCode;
  }

  public void setVelocityCode(String velocityCode) {
    this.velocityCode = velocityCode;
  }

  @Column(name = "emptyWeight")
  public Double getEmptyWeight() {
    return emptyWeight;
  }

  public void setEmptyWeight(Double emptyWeight) {
    this.emptyWeight = emptyWeight;
  }

  @Column(name = "maxWeight")
  public Double getMaxWeight() {
    return maxWeight;
  }

  public void setMaxWeight(Double maxWeight) {
    this.maxWeight = maxWeight;
  }

  @Column(name = "maxHeight")
  public Double getMaxHeight() {
    return maxHeight;
  }

  public void setMaxHeight(Double maxHeight) {
    this.maxHeight = maxHeight;
  }

  @Column(name = "intHeight")
  public Double getIntHeight() {
    return intHeight;
  }

  public void setIntHeight(Double intHeight) {
    this.intHeight = intHeight;
  }

  @Column(name = "intWidth")
  public Double getIntWidth() {
    return intWidth;
  }

  public void setIntWidth(Double intWidth) {
    this.intWidth = intWidth;
  }

  @Column(name = "intLength")
  public Double getIntLength() {
    return intLength;
  }

  public void setIntLength(Double intLength) {
    this.intLength = intLength;
  }

  @Column(name = "extHeight")
  public Double getExtHeight() {
    return extHeight;
  }

  public void setExtHeight(Double extHeight) {
    this.extHeight = extHeight;
  }

  @Column(name = "extWidth")
  public Double getExtWidth() {
    return extWidth;
  }

  public void setExtWidth(Double extWidth) {
    this.extWidth = extWidth;
  }

  @Column(name = "extLength")
  public Double getExtLength() {
    return extLength;
  }

  public void setExtLength(Double extLength) {
    this.extLength = extLength;
  }

  @Column(name = "lu")
  public String getLu() {
    return lu;
  }

  public void setLu(String lu) {
    this.lu = lu;
  }

  @Column(name = "size")
  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  @Column(name = "sizeNo")
  public Integer getSizeNo() {
    return sizeNo;
  }

  public void setSizeNo(Integer sizeNo) {
    this.sizeNo = sizeNo;
  }

  @Column(name = "var1")
  public Integer getVar1() {
    return var1;
  }

  public void setVar1(Integer var1) {
    this.var1 = var1;
  }

  @Column(name = "numBox")
  public Integer getNumBox() {
    return numBox;
  }

  public void setNumBox(Integer numBox) {
    this.numBox = numBox;
  }

  @Column(name = "hand3")
  public Integer getHand3() {
    return hand3;
  }

  public void setHand3(Integer hand3) {
    this.hand3 = hand3;
  }

  @Column(name = "hand4")
  public Integer getHand4() {
    return hand4;
  }

  public void setHand4(Integer hand4) {
    this.hand4 = hand4;
  }

  @Override
  public String toString() {
    return "ContainerType{" +
        "id=" + id +
        ", containerTypeCode='" + containerTypeCode + '\'' +
        ", description='" + description + '\'' +
        ", groupInfo='" + groupInfo + '\'' +
        ", velocityCode='" + velocityCode + '\'' +
        ", emptyWeight=" + emptyWeight +
        ", maxWeight=" + maxWeight +
        ", maxHeight=" + maxHeight +
        ", intHeight=" + intHeight +
        ", intWidth=" + intWidth +
        ", intLength=" + intLength +
        ", extHeight=" + extHeight +
        ", extWidth=" + extWidth +
        ", extLength=" + extLength +
        ", lu='" + lu + '\'' +
        ", size='" + size + '\'' +
        ", sizeNo=" + sizeNo +
        ", var1=" + var1 +
        ", numBox=" + numBox +
        ", hand2=" + hand3 +
        ", hand3=" + hand4 +
        '}';
  }
}
