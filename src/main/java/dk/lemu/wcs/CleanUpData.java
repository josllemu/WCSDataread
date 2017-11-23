package dk.lemu.wcs;

import dk.lemu.tools.dao.*;
import dk.lemu.tools.database.HibernateUtil;
import dk.lemu.tools.logging.Logging;

public class CleanUpData {

  private static ContainerDAO containerDAO = new ContainerDAO();
  private static CustomerLabelDAO customerLabelDAO = new CustomerLabelDAO();
  private static LocationDAO locationDAO = new LocationDAO();
  private static MovementsDAO movementsDAO = new MovementsDAO();
  private static OperatorEventDAO operatorEventDAO = new OperatorEventDAO();
  private static PickReqDAO pickReqDAO = new PickReqDAO();
  private static PutAwayDAO putAwayDAO = new PutAwayDAO();
  private static ReplenQtyDAO replenQtyDAO = new ReplenQtyDAO();
  private static StockDAO stockDAO = new StockDAO();
  private static StockReq2DAO stockReq2DAO = new StockReq2DAO();
  private static StockReqDAO stockReqDAO = new StockReqDAO();
  private static StockSpreadDAO stockSpreadDAO = new StockSpreadDAO();
  private static SupplyDAO supplyDAO = new SupplyDAO();
  private static WCSAllocPriorityDAO wcsAllocPriorityDAO = new WCSAllocPriorityDAO();
  private static WMSOrderDAO wmsOrderDAO = new WMSOrderDAO();
  private static WMSOrderLineDAO wmsOrderLineDAO = new WMSOrderLineDAO();
  private static StockHistDAO stockHistDAO = new StockHistDAO();
  private static CustomerLabelHistDAO customerLabelHistDAO = new CustomerLabelHistDAO();
  private static OperatorEventHistDAO operatorEventHistDAO = new OperatorEventHistDAO();
  private static LMGSSCCHISTDAO lmgssccHistDAO = new LMGSSCCHISTDAO();
  private static WMSOrderHistDAO wmsOrderHistDAO = new WMSOrderHistDAO();
  private static SupplyHistDAO supplyHistDAO = new SupplyHistDAO();
  private static Logging logger;
  private static AlarmsDAO alarmsDAO = new AlarmsDAO();
  private static ContainerSizeDAO containerSizeDAO = new ContainerSizeDAO();
  private static ContainerTypeDAO containerTypeDAO = new ContainerTypeDAO();
  private static EmptyContainerDAO emptyContainerDAO = new EmptyContainerDAO();
  private static ItemConfDAO itemConfDAO = new ItemConfDAO();
  private static ItemDAO itemDAO = new ItemDAO();
  private static ItemExtDAO itemExtDAO = new ItemExtDAO();
  private static LMGSSCCDAO lmgssccdao = new LMGSSCCDAO();
  private static MHEErrorDAO mheErrorDAO = new MHEErrorDAO();
  private static MHEErrorDescDAO mheErrorDescDAO = new MHEErrorDescDAO();
  private static MHEEventDAO mheEventDAO = new MHEEventDAO();
  private static MHEInfoDAO mheInfoDAO = new MHEInfoDAO();
  private static MoveJobDescDAO moveJobDescDAO = new MoveJobDescDAO();
  private static ParamsDAO paramsDAO = new ParamsDAO();
  private static PartnerAddressDAO partnerAddressDAO = new PartnerAddressDAO();
  private static PartnerInfoDAO partnerInfoDAO = new PartnerInfoDAO();
  private static PickCategoryDAO pickCategoryDAO = new PickCategoryDAO();
  private static PickCountDAO pickCountDAO = new PickCountDAO();
  private static PMSDataDAO pmsDataDAO = new PMSDataDAO();
  private static StockAssemblyDAO stockAssemblyDAO = new StockAssemblyDAO();
  private static UserDAO userDAO = new UserDAO();
  private static WCSAllocZoneWTDAO wcsAllocZoneWTDAO = new WCSAllocZoneWTDAO();
  private static WorkStationDAO workStationDAO = new WorkStationDAO();
  private static ZoneDAO zoneDAO = new ZoneDAO();

  public static void main(String[] args) throws Exception {
    System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %5$s%6$s%n");

    HibernateUtil.initialize(args);

    logger = new Logging();

    try {
      int numpost = containerDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = customerLabelDAO.deleteAll();
      logger.log("num post deleted: " + numpost);
      numpost = locationDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = movementsDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = operatorEventHistDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = lmgssccHistDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = customerLabelHistDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = pickReqDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = putAwayDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = replenQtyDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = stockHistDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = stockReqDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = stockReq2DAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = stockSpreadDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = supplyHistDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = wcsAllocPriorityDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = wmsOrderHistDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
      numpost = wmsOrderLineDAO.deleteOldPost();
      logger.log("num post deleted: " + numpost);
    } catch (Exception e) {
      logger.log(e);
      System.exit(0);
    } finally {
      logger.log("------------------------------");
      logger.log("Run finished");
      logger.log("------------------------------");
      System.exit(0);
    }


  }
}
