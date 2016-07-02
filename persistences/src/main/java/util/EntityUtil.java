package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Aska on 01.07.2016.
 */
public class EntityUtil {
    private static EntityManagerFactory emf;


    public static EntityManagerFactory getEntityFactoryInstance() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("persistenceUnit");
        }
        return emf;
    }

    public static EntityManagerFactory getEntityFactoryInstance(String persistenceUnitVal) {
        if (emf == null) {
            System.out.println("calling out driver");
            emf = Persistence.createEntityManagerFactory(persistenceUnitVal);
        }
        return emf;
    }

    public static EntityManager getEntityManager() {
        return getEntityFactoryInstance().createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        getEntityFactoryInstance().close();
    }

    public static void closeEntityManager(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
