package dk.lemu.tools.database;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

  private static final SessionFactory sessionFactory;

  static {
    try {
      Configuration configuration = new Configuration();
      configuration.configure("hibernate.cfg.xml");
      EntityScanner.scanPackages("dk.lemu.tools.entity").addTo(configuration);

      new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

      System.out.println(EntityScanner.scanPackages("dk.lemu.tools.entity").result());

      sessionFactory = configuration.buildSessionFactory();
    } catch (Throwable ex) {
      // Log exception!
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static void initialize() {
  }

  private static final ThreadLocal session = new ThreadLocal();

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