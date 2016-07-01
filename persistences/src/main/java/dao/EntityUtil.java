package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Aska on 01.07.2016.
 */
public class EntityUtil {
    private static EntityManagerFactory emf;

    static{
        emf = Persistence.createEntityManagerFactory("digibank-mysql");
    }

    public static EntityManagerFactory getEntityFactoryInstance(){
        if (emf==null) {
            emf = Persistence.createEntityManagerFactory("persistenceUnit");
        }
            return emf;
    }

    public static EntityManager getEntityManager(){
        return getEntityFactoryInstance().createEntityManager();
    }
}
