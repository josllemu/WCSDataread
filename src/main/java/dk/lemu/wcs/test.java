package dk.lemu.wcs;

import dk.lemu.tools.dao.SuperSearchKolDAO;
import dk.lemu.tools.database.HibernateUtil;
import dk.lemu.tools.logging.Logging;

public class test {



  private static Logging logger;

  public static void main(String[] args) throws Exception {
    System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %5$s%6$s%n");

    HibernateUtil.initialize(args);
    logger = new Logging();
    SuperSearchKolDAO superSearchKolDAO = new SuperSearchKolDAO();

    /*Collection<SuperSearchKol> col  = superSearchKolDAO.getAll();

    for (SuperSearchKol s : col) {
      System.out.println(s);
    }*/


    Integer kol1 = superSearchKolDAO.makePost();

    logger.log("Amount of posts: " + kol1);


    System.exit(0);
  }


}
