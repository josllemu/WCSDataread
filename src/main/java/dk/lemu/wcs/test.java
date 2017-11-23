package dk.lemu.wcs;

import dk.lemu.tools.dao.*;
import dk.lemu.tools.database.HibernateUtil;
import dk.lemu.tools.entity.Config;
import dk.lemu.tools.logging.Logging;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {



  private static Logging logger;
  public static void main(String[] args) throws Exception {
    System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %5$s%6$s%n");

    HibernateUtil.initialize(args);

    LocationDAO locationDAO = new LocationDAO();
    AlarmsDAO alarmsDAO = new AlarmsDAO();
    ContainerDAO containerDAO = new ContainerDAO();
    ContainerSizeDAO containerSizeDAO = new ContainerSizeDAO();
    ContainerTypeDAO containerTypeDAO = new ContainerTypeDAO();
    CustomerLabelDAO customerLabelDAO = new CustomerLabelDAO();
    EmptyContainerDAO emptyContainerDAO = new EmptyContainerDAO();
    ItemConfDAO itemConfDAO = new ItemConfDAO();
    ItemDAO itemDAO = new ItemDAO();
    ItemExtDAO itemExtDAO = new ItemExtDAO();
    LMGSSCCDAO lmgssccdao = new LMGSSCCDAO();
    MHEErrorDAO mheErrorDAO = new MHEErrorDAO();
    MHEErrorDescDAO mheErrorDescDAO = new MHEErrorDescDAO();
    MHEEventDAO mheEventDAO = new MHEEventDAO();
    MHEInfoDAO mheInfoDAO = new MHEInfoDAO();
    MoveJobDescDAO moveJobDescDAO = new MoveJobDescDAO();
    MovementsDAO movementsDAO = new MovementsDAO();
    OperatorEventDAO operatorEventDAO = new OperatorEventDAO();
    ParamsDAO paramsDAO = new ParamsDAO();
    PartnerAddressDAO partnerAddressDAO = new PartnerAddressDAO();
    PartnerInfoDAO partnerInfoDAO = new PartnerInfoDAO();
    PickCategoryDAO pickCategoryDAO = new PickCategoryDAO();
    PickCountDAO pickCountDAO = new PickCountDAO();
    PickReqDAO pickReqDAO = new PickReqDAO();
    PMSDataDAO pmsDataDAO = new PMSDataDAO();
    PutAwayDAO putAwayDAO = new PutAwayDAO();
    ReplenQtyDAO replenQtyDAO = new ReplenQtyDAO();
    StockAssemblyDAO stockAssemblyDAO = new StockAssemblyDAO();
    StockDAO stockDAO = new StockDAO();
    StockReq2DAO stockReq2DAO = new StockReq2DAO();
    StockReqDAO stockReqDAO = new StockReqDAO();
    StockSpreadDAO stockSpreadDAO = new StockSpreadDAO();
    SupplyDAO supplyDAO = new SupplyDAO();
    UserDAO userDAO = new UserDAO();
    WCSAllocPriorityDAO wcsAllocPriorityDAO = new WCSAllocPriorityDAO();
    WCSAllocZoneWTDAO wcsAllocZoneWTDAO = new WCSAllocZoneWTDAO();
    WMSOrderDAO wmsOrderDAO = new WMSOrderDAO();
    WMSOrderLineDAO wmsOrderLineDAO = new WMSOrderLineDAO();
    WorkStationDAO workStationDAO = new WorkStationDAO();
    ZoneDAO zoneDAO = new ZoneDAO();
    StockHistDAO stockHistDAO = new StockHistDAO();

    logger = new Logging();

    ConfigDAO configDAO = new ConfigDAO();
    Config config = configDAO.findByConfiguration("Singleton");

    String folder = getPath(config);

      String path = config.getPath() + "\\" + folder + "\\";

    Collection<File> files = new ArrayList<>();
    addTree(path, files);

    System.out.println(files);

    System.exit(0);

  }

  private static void addTree(String path, Collection<File> all) {
    File file = new File(path);
    File[] children = file.listFiles();
    if (children != null) {
      for (File child : children) {
        if (!child.isDirectory()) {
          logger.log("file added: " + child.getName());
          all.add(child);
        } else {
          addTree(child.getPath(), all);
        }
      }
    }
  }

  private static String getPath(Config config) {

    String folder = config.getFolder();

    String[] split = folder.split("-");
    Integer year = new Integer(split[0]);
    Integer month = new Integer(split[1]);
    Integer day = new Integer(split[2]);

    String newFolder;
    Calendar c = new GregorianCalendar(year, (month - 1), day);
    c.add(Calendar.DAY_OF_YEAR, 1);

    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-d");

    newFolder = format.format(c.getTime());

    if (doesFolderExist(newFolder, config.getPath())) {
      return newFolder;
    } else {
      return null;
    }
  }

  private static boolean doesFolderExist(String newFolder, String path) {
    File file = new File("\\" + path + "\\" + newFolder + "\\");
    logger.log("file path: " + file.toString());
    return file.isDirectory();

  }
}
