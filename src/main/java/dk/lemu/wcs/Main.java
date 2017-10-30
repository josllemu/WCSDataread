package dk.lemu.wcs;

import dk.lemu.tools.dao.*;
import dk.lemu.tools.database.HibernateUtil;
import dk.lemu.tools.entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class Main {
  private final static String path = "C:\\Users\\josl\\Documents\\data\\2017-10-25\\";
  private static String contTypeFileName = "cont_type.dat.extract";
  private static String locationFileName = "location.dat.extract";
  private static String containerFileName = "container.dat.extract";
  private static String itemFileName = "item.dat.extract";
  private static String itemConfFileName = "item_conf.dat.extract";
  private static String stockFileName = "stock.dat.extract";
  private static String itemExtFileName = "item_ext.dat.extract";
  private static String pickCountFileName = "pick_count.dat.extract";

  public static void main(String[] args) throws Exception {

    HibernateUtil.initialize();

    Long start = System.currentTimeMillis();
    Integer fullRecords = 0;
    Integer records;

    Collection<File> files = new ArrayList<>();
 /*   addTree(path, contTypeFileName, files);
    records = fileHandler(files);
    fullRecords += records;
    System.out.println("Files: " + files.size() + ", records: " + records + ", Type: " + contTypeFileName);

    files = new ArrayList<>();
    addTree(path, locationFileName, files);
    records = fileHandler(files);
    fullRecords += records;
    System.out.println("Files: " + files.size() + ", records: " + records + ", Type: " + locationFileName);

    files = new ArrayList<>();
    addTree(path, containerFileName, files);
    records = fileHandler(files);
    fullRecords += records;
    System.out.println("Files: " + files.size() + ", records: " + records + ", Type: " + containerFileName);

    files = new ArrayList<>();
    addTree(path, itemFileName, files);
    records = fileHandler(files);
    fullRecords += records;
    System.out.println("Files: " + files.size() + ", records: " + records + ", Type: " + itemFileName);

    files = new ArrayList<>();
    addTree(path, itemConfFileName, files);
    records = fileHandler(files);
    fullRecords += records;
    System.out.println("Files: " + files.size() + ", records: " + records + ", Type: " + itemConfFileName);

    files = new ArrayList<>();
    addTree(path, stockFileName, files);
    records = fileHandler(files);
    fullRecords += records;
    System.out.println("Files: " + files.size() + ", records: " + records + ", Type: " + stockFileName);

    files = new ArrayList<>();
    addTree(path, itemExtFileName, files);
    records = fileHandler(files);
    fullRecords += records;
    System.out.println("Files: " + files.size() + ", records: " + records + ", Type: " + itemExtFileName);

    files = new ArrayList<>();
    addTree(path, pickCountFileName, files);
    records = fileHandler(files);
    fullRecords += records;
    System.out.println("Files: " + files.size() + ", records: " + records + ", Type: " + pickCountFileName);
*/
    Long end = System.currentTimeMillis();
    System.out.println("Total records handled: " + fullRecords);
    System.out.println("Parse time for file: " + ((end - start)));
    System.out.println("Avg. parse time: " + ((end.doubleValue() - start.doubleValue()) / fullRecords.doubleValue()));

    System.exit(0);
  }

  private static Integer fileHandler(Collection<File> files) throws Exception {
    LocationDAO locationDAO = new LocationDAO();
    ContainerTypeDAO containerTypeDAO = new ContainerTypeDAO();
    ContainerDAO containerDAO = new ContainerDAO();
    ItemDAO itemDAO = new ItemDAO();
    ItemConfDAO itemConfDAO = new ItemConfDAO();
    StockDAO stockDAO = new StockDAO();
    ItemExtDAO itemExtDAO  = new ItemExtDAO();
    PickCountDAO pickCountDAO = new PickCountDAO();

    ContainerType containerType = new ContainerType();
    containerType.setContainerTypeCode("ORDER");
    containerType.setDescription("Modtagelse");
    containerTypeDAO.saveOrUpdate(containerType);
    containerTypeDAO.commit();


    Integer fullCounter = 0;
    for (File file : files) {

      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Windows-1252"), 1024 * 8192);
      String line = null;
      Integer counter = 0;
      Long startTime = System.currentTimeMillis();
      //could be an easier way to do this
      Collection<Location> locations = new ArrayList<>();
      Collection<ContainerType> types = new ArrayList<>();
      Collection<Container> containers = new ArrayList<>();
      Collection<Item> items = new ArrayList<>();
      Collection<ItemConf> itemConfs = new ArrayList<>();
      Collection<Stock> stocks = new ArrayList<>();
      Collection<ItemExt> itemExts = new ArrayList<>();
      Collection<PickCount> pickCounts = new ArrayList<>();
      while ((line = br.readLine()) != null) {
        fullCounter++;
        counter++;
        String[] test = line.split("~");
        List<String> list = Arrays.asList(test);

        for (int i = 0; list.size() > i; i++) {
          list.set(i, list.get(i).trim());
        }

        //@TODO refactor
        if (counter % 500 == 0) {
          System.out.println("number: " + counter + ", time running: " + ((System.currentTimeMillis() - startTime) / 1000L));
          //System.out.println("number: " + counter + ": List: " + list);

        }

        try {
          if (file.getName().matches(contTypeFileName)) {
            ContainerType type = new ContainerType(list);
            if (!types.contains(type)) {
              types.add(type);
            }
            if (counter % 20 == 0) {
              containerTypeDAO.multiSaveOrUpdate(types);
              types = new ArrayList<>();
            }
          } else if (file.getName().matches(locationFileName)) {
            Location location = new Location(list);
            if (!locations.contains(location)) {
              locations.add(location);
            }
            if (counter % 1000 == 0) {
              locationDAO.multiSaveOrUpdate(locations);
              locations = new ArrayList<>();
            }
          } else if (file.getName().matches(containerFileName)) {
            Container container = new Container(list);
            if (!containers.contains(container)) {
              containers.add(container);
            }
            if (counter % 500 == 0) {
              containerDAO.multiSaveOrUpdate(containers);
              containers = new ArrayList<>();
            }
          } else if (file.getName().matches(itemFileName)) {
            Item item = new Item(list);
            if (!items.contains(item)) {
              items.add(item);
            }
            if (counter % 1000 == 0) {
              itemDAO.multiSaveOrUpdate(items);
              items = new ArrayList<>();
            }
          } else if (file.getName().matches(itemConfFileName)) {
            ItemConf itemConf = new ItemConf(list);
            if (!itemConfs.contains(itemConf)) {
              itemConfs.add(itemConf);
            }
            if (counter % 500 == 0) {
              itemConfDAO.multiSaveOrUpdate(itemConfs);
              itemConfs = new ArrayList<>();
            }
          } else if (file.getName().matches(stockFileName)) {
            Stock stock = new Stock(list);
            if (!stocks.contains(stock)) {
              stocks.add(stock);
            }
            if (counter % 500 == 0) {
              stockDAO.multiSaveOrUpdate(stocks);
              stocks = new ArrayList<>();
            }
          } else if (file.getName().matches(itemExtFileName)) {
            ItemExt itemExt = new ItemExt(list);
            if (!itemExts.contains(itemExt)) {
              itemExts.add(itemExt);
            }
            if (counter % 500 == 0) {
              itemExtDAO.multiSaveOrUpdate(itemExts);
              itemExts = new ArrayList<>();
            }
          } else if (file.getName().matches(pickCountFileName)) {
            PickCount pickCount = new PickCount(list);
            if (!pickCounts.contains(pickCount)) {
              pickCounts.add(pickCount);
            }
            if (counter % 500 == 0) {
              pickCountDAO.multiSaveOrUpdate(pickCounts);
              pickCounts = new ArrayList<>();
            }
          }
        } catch (Exception e) {
          System.out.println("Error on file: " + file + ", count: "+ counter + ", Exception: " + e.toString());
          System.out.println("values failed: " + list);
          throw new Exception(e);
        }
      }
      //submit the last and reset collection
      if (!locations.isEmpty()) {
        locationDAO.multiSaveOrUpdate(locations);
        locations = new ArrayList<>();
      }
      if (!types.isEmpty()) {
        containerTypeDAO.multiSaveOrUpdate(types);
        types = new ArrayList<>();
      }
      if (!containers.isEmpty()) {
        containerDAO.multiSaveOrUpdate(containers);
        containers = new ArrayList<>();
      }
      if (!items.isEmpty()) {
        itemDAO.multiSaveOrUpdate(items);
        items = new ArrayList<>();
      }
      if (!itemConfs.isEmpty()) {
        itemConfDAO.multiSaveOrUpdate(itemConfs);
        itemConfs = new ArrayList<>();
      }
      if (!stocks.isEmpty()) {
        stockDAO.multiSaveOrUpdate(stocks);
        stocks = new ArrayList<>();
      }
      if (!itemExts.isEmpty()) {
        itemExtDAO.multiSaveOrUpdate(itemExts);
        itemExts = new ArrayList<>();
      }
      if (!pickCounts.isEmpty()) {
        pickCountDAO.multiSaveOrUpdate(pickCounts);
        pickCounts = new ArrayList<>();
      }

      Long endTime = System.currentTimeMillis();
      System.out.println(file + " contains: " + counter + " lines");
      System.out.println("Parse time for file: " + ((endTime - startTime)));
      System.out.println("Avg. parse time: " + ((endTime.doubleValue() - startTime.doubleValue()) / counter.doubleValue()));
    }

    return fullCounter;
  }


  private static void addTree(String path, String fileNameMatch, Collection<File> all) {
    File file = new File(path);
    File[] children = file.listFiles();
    if (children != null) {
      for (File child : children) {
        if (!child.isDirectory() && child.getName().matches(fileNameMatch)) {
          System.out.println("file added: " + child.getName());
          all.add(child);
        }else {
          addTree(child.getPath(), fileNameMatch, all);
        }
      }
    }
  }
}