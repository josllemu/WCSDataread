package dk.lemu.wcs;

import dk.lemu.tools.dao.ConfigDAO;
import dk.lemu.tools.database.HibernateUtil;
import dk.lemu.tools.entity.Config;
import dk.lemu.tools.logging.Logging;

import java.util.logging.Logger;

public class Setup {
  private static Logging logger;

  public static void main(String[] args) throws Exception {
    System.setProperty("java.util.logging.SimpleFormatter.format",
        "%1$tF %1$tT %4$s %5$s%6$s%n");
    if (args.length >= 2) {
      HibernateUtil.initialize(args);
      logger = new Logging();
    } else {
      Logger.getLogger("WCS").severe("Missing arguments for setting up database and connection.");
      for (int i = 0; args.length < i; i++) {
        Logger.getLogger("WCS").severe("argument " + i + " " + args[i]);
      }
      throw new Exception("Missing arguments for setting up database and connection.");
    }






    ConfigDAO configDAO = new ConfigDAO();
    Config config = configDAO.findByConfiguration("Singleton");

    logger.log("Configuration: " + config);
    System.exit(0);
  }
}
