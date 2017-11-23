package dk.lemu.tools.entity;

import dk.lemu.tools.dao.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@NamedNativeQueries( {
    @NamedNativeQuery(name = "SuperSearchKol.makePost", query = "SELECT Lev.id levID, sup.id supID, Part.id partId, Oper.id operID, it.id itID, ic.id icID, ie.id ieID, Col.id colID, SSCC.id ssccID, Sto.id stoID " +
        "FROM WMSOrderHist Lev " +
        "Inner Join PartnerAddress Part " +
        "ON Lev.orderId = Part.orderID And Part.orderSUB = 'EA' " +
        "Inner Join OperatorEventHist Oper " +
        "ON Oper.orderNumber = Lev.orderNumber And Oper.jobType in ( 'PICK' , 'PACK' , 'FULL') " +
        "Inner Join Item it " +
        "ON it.item_code  = Oper.item " +
        "Inner join ItemConf  ic " +
        "ON it.item_code = ic.item " +
        "Inner join ItemExt ie " +
        "ON it.item_code = ie.item " +
        "Inner Join StockHist Sto " +
        "ON Sto.allocRef = Oper.allocRef " +
        "LEFT OUTER JOIN SupplyHist sup " +
        "ON sup.orderId = Lev.orderId AND DATE(Lev.dbDate) = DATE(sup.dbDate) " +
        "LEFT JOIN CustomerLabelHist Col " +
        "ON Date(Oper.timestamp) = Date(Col.packDate) AND Lev.orderNumber = Col.orderNumber " +
        "INNER JOIN LMGSSCCHist SSCC " +
        "ON CONVERT(SSCC.sscc, char)  = CONVERT(REGEXP_REPLACE(Col.shippingCode, '^00', ''), CHAR) ")
})
@NamedQueries({
    @NamedQuery(name = "SuperSearchKol.findByIds", query = "SELECT object(o) FROM SuperSearchKol o " +
        "WHERE o.wmsOrderHist = :wmsOrderHist " +
        "AND o.supplyHist = :supplyHist " +
        "AND o.partnerAddress = :partnerAddress " +
        "AND o.operatorEventHist = :operatorEventHist " +
        "AND o.item = :item " +
        "AND o.itemConf = :itemConf " +
        "AND o.customerLabelHist = :customerLabelHist " +
        "AND o.lmgssccHist = :lmgssccHist " +
        "AND o.stockHist = :stockHist " +
        "AND o.itemExt = :itemExt")

})
@Entity
@Table(name = "SuperSearchKol", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"wmsOrderHist_id", "supplyHist_id",
        "partnerAddress_id", "operatorEventHist_id", "item_id", "itemConf_id",
        "customerLabelHist_id", "lmgssccHist_id", "stockHist_id", "itemExt_id"})},
    indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "wmsOrderHist_id"),
        @Index(columnList = "id, wmsOrderHist_id"),
        @Index(columnList = "supplyHist_id"),
        @Index(columnList = "id, supplyHist_id"),
        @Index(columnList = "partnerAddress_id"),
        @Index(columnList = "id, partnerAddress_id"),
        @Index(columnList = "operatorEventHist_id"),
        @Index(columnList = "id, operatorEventHist_id"),
        @Index(columnList = "item_id"),
        @Index(columnList = "id, item_id"),
        @Index(columnList = "itemConf_id"),
        @Index(columnList = "id, itemConf_id"),
        @Index(columnList = "itemExt_id"),
        @Index(columnList = "id, itemExt_id"),
        @Index(columnList = "customerLabelHist_id"),
        @Index(columnList = "id, customerLabelHist_id"),
        @Index(columnList = "lmgssccHist_id"),
        @Index(columnList = "id, lmgssccHist_id"),
        @Index(columnList = "stockHist_id"),
        @Index(columnList = "id, stockHist_id"),
        @Index(columnList = "id, wmsOrderHist_id, supplyHist_id, partnerAddress_id, operatorEventHist_id, " +
            "item_id, itemConf_id, itemExt_id, customerLabelHist_id, lmgssccHist_id, stockHist_id")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SuperSearchKol extends AbstractEntity implements Serializable {

  private Long id;
  private WMSOrderHist wmsOrderHist;
  private SupplyHist supplyHist;
  private PartnerAddress partnerAddress;
  private OperatorEventHist operatorEventHist;
  private Item item;
  private ItemConf itemConf;
  private ItemExt itemExt;
  private CustomerLabelHist customerLabelHist;
  private LMGSSCCHist lmgssccHist;
  private StockHist stockHist;
  private Date dbDate = new Date();


  public SuperSearchKol(WMSOrderHist wmsOrderHist, SupplyHist supplyHist, PartnerAddress partnerAddress, OperatorEventHist operatorEventHist,
    Item item, ItemConf itemConf, ItemExt itemExt, CustomerLabelHist customerLabelHist, LMGSSCCHist lmgssccHist, StockHist stockHist) {
    this.wmsOrderHist = wmsOrderHist;
    this.supplyHist = supplyHist;
    this.partnerAddress = partnerAddress;
    this.operatorEventHist = operatorEventHist;
    this.item = item;
    this.itemConf = itemConf;
    this.itemExt = itemExt;
    this.customerLabelHist = customerLabelHist;
    this.lmgssccHist = lmgssccHist;
    this.stockHist = stockHist;

  }

  public SuperSearchKol(Long levID, Long supID, Long partId, Long operID,
                        Long itID, Long icID, Long ieID, Long colId, Long ssccID, Long stoID) {

    WMSOrderHistDAO wmsOrderHistDAO = new WMSOrderHistDAO();
    SupplyHistDAO supplyHistDAO =  new SupplyHistDAO();
    PartnerAddressDAO partnerAddressDAO = new PartnerAddressDAO();
    OperatorEventHistDAO operatorEventHistDAO = new OperatorEventHistDAO();
    ItemDAO itemDAO = new ItemDAO();
    ItemExtDAO itemExtDAO = new ItemExtDAO();
    ItemConfDAO itemConfDAO = new ItemConfDAO();
    CustomerLabelHistDAO customerLabelHistDAO = new CustomerLabelHistDAO();
    LMGSSCCHISTDAO lmgsscchistdao =new LMGSSCCHISTDAO();
    StockHistDAO stockHistDAO = new StockHistDAO();

    this.wmsOrderHist = wmsOrderHistDAO.find(levID);
    this.supplyHist = supID != null ? supplyHistDAO.find(supID) : null;
    this.partnerAddress = partnerAddressDAO.find(partId);
    this.operatorEventHist = operatorEventHistDAO.find(operID);
    this.item = itemDAO.find(itID);
    this.itemConf = itemConfDAO.find(icID);
    this.itemExt = itemExtDAO.find(ieID);
    this.customerLabelHist = colId != null ? customerLabelHistDAO.find(colId) : null;
    this.lmgssccHist = ssccID != null ? lmgsscchistdao.find(ssccID) : null;
    this.stockHist = stockHistDAO.find(stoID);

  }
  /*
  private Date createDate;
  private String sapOrdernr;
  private String leveringsnr;
  private String kundenr;
  private String orderSub;
  private Double qty;
  private String itemConfig;
  private String itemCode;
  private String description;
  private String barcode;
  private String user;
  private String jobType;
  private Date dato;
  private String jobTypeCode;
  private String zone;
  private String fromLocation;
  private String route;
  private String orderType;
  private String zipAreaCode;
  private String container;
  private Date timePicked;
  private Integer allocRef;
  private Double quantity;
  private Integer sequence;
  private Integer packageNr;
  private Date created;
  private String lineId;
  private String fromContainer;
  private String receiptRef;
  */





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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "wmsOrderHist_id", nullable = false)
  public WMSOrderHist getWmsOrderHist() {
    return wmsOrderHist;
  }

  public void setWmsOrderHist(WMSOrderHist wmsOrderHist) {
    this.wmsOrderHist = wmsOrderHist;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "supplyHist_id", nullable = true)
  public SupplyHist getSupplyHist() {
    return supplyHist;
  }

  public void setSupplyHist(SupplyHist supplyHist) {
    this.supplyHist = supplyHist;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "partnerAddress_id", nullable = false)
  public PartnerAddress getPartnerAddress() {
    return partnerAddress;
  }

  public void setPartnerAddress(PartnerAddress partnerAddress) {
    this.partnerAddress = partnerAddress;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "operatorEventHist_id", nullable = false)
  public OperatorEventHist getOperatorEventHist() {
    return operatorEventHist;
  }

  public void setOperatorEventHist(OperatorEventHist operatorEventHist) {
    this.operatorEventHist = operatorEventHist;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id", nullable = false)
  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "itemConf_id", nullable = false)
  public ItemConf getItemConf() {
    return itemConf;
  }

  public void setItemConf(ItemConf itemConf) {
    this.itemConf = itemConf;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customerLabelHist_id")
  public CustomerLabelHist getCustomerLabelHist() {
    return customerLabelHist;
  }

  public void setCustomerLabelHist(CustomerLabelHist customerLabelHist) {
    this.customerLabelHist = customerLabelHist;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lmgssccHist_id")
  public LMGSSCCHist getLmgssccHist() {
    return lmgssccHist;
  }

  public void setLmgssccHist(LMGSSCCHist lmgssccHist) {
    this.lmgssccHist = lmgssccHist;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stockHist_id", nullable = false)
  public StockHist getStockHist() {
    return stockHist;
  }

  public void setStockHist(StockHist stockHist) {
    this.stockHist = stockHist;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "itemExt_id", nullable = false)
  public ItemExt getItemExt() {
    return itemExt;
  }

  public void setItemExt(ItemExt itemExt) {
    this.itemExt = itemExt;
  }

  @Column(name = "dbDato")
  public Date getDbDate() {
    return dbDate;
  }

  public void setDbDate(Date dbDate) {
    this.dbDate = dbDate;
  }

  @Override
  public String toString() {
    return "SuperSearchKol{" +
        "id=" + id +
        ", CreatedDate: " + wmsOrderHist.getCreatedDate() +
        ", Sap ordernr: " + (supplyHist != null ? supplyHist.getSalesOrderNumber() : "") +
        ", Leveringsnr.: " + wmsOrderHist.getOrderNumber() +
        ", Kundenr.: " + partnerAddress.getCvr() +
        ", Order sub: " + partnerAddress.getOrderSUB() +
        ", Antal: " + calcQty() +
        ", Enhed: " + itemConf.getItemConf() +
        ", varenr: " + item.getItem_code() +
        ", beskrivelse: " + item.getDescription() +
        ", Extern kolli: " + operatorEventHist.getBarcode() +
        ", Medarbejdenavn: " + operatorEventHist.getUser() +
        ", Logtype " + operatorEventHist.getJobType() +
        ", Dato: " + operatorEventHist.getTimestamp() +
        ", Logtyp kode: " + operatorEventHist.getJobType() +
        ", Kø: " + operatorEventHist.getZone() +
        ", Fra lokation: " + operatorEventHist.getFromLocation() +
        ", Rute: " + route() +
        ", Order type: " + (customerLabelHist != null ? customerLabelHist.getOrderType() : "") +
        ", Zip Area Code: " + (customerLabelHist != null ? customerLabelHist.getZipCodeArea() : "") +
        ", Container id: " + (lmgssccHist != null ? lmgssccHist.getContainer() : "") +
        ", Time picked: " + stockHist.getTimePicked() +
        ", Alloc Ref: " + stockHist.getAllocRef() +
        ", Quantity: " + stockHist.getQty() +
        ", Container id: " + (lmgssccHist != null ? lmgssccHist.getSequenceNumber().toString() : "") +
        ", Container id: " + (lmgssccHist != null ? lmgssccHist.getPackageNo().toString() : "") +
        ", Created: " + wmsOrderHist.getCreatedDate() +
        ", Line no.: " + operatorEventHist.getLineId() +
        ", Frrom container: " + operatorEventHist.getFromLocation() +
        ", Materiale bilag: " + stockHist.getReceiptRef() +
        '}';
  }

  private String route() {
    if (customerLabelHist != null) {
      if (customerLabelHist.getRoute().length() == 2) {
        if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("NORD")) {
          return "01" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("MIDT")) {
          return "02" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("VEST")) {
          return "03" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("THIS")) {
          return "04" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("SYD")) {
          return "05" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("VOJ")) {
          return "06" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("ODE")) {
          return "07" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("KOL")) {
          return "08" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("GLO")) {
          return "09" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("SJÆL")) {
          return "10" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("KBH1")) {
          return "11" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("TAS1")) {
          return "12" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("TAS2")) {
          return "13" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("FRAG")) {
          return "14" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("SCM")) {
          return "15" + customerLabelHist.getRoute();
        } else if (customerLabelHist.getZipCodeArea().equalsIgnoreCase("BORN")) {
          return "16" + customerLabelHist.getRoute();
        } else {
          return "16"+ customerLabelHist.getRoute();
        }
      } else {
        return customerLabelHist.getRoute();
      }
    } else {
      return "";
    }
  }

  private Double calcQty() {
    if (operatorEventHist.getJobType().equalsIgnoreCase("PACK")) {
      return (stockHist.getQty() / new Double(itemExt.getPrecisionValue()));
    } else if (operatorEventHist.getJobType().equalsIgnoreCase("FULL")) {
      return (operatorEventHist.getFromQtyAfter() / new Double(itemExt.getPrecisionValue()));
    } else {
      return ((operatorEventHist.getFromQtyBefore() - operatorEventHist.getFromQtyAfter()) / new Double(itemExt.getPrecisionValue()));
    }

  }
}

