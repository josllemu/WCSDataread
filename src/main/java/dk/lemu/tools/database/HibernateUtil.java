package dk.lemu.tools.database;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import dk.lemu.tools.dao.ConfigDAO;
import dk.lemu.tools.entity.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class HibernateUtil {

  private static final SessionFactory sessionFactory;
  private static final ThreadLocal session = new ThreadLocal();

  static {
    System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %5$s%6$s%n");

    try {
      Configuration configuration = new Configuration();
      configuration.configure("hibernate.cfg.xml");
      EntityScanner.scanPackages("dk.lemu.tools.entity").addTo(configuration);

      new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

      sessionFactory = configuration.buildSessionFactory();
    } catch (Throwable ex) {
      Logger.getLogger("WCS").severe(ex.getMessage());
      // Log exception!
      throw new ExceptionInInitializerError(ex);
    }

  }

  public static void initialize(String[] args) {
    Logger.getLogger("WCS").info("Data base connection initialized");
    String pathSep = System.getProperty("file.separator");
    try {
      ConfigDAO configDAO = new ConfigDAO();
      Config config = configDAO.findByConfiguration("Singleton");

      if (args != null && args.length <= 2 && config == null) {
        config = new Config();

        config.setPath(args[0]);
        config.setFolder(args[1]);
        String logPath = args.length == 3 ? args[2] : System.getProperty("user.home") + pathSep +"temp"+ pathSep +"log" + pathSep;
        config.setLogPath(logPath);
        config.setRestartPoint(null);
        configDAO.saveOrUpdate(config);
        configDAO.commit();
      }
    } catch (Exception e) {

      Logger.getLogger("WCS").severe(e.getMessage());
      // Log exception!
      throw new ExceptionInInitializerError(e);
    }
  }

  public static Session currentSession() throws HibernateException {
    if (session != null) {
      Session s = (Session) session.get();
      // Open a new Session, if this thread has none yet
      if (s == null) {
        s = sessionFactory.openSession();
        // Store it in the ThreadLocal variable
        session.set(s);
      }
      return s;
    } else {
      return null;
    }
  }

  public static void closeSession() throws HibernateException {
    Session s = (Session) session.get();
    if (s != null)
      s.close();
    session.set(null);
  }
}