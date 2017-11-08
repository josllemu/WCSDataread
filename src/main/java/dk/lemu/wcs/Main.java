package dk.lemu.wcs;

import dk.lemu.tools.dao.*;
import dk.lemu.tools.database.HibernateUtil;
import dk.lemu.tools.entity.*;
import dk.lemu.tools.logging.Logging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

  private static String alarmsFileName = "alarms.dat.extract";
  private static String contSizeFileName = "cont_size.dat.extract";
  private static String contTypeFileName = "cont_type.dat.extract";
  private static String containerFileName = "container.dat.extract";
  private static String customerLabelFileName = "customer_label.dat.extract";
  private static String emptyContainerFileName = "empty_container.dat.extract";
  private static String itemFileName = "item.dat.extract";
  private static String itemConfFileName = "item_conf.dat.extract";
  private static String itemExtFileName = "item_ext.dat.extract";
  private static String lmgSSCCFileName = "lmg_sscc.dat.extract";
  private static String locationFileName = "location.dat.extract";
  private static String mheErrorDescFileName = "mhe_error_desc.dat.extract";
  private static String mheErrorsFileName = "mhe_errors.dat.extract";
  private static String mheEventFileName = "mhe_event.dat.extract";
  private static String mheInfoFileName = "mhe_info.dat.extract";
  private static String moveJobDescFileName = "move_job_desc.dat.extract";
  private static String movementsFileName = "movements.dat.extract";
  private static String operatorEventFileName = "operator_event.dat.extract";
  private static String paramsFileName = "params.dat.extract";
  private static String partnerAddressFileName = "partner_address.dat.extract";
  private static String partnerInfoFileName = "partner_info.dat.extract";
  private static String pickCategoryFileName = "pick_category.dat.extract";
  private static String pickCountFileName = "pick_count.dat.extract";
  private static String pickReqFileName = "pick_req.dat.extract";
  private static String psmDataFileName = "psm_data.dat.extract";
  private static String putawayFileName = "putaway.dat.extract";
  private static String replenQtyFileName = "replen_qty.dat.extract";
  private static String stockFileName = "stock.dat.extract";
  private static String stockAssemblyFileName = "stock_assembly.dat.extract";
  private static String stockReqFileName = "stock_req.dat.extract";
  private static String stockReq2FileName = "stock_req2.dat.extract";
  private static String usersFileName = "users.dat.extract";
  private static String wmsOrderLineFileName = "wms_order_line.dat.extract";
  private static String stockSpreadFileName = "stock_spread.dat.extract";
  private static String supplyFileName = "supply.dat.extract";
  private static String wcsAllocPriorityFileName = "wcs_alloc_priority.dat.extract";
  private static String wcsAllocZoneWtFileName = "wcs_alloc_zone_wt.dat.extract";
  private static String wmsOrderFileName = "wms_order.dat.extract";
  private static String workstationFileName = "workstation.dat.extract";
  private static String zonesFileName = "zones.dat.extract";

  private static Long folderSize = 0L;
  private static Logging logger;


  public static void main(String[] args) throws Exception {
    System.setProperty("java.util.logging.SimpleFormatter.format",
        "%1$tF %1$tT %4$s %5$s%6$s%n");
    HibernateUtil.initialize(args);
    logger = new Logging();

    try {

      ConfigDAO configDAO = new ConfigDAO();
      Config config = configDAO.findByConfiguration("Singleton");

      String folder = getPath(config);
      while (folder != null) {

        String path = config.getPath() + "\\" + folder + "\\";

        Long start = System.currentTimeMillis();
        Long fullRecords = 0L;

        fullRecords += fileHandling(alarmsFileName, path);
        fullRecords += fileHandling(contSizeFileName, path);
        fullRecords += fileHandling(contTypeFileName, path);
        fullRecords += fileHandling(containerFileName, path);
        fullRecords += fileHandling(customerLabelFileName, path);
        fullRecords += fileHandling(emptyContainerFileName, path);
        fullRecords += fileHandling(itemFileName, path);
        fullRecords += fileHandling(itemConfFileName, path);
        fullRecords += fileHandling(itemExtFileName, path);
        fullRecords += fileHandling(lmgSSCCFileName, path);
        fullRecords += fileHandling(locationFileName, path);
        fullRecords += fileHandling(mheErrorDescFileName, path);
        fullRecords += fileHandling(mheErrorsFileName, path);
        fullRecords += fileHandling(mheEventFileName, path);
        fullRecords += fileHandling(mheInfoFileName, path);
        fullRecords += fileHandling(movementsFileName, path);
        fullRecords += fileHandling(operatorEventFileName, path);
        fullRecords += fileHandling(paramsFileName, path);
        fullRecords += fileHandling(partnerAddressFileName, path);
        fullRecords += fileHandling(partnerInfoFileName, path);
        fullRecords += fileHandling(moveJobDescFileName, path);

        fullRecords += fileHandling(pickCategoryFileName, path);
        fullRecords += fileHandling(pickReqFileName, path);
        fullRecords += fileHandling(psmDataFileName, path);
        fullRecords += fileHandling(pickCountFileName, path);
        fullRecords += fileHandling(putawayFileName, path);
        fullRecords += fileHandling(replenQtyFileName, path);
        fullRecords += fileHandling(stockFileName, path);
        fullRecords += fileHandling(stockAssemblyFileName, path);
        fullRecords += fileHandling(stockReqFileName, path);
        fullRecords += fileHandling(stockReq2FileName, path);
        //
        fullRecords += fileHandling(usersFileName, path);
        fullRecords += fileHandling(wmsOrderLineFileName, path);
        fullRecords += fileHandling(stockSpreadFileName, path);
        fullRecords += fileHandling(supplyFileName, path);
        fullRecords += fileHandling(wcsAllocPriorityFileName, path);
        fullRecords += fileHandling(wcsAllocZoneWtFileName, path);
        fullRecords += fileHandling(wmsOrderFileName, path);
        fullRecords += fileHandling(workstationFileName, path);
        fullRecords += fileHandling(zonesFileName, path);

        Long end = System.currentTimeMillis();
        //Logging
        //
        Log log = new Log();
        log.setDescription("Data for full run of path: " + path);
        log.setPath(path);
        log.setNumLines(fullRecords);
        log.setRunTime((end - start));
        log.setRunDay(new Date());
        log.setSize(folderSize);
        log.setFileName("N/A");
        LogDAO logDAO = new LogDAO();
        logDAO.saveOrUpdate(log);

        config.setFolder(folder);
        configDAO.saveOrUpdate(config);

        logDAO.commit();

        folderSize = 0L;

        logger.log("Total records handled: " + fullRecords);
        logger.log("Parse time for file: " + ((end - start)));
        logger.log("Avg. parse time: " + ((end.doubleValue() - start.doubleValue()) / fullRecords.doubleValue()));

        logger.log("------------------------------");
        logger.log("Run finished on path");
        logger.log("Run on path started: " +  new Date(start));
        logger.log("Path: " + config.getPath());
        logger.log("Start folder: " + config.getFolder());
        logger.log("Last run took: " + (log.getRunTime()/1000L));
        logger.log("Num linies on last run: " + log.getNumLines());
        logger.log("------------------------------");
        folder = getPath(config);
      }
    } catch (Exception e) {
      logger.log(e);
    } finally {
      logger.log("------------------------------");
      logger.log("Run finished");
      logger.log("------------------------------");
      System.exit(0);
    }
  }

  private static String getPath(Config config) {

    String folder = config.getFolder();

    String[] split = folder.split("-");
    Integer year = new Integer(split[0]);
    Integer month = new Integer(split[1]);
    Integer day = new Integer(split[2]);

    String newFolder;
    Calendar c = new GregorianCalendar(year, (month-1), day);
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
    File file = new File("\\" + path+ "\\" + newFolder +"\\");
    logger.log("file path: " + file.toString());
    return file.isDirectory();

  }

  private static Long fileHandling(String type, String path) throws Exception {
    Long records;
    Collection<File> files = new ArrayList<>();
    addTree(path, type, files);
    records = fileHandler(files);

    logger.log("Files: " + files.size() + ", records: " + records + ", Type: " + type);
    return records;
  }

  private static Long fileHandler(Collection<File> files) throws Exception {
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
    LocationDAO locationDAO = new LocationDAO();
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


    Long fullCounter = 0L;
    for (File file : files) {

      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Windows-1252"), 1024 * 8192);
      String line = null;
      Integer counter = 0;
      Long startTime = System.currentTimeMillis();
      //could be an easier way to do this
      Collection<Alarms> alarmsCollection = new ArrayList<>();
      Collection<Container> containers = new ArrayList<>();
      Collection<ContainerSize> containerSizes = new ArrayList<>();
      Collection<ContainerType> types = new ArrayList<>();
      Collection<CustomerLabel> customerLabels = new ArrayList<>();
      Collection<EmptyContainer> emptyContainers = new ArrayList<>();
      Collection<ItemConf> itemConfs = new ArrayList<>();
      Collection<Item> items = new ArrayList<>();
      Collection<ItemExt> itemExts = new ArrayList<>();
      Collection<LMGSSCC> lmgssccs = new ArrayList<>();
      Collection<Location> locations = new ArrayList<>();
      Collection<MHEError> mheErrors = new ArrayList<>();
      Collection<MHEErrorDesc> mheErrorDescs = new ArrayList<>();
      Collection<MHEEvent> mheEvents = new ArrayList<>();
      Collection<MHEInfo> mheInfos = new ArrayList<>();
      Collection<MoveJobDesc> moveJobDescs = new ArrayList<>();
      Collection<Movements> movementsCollection = new ArrayList<>();
      Collection<OperatorEvent> operatorEvents = new ArrayList<>();
      Collection<Params> paramsCollection = new ArrayList<>();
      Collection<PartnerAddress> partnerAddresses = new ArrayList<>();
      Collection<PartnerInfo> partnerInfos = new ArrayList<>();
      Collection<PickCategory> pickCategories = new ArrayList<>();
      Collection<PickCount> pickCounts = new ArrayList<>();
      Collection<PickReq> pickReqs = new ArrayList<>();
      Collection<PMSData> pmsDatas = new ArrayList<>();
      Collection<PutAway> putAways = new ArrayList<>();
      Collection<ReplenQty> replenQties = new ArrayList<>();
      Collection<Stock> stocks = new ArrayList<>();
      Collection<StockHist> stockHists = new ArrayList<>();
      Collection<StockAssembly> stockAssemblies = new ArrayList<>();
      Collection<StockReq> stockReqs = new ArrayList<>();
      Collection<StockReq2> stockReq2s = new ArrayList<>();
      Collection<StockSpread> stockSpreads = new ArrayList<>();
      Collection<Supply> supplies = new ArrayList<>();
      Collection<User> users = new ArrayList<>();
      Collection<WCSAllocPriority> wcsAllocPriorities = new ArrayList<>();
      Collection<WCSAllocZoneWT> wcsAllocZoneWTS = new ArrayList<>();
      Collection<WMSOrder> wmsOrders = new ArrayList<>();
      Collection<WMSOrderLine> wmsOrderLines = new ArrayList<>();
      Collection<WorkStation> workStations = new ArrayList<>();
      Collection<Zone> zones = new ArrayList<>();


      while ((line = br.readLine()) != null) {
        fullCounter++;
        counter++;
        String[] test = line.split("~");
        List<String> list = Arrays.asList(test);

        for (int i = 0; list.size() > i; i++) {
          list.set(i, list.get(i).trim());
        }

        if (counter % 250 == 0) {
          logger.log("number: " + counter + ", time running: " + ((System.currentTimeMillis() - startTime) / 1000L));
        }

        try {
          if (file.getName().matches(alarmsFileName)) {
            Alarms alarms = new Alarms(list);
            if (!alarmsCollection.contains(alarms)) {
              alarmsCollection.add(alarms);
            }
            if (counter % 250 == 0) {
              alarmsDAO.multiSaveOrUpdate(alarmsCollection);
              alarmsCollection = new ArrayList<>();
            }
          } else if (file.getName().matches(contSizeFileName)) {
            ContainerSize c = new ContainerSize(list);
            if (!containerSizes.contains(c)) {
              containerSizes.add(c);
            }
            if (counter % 250 == 0) {
              containerSizeDAO.multiSaveOrUpdate(containerSizes);
              containerSizes = new ArrayList<>();
            }
          } else if (file.getName().matches(contTypeFileName)) {
            ContainerType c = new ContainerType(list);
            if (!types.contains(c)) {
              types.add(c);
            }
            if (counter % 250 == 0) {
              containerTypeDAO.multiSaveOrUpdate(types);
              types = new ArrayList<>();
            }
          } else if (file.getName().matches(containerFileName)) {
            Container c = new Container(list);
            if (!containers.contains(c)) {
              containers.add(c);
            }
            if (counter % 250 == 0) {
              containerDAO.multiSaveOrUpdate(containers);
              containers = new ArrayList<>();
            }
          } else if (file.getName().matches(customerLabelFileName)) {
            CustomerLabel c = new CustomerLabel(list);
            if (!customerLabels.contains(c)) {
              customerLabels.add(c);
            }
            if (counter % 250 == 0) {
              customerLabelDAO.multiSaveOrUpdate(customerLabels);
              customerLabels = new ArrayList<>();
            }
          } else if (file.getName().matches(emptyContainerFileName)) {
            EmptyContainer c = new EmptyContainer(list);
            if (!emptyContainers.contains(c)) {
              emptyContainers.add(c);
            }
            if (counter % 250 == 0) {
              emptyContainerDAO.multiSaveOrUpdate(emptyContainers);
              emptyContainers = new ArrayList<>();
            }
          } else if (file.getName().matches(itemFileName)) {
            Item c = new Item(list);
            if (!items.contains(c)) {
              items.add(c);
            }
            if (counter % 250 == 0) {
              itemDAO.multiSaveOrUpdate(items);
              items = new ArrayList<>();
            }
          } else if (file.getName().matches(itemConfFileName)) {
            ItemConf c = new ItemConf(list);
            if (!itemConfs.contains(c)) {
              itemConfs.add(c);
            }
            if (counter % 250 == 0) {
              itemConfDAO.multiSaveOrUpdate(itemConfs);
              itemConfs = new ArrayList<>();
            }
          } else if (file.getName().matches(itemExtFileName)) {
            ItemExt c = new ItemExt(list);
            if (!itemExts.contains(c)) {
              itemExts.add(c);
            }
            if (counter % 250 == 0) {
              itemExtDAO.multiSaveOrUpdate(itemExts);
              itemExts = new ArrayList<>();
            }
          } else if (file.getName().matches(lmgSSCCFileName)) {
            LMGSSCC c = new LMGSSCC(list);
            if (!lmgssccs.contains(c)) {
              lmgssccs.add(c);
            }
            if (counter % 250 == 0) {
              lmgssccdao.multiSaveOrUpdate(lmgssccs);
              lmgssccs = new ArrayList<>();
            }
          } else if (file.getName().matches(locationFileName)) {
            Location c = new Location(list);
            if (!locations.contains(c)) {
              locations.add(c);
            }
            if (counter % 250 == 0) {
              locationDAO.multiSaveOrUpdate(locations);
              locations = new ArrayList<>();
            }
          } else if (file.getName().matches(mheErrorsFileName)) {
            MHEError c = new MHEError(list);
            if (!mheErrors.contains(c)) {
              mheErrors.add(c);
            }
            if (counter % 250 == 0) {
              mheErrorDAO.multiSaveOrUpdate(mheErrors);
              mheErrors = new ArrayList<>();
            }
          } else if (file.getName().matches(mheErrorDescFileName)) {
            MHEErrorDesc c = new MHEErrorDesc(list);
            if (!mheErrorDescs.contains(c)) {
              mheErrorDescs.add(c);
            }
            if (counter % 250 == 0) {
              mheErrorDescDAO.multiSaveOrUpdate(mheErrorDescs);
              mheErrorDescs = new ArrayList<>();
            }
          } else if (file.getName().matches(mheEventFileName)) {
            MHEEvent c = new MHEEvent(list);
            if (!mheEvents.contains(c)) {
              mheEvents.add(c);
            }
            if (counter % 250 == 0) {
              mheEventDAO.multiSaveOrUpdate(mheEvents);
              mheEvents = new ArrayList<>();
            }
          } else if (file.getName().matches(mheInfoFileName)) {
            MHEInfo c = new MHEInfo(list);
            if (!mheInfos.contains(c)) {
              mheInfos.add(c);
            }
            if (counter % 250 == 0) {
              mheInfoDAO.multiSaveOrUpdate(mheInfos);
              mheInfos = new ArrayList<>();
            }
          } else if (file.getName().matches(movementsFileName)) {
            Movements c = new Movements(list);
            if (!movementsCollection.contains(c)) {
              movementsCollection.add(c);
            }
            if (counter % 250 == 0) {
              movementsDAO.multiSaveOrUpdate(movementsCollection);
              movementsCollection = new ArrayList<>();
            }
          } else if (file.getName().matches(operatorEventFileName)) {
            OperatorEvent c = new OperatorEvent(list);
            if (!operatorEvents.contains(c)) {
              operatorEvents.add(c);
            }
            if (counter % 250 == 0) {
              operatorEventDAO.multiSaveOrUpdate(operatorEvents);
              operatorEvents = new ArrayList<>();
            }
          } else if (file.getName().matches(paramsFileName)) {
            Params c = new Params(list);
            if (!paramsCollection.contains(c)) {
              paramsCollection.add(c);
            }
            if (counter % 250 == 0) {
              paramsDAO.multiSaveOrUpdate(paramsCollection);
              paramsCollection = new ArrayList<>();
            }
          } else if (file.getName().matches(partnerAddressFileName)) {
            PartnerAddress c = new PartnerAddress(list);
            if (!partnerAddresses.contains(c)) {
              partnerAddresses.add(c);
            }
            if (counter % 250 == 0) {
              partnerAddressDAO.multiSaveOrUpdate(partnerAddresses);
              partnerAddresses = new ArrayList<>();
            }
          } else if (file.getName().matches(partnerInfoFileName)) {
            PartnerInfo c = new PartnerInfo(list);
            if (!partnerInfos.contains(c)) {
              partnerInfos.add(c);
            }
            if (counter % 250 == 0) {
              partnerInfoDAO.multiSaveOrUpdate(partnerInfos);
              partnerInfos = new ArrayList<>();
            }
          } else if (file.getName().matches(moveJobDescFileName)) {
            MoveJobDesc c = new MoveJobDesc(list);
            if (!moveJobDescs.contains(c)) {
              moveJobDescs.add(c);
            }
            if (counter % 250 == 0) {
              moveJobDescDAO.multiSaveOrUpdate(moveJobDescs);
              moveJobDescs = new ArrayList<>();
            }
          } else if (file.getName().matches(pickCategoryFileName)) {
            PickCategory c = new PickCategory(list);
            if (!pickCategories.contains(c)) {
              pickCategories.add(c);
            }
            if (counter % 250 == 0) {
              pickCategoryDAO.multiSaveOrUpdate(pickCategories);
              pickCategories = new ArrayList<>();
            }
          } else if (file.getName().matches(pickReqFileName)) {
            PickReq c = new PickReq(list);
            if (!pickReqs.contains(c)) {
              pickReqs.add(c);
            }
            if (counter % 250 == 0) {
              pickReqDAO.multiSaveOrUpdate(pickReqs);
              pickReqs = new ArrayList<>();
            }
          } else if (file.getName().matches(psmDataFileName)) {
            PMSData c = new PMSData(list);
            if (!pmsDatas.contains(c)) {
              pmsDatas.add(c);
            }
            if (counter % 250 == 0) {
              pmsDataDAO.multiSaveOrUpdate(pmsDatas);
              pmsDatas = new ArrayList<>();
            }
          } else if (file.getName().matches(pickCountFileName)) {
            PickCount c = new PickCount(list);
            if (!pickCounts.contains(c)) {
              pickCounts.add(c);
            }
            if (counter % 250 == 0) {
              pickCountDAO.multiSaveOrUpdate(pickCounts);
              pickCounts = new ArrayList<>();
            }
          } else if (file.getName().matches(putawayFileName)) {
            PutAway c = new PutAway(list);
            if (!putAways.contains(c)) {
              putAways.add(c);
            }
            if (counter % 250 == 0) {
              putAwayDAO.multiSaveOrUpdate(putAways);
              putAways = new ArrayList<>();
            }
          } else if (file.getName().matches(replenQtyFileName)) {
            ReplenQty c = new ReplenQty(list);
            if (!replenQties.contains(c)) {
              replenQties.add(c);
            }
            if (counter % 250 == 0) {
              replenQtyDAO.multiSaveOrUpdate(replenQties);
              replenQties = new ArrayList<>();
            }
          } else if (file.getName().matches(stockFileName)) {
            Stock stock = new Stock(list);
            StockHist stockHist = new StockHist(list);
            if (!stocks.contains(stock)) {
              stocks.add(stock);
            }
            if (!stockHists.contains(stockHist)) {
              stockHists.add(stockHist);
            }
            if (counter % 500 == 0) {
              stockDAO.multiSaveOrUpdate(stocks);
              stockHistDAO.multiSaveOrUpdate(stockHists);
              stocks = new ArrayList<>();
              stockHists = new ArrayList<>();
            }
          } else if (file.getName().matches(stockAssemblyFileName)) {
            StockAssembly c = new StockAssembly(list);
            if (!stockAssemblies.contains(c)) {
              stockAssemblies.add(c);
            }
            if (counter % 250 == 0) {
              stockAssemblyDAO.multiSaveOrUpdate(stockAssemblies);
              stockAssemblies = new ArrayList<>();
            }
          } else if (file.getName().matches(stockReqFileName)) {
            StockReq c = new StockReq(list);
            if (!stockReqs.contains(c)) {
              stockReqs.add(c);
            }
            if (counter % 250 == 0) {
              stockReqDAO.multiSaveOrUpdate(stockReqs);
              stockReqs = new ArrayList<>();
            }
          } else if (file.getName().matches(stockReq2FileName)) {
            StockReq2 c = new StockReq2(list);
            if (!stockReq2s.contains(c)) {
              stockReq2s.add(c);
            }
            if (counter % 250 == 0) {
              stockReq2DAO.multiSaveOrUpdate(stockReq2s);
              stockReq2s = new ArrayList<>();
            }
          } else if (file.getName().matches(usersFileName)) {
            User c = new User(list);
            if (!users.contains(c)) {
              users.add(c);
            }
            if (counter % 250 == 0) {
              userDAO.multiSaveOrUpdate(users);
              users = new ArrayList<>();
            }
          } else if (file.getName().matches(wmsOrderLineFileName)) {
            WMSOrderLine c = new WMSOrderLine(list);
            if (!wmsOrderLines.contains(c)) {
              wmsOrderLines.add(c);
            }
            if (counter % 250 == 0) {
              wmsOrderLineDAO.multiSaveOrUpdate(wmsOrderLines);
              wmsOrderLines = new ArrayList<>();
            }
          } else if (file.getName().matches(stockSpreadFileName)) {
            StockSpread c = new StockSpread(list);
            if (!stockSpreads.contains(c)) {
              stockSpreads.add(c);
            }
            if (counter % 250 == 0) {
              stockSpreadDAO.multiSaveOrUpdate(stockSpreads);
              stockSpreads = new ArrayList<>();
            }
          } else if (file.getName().matches(supplyFileName)) {
            Supply c = new Supply(list);
            if (!supplies.contains(c)) {
              supplies.add(c);
            }
            if (counter % 250 == 0) {
              supplyDAO.multiSaveOrUpdate(supplies);
              supplies = new ArrayList<>();
            }
          } else if (file.getName().matches(wcsAllocPriorityFileName)) {
            WCSAllocPriority c = new WCSAllocPriority(list);
            if (!wcsAllocPriorities.contains(c)) {
              wcsAllocPriorities.add(c);
            }
            if (counter % 250 == 0) {
              wcsAllocPriorityDAO.multiSaveOrUpdate(wcsAllocPriorities);
              wcsAllocPriorities = new ArrayList<>();
            }
          } else if (file.getName().matches(wcsAllocZoneWtFileName)) {
            WCSAllocZoneWT c = new WCSAllocZoneWT(list);
            if (!wcsAllocZoneWTS.contains(c)) {
              wcsAllocZoneWTS.add(c);
            }
            if (counter % 250 == 0) {
              wcsAllocZoneWTDAO.multiSaveOrUpdate(wcsAllocZoneWTS);
              wcsAllocZoneWTS = new ArrayList<>();
            }
          } else if (file.getName().matches(wmsOrderFileName)) {
            WMSOrder c = new WMSOrder(list);
            if (!wmsOrders.contains(c)) {
              wmsOrders.add(c);
            }
            if (counter % 250 == 0) {
              wmsOrderDAO.multiSaveOrUpdate(wmsOrders);
              wmsOrders = new ArrayList<>();
            }
          } else if (file.getName().matches(workstationFileName)) {
            WorkStation c = new WorkStation(list);
            if (!workStations.contains(c)) {
              workStations.add(c);
            }
            if (counter % 250 == 0) {
              workStationDAO.multiSaveOrUpdate(workStations);
              workStations = new ArrayList<>();
            }
          } else if (file.getName().matches(zonesFileName)) {
            Zone c = new Zone(list);
            if (!zones.contains(c)) {
              zones.add(c);
            }
            if (counter % 250 == 0) {
              zoneDAO.multiSaveOrUpdate(zones);
              zones = new ArrayList<>();
            }
          }

        } catch (Exception e) {
          logger.log("Error on file: " + file + ", count: " + counter + ", Exception: " + e.toString());
          logger.log("values failed: " + list);
          throw new Exception(e);
        }
      }
      //submit the last and reset collection
      if (!alarmsCollection.isEmpty()) {
        alarmsDAO.multiSaveOrUpdate(alarmsCollection);
        alarmsCollection = new ArrayList<>();
      }
      if (!containerSizes.isEmpty()) {
        containerSizeDAO.multiSaveOrUpdate(containerSizes);
        containerSizes = new ArrayList<>();
      }
      if (!types.isEmpty()) {
        containerTypeDAO.multiSaveOrUpdate(types);
        types = new ArrayList<>();
      }
      if (!containers.isEmpty()) {
        containerDAO.multiSaveOrUpdate(containers);
        containers = new ArrayList<>();
      }
      if (!customerLabels.isEmpty()) {
        customerLabelDAO.multiSaveOrUpdate(customerLabels);
        customerLabels = new ArrayList<>();
      }
      if (!emptyContainers.isEmpty()) {
        emptyContainerDAO.multiSaveOrUpdate(emptyContainers);
        emptyContainers = new ArrayList<>();
      }
      if (!items.isEmpty()) {
        itemDAO.multiSaveOrUpdate(items);
        items = new ArrayList<>();
      }
      if (!itemConfs.isEmpty()) {
        itemConfDAO.multiSaveOrUpdate(itemConfs);
        itemConfs = new ArrayList<>();
      }
      if (!itemExts.isEmpty()) {
        itemExtDAO.multiSaveOrUpdate(itemExts);
        itemExts = new ArrayList<>();
      }
      if (!lmgssccs.isEmpty()) {
        lmgssccdao.multiSaveOrUpdate(lmgssccs);
        lmgssccs = new ArrayList<>();
      }
      if (!locations.isEmpty()) {
        locationDAO.multiSaveOrUpdate(locations);
        locations = new ArrayList<>();
      }
      if (!mheErrors.isEmpty()) {
        mheErrorDAO.multiSaveOrUpdate(mheErrors);
        mheErrors = new ArrayList<>();
      }
      if (!mheErrorDescs.isEmpty()) {
        mheErrorDescDAO.multiSaveOrUpdate(mheErrorDescs);
        mheErrorDescs = new ArrayList<>();
      }
      if (!mheEvents.isEmpty()) {
        mheEventDAO.multiSaveOrUpdate(mheEvents);
        mheEvents = new ArrayList<>();
      }
      if (!mheInfos.isEmpty()) {
        mheInfoDAO.multiSaveOrUpdate(mheInfos);
        mheInfos = new ArrayList<>();
      }
      if (!movementsCollection.isEmpty()) {
        movementsDAO.multiSaveOrUpdate(movementsCollection);
        movementsCollection = new ArrayList<>();
      }
      if (!operatorEvents.isEmpty()) {
        operatorEventDAO.multiSaveOrUpdate(operatorEvents);
        operatorEvents = new ArrayList<>();
      }
      if (!paramsCollection.isEmpty()) {
        paramsDAO.multiSaveOrUpdate(paramsCollection);
        paramsCollection = new ArrayList<>();
      }
      if (!partnerAddresses.isEmpty()) {
        partnerAddressDAO.multiSaveOrUpdate(partnerAddresses);
        partnerAddresses = new ArrayList<>();
      }
      if (!partnerInfos.isEmpty()) {
        partnerInfoDAO.multiSaveOrUpdate(partnerInfos);
        partnerInfos = new ArrayList<>();
      }
      if (!moveJobDescs.isEmpty()) {
        moveJobDescDAO.multiSaveOrUpdate(moveJobDescs);
        moveJobDescs = new ArrayList<>();
      }
      if (!pickCategories.isEmpty()) {
        pickCategoryDAO.multiSaveOrUpdate(pickCategories);
        pickCategories = new ArrayList<>();
      }
      if (!pickReqs.isEmpty()) {
        pickReqDAO.multiSaveOrUpdate(pickReqs);
        pickReqs = new ArrayList<>();
      }
      if (!pmsDatas.isEmpty()) {
        pmsDataDAO.multiSaveOrUpdate(pmsDatas);
        pmsDatas = new ArrayList<>();
      }
      if (!pickCounts.isEmpty()) {
        pickCountDAO.multiSaveOrUpdate(pickCounts);
        pickCounts = new ArrayList<>();
      }
      if (!putAways.isEmpty()) {
        putAwayDAO.multiSaveOrUpdate(putAways);
        putAways = new ArrayList<>();
      }
      if (!replenQties.isEmpty()) {
        replenQtyDAO.multiSaveOrUpdate(replenQties);
        replenQties = new ArrayList<>();
      }
      if (!stocks.isEmpty()) {
        stockDAO.multiSaveOrUpdate(stocks);
        stocks = new ArrayList<>();
      }
      if (!stockHists.isEmpty()) {
        stockHistDAO.multiSaveOrUpdate(stockHists);
        stockHists = new ArrayList<>();
      }
      if (!stockAssemblies.isEmpty()) {
        stockAssemblyDAO.multiSaveOrUpdate(stockAssemblies);
        stockAssemblies = new ArrayList<>();
      }
      if (!stockReqs.isEmpty()) {
        stockReqDAO.multiSaveOrUpdate(stockReqs);
        stockReqs = new ArrayList<>();
      }
      if (!stockReq2s.isEmpty()) {
        stockReq2DAO.multiSaveOrUpdate(stockReq2s);
        stockReq2s = new ArrayList<>();
      }
      if (!users.isEmpty()) {
        userDAO.multiSaveOrUpdate(users);
        users = new ArrayList<>();
      }
      if (!wmsOrderLines.isEmpty()) {
        wmsOrderLineDAO.multiSaveOrUpdate(wmsOrderLines);
        wmsOrderLines = new ArrayList<>();
      }
      if (!stockSpreads.isEmpty()) {
        stockSpreadDAO.multiSaveOrUpdate(stockSpreads);
        stockSpreads = new ArrayList<>();
      }
      if (!supplies.isEmpty()) {
        supplyDAO.multiSaveOrUpdate(supplies);
        supplies = new ArrayList<>();
      }
      if (!wcsAllocPriorities.isEmpty()) {
        wcsAllocPriorityDAO.multiSaveOrUpdate(wcsAllocPriorities);
        wcsAllocPriorities = new ArrayList<>();
      }
      if (!wcsAllocZoneWTS.isEmpty()) {
        wcsAllocZoneWTDAO.multiSaveOrUpdate(wcsAllocZoneWTS);
        wcsAllocZoneWTS = new ArrayList<>();
      }
      if (!wmsOrders.isEmpty()) {
        wmsOrderDAO.multiSaveOrUpdate(wmsOrders);
        wmsOrders = new ArrayList<>();
      }
      if (!workStations.isEmpty()) {
        workStationDAO.multiSaveOrUpdate(workStations);
        workStations = new ArrayList<>();
      }
      if (!zones.isEmpty()) {
        zoneDAO.multiSaveOrUpdate(zones);
        zones = new ArrayList<>();
      }

      Long endTime = System.currentTimeMillis();
      //Logging
      Log log = new Log();
      log.setDescription("Data for file: " + file.getName());
      log.setPath(file.toString());
      log.setNumLines(new Long(counter));
      log.setRunTime((endTime - startTime));
      log.setRunDay(new Date());
      log.setFileName(file.getName());
      log.setSize(file.length());
      LogDAO logDAO = new LogDAO();
      logDAO.saveOrUpdate(log);
      logDAO.commit();
      folderSize += file.length();

      logger.log(file + " contains: " + counter + " lines");
      logger.log("Parse time for file: " + ((endTime - startTime)));
      logger.log("Avg. parse time: " + ((endTime.doubleValue() - startTime.doubleValue()) / counter.doubleValue()));
    }

    return fullCounter;
  }


  private static void addTree(String path, String fileNameMatch, Collection<File> all) {
    File file = new File(path);
    File[] children = file.listFiles();
    if (children != null) {
      for (File child : children) {
        if (!child.isDirectory() && child.getName().matches(fileNameMatch)) {
          logger.log("file added: " + child.getName());
          all.add(child);
        } else {
          addTree(child.getPath(), fileNameMatch, all);
        }
      }
    }
  }
}