package dk.lemu.wcs;

import dk.lemu.tools.dao.SuperSearchKolDAO;
import dk.lemu.tools.database.HibernateUtil;
import dk.lemu.tools.logging.Logging;

public class SuperSearchFill {

  private static Logging logger;

  public static void main(String[] args) {
    System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %5$s%6$s%n");


    try {
      HibernateUtil.initialize(null);
      logger = new Logging();
      SuperSearchKolDAO superSearchKolDAO = new SuperSearchKolDAO();

      Integer kol1 = superSearchKolDAO.makePost();

      logger.log("Amount of posts: " + kol1);



    } catch (Exception e) {
      logger.log(e);
    } finally {
      logger.log("------------------------------");
      logger.log("Run finished");
      logger.log("------------------------------");
      System.exit(0);
    }
  }

}
