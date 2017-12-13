package dk.lemu.wcs;

import dk.lemu.tools.dao.ConfigDAO;
import dk.lemu.tools.database.HibernateUtil;
import dk.lemu.tools.entity.Config;
import dk.lemu.tools.logging.Logging;

public class test {



  private static Logging logger;

  public static void main(String[] args) throws Exception {
    System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %5$s%6$s%n");


    HibernateUtil.initialize(null);
    logger = new Logging();
    ConfigDAO configDAO = new ConfigDAO();
    Config config = configDAO.findByConfiguration("Singleton");

    logger.log("Database connection successful");
    logger.log("Config:  " + config);
    logger.log("Config set up correctly");
    logger.log("Everything is set to go!");


    System.exit(0);
  }


}
