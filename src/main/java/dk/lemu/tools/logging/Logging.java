package dk.lemu.tools.logging;

import dk.lemu.tools.dao.ConfigDAO;
import dk.lemu.tools.dao.LogDAO;
import dk.lemu.tools.entity.Config;
import dk.lemu.tools.entity.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class Logging {
  private Logger logger;
  private String pathSep = System.getProperty("file.separator");

  public Logging() {

    logger = Logger.getLogger("WCS");
    if (logger.getHandlers().length == 0) {
      configure();
    }

  }

  private void configure() {

    try {
      ConfigDAO configDAO = new ConfigDAO();
      Config config = configDAO.findByConfiguration("Singleton");
      String logsDirectoryFolder = config.getLogPath();

      Files.createDirectories(Paths.get(logsDirectoryFolder));
      FileHandler fileHandler = new FileHandler(logsDirectoryFolder + File.separator + "WCS-Log." + getCurrentTimeString() + ".log");
      logger.addHandler(fileHandler);
      SimpleFormatter formatter = new SimpleFormatter();
      fileHandler.setFormatter(formatter);
      initializedMessage(config);
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    addCloseHandlersShutdownHook();

  }

  private void initializedMessage(Config config) {
    LogDAO logDAO = new LogDAO();

    Log log = logDAO.findByPath(config.getPath() + pathSep + config.getFolder() + pathSep);

    log("------------------------------");
    log("Logger initialized");
    log("Scheduled script started: " + getCurrentTimeString());
    log("Path: " + config.getPath());
    log("Start folder: " + config.getFolder());
    if (log != null) {
      log("Last run took: " + (log.getRunTime() / 1000L));
      log("Num linies on last run: " + log.getNumLines());
    }
    log("------------------------------");

  }

  private void addCloseHandlersShutdownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread(() ->
    {
      // Close all handlers to get rid of empty .LCK files
      for (Handler handler : logger.getHandlers()) {
        handler.close();
      }
    }));
  }

  private String getCurrentTimeString() {
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
    return dateFormat.format(new Date());
  }

  public void log(Exception exception) {
    logger.log(Level.SEVERE, "script failed with the exception message: " + exception.getMessage(), exception);
  }

  public void log(String message) {
    logger.log(Level.INFO, message);
  }

  public void log(Integer message) {
    logger.log(Level.INFO, "Int value: " + message);
  }
}
