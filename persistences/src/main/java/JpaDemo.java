import dao.EntityUtil;
import dao.impl.StaffDAOImpl;
import model.StaffEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Aska on 01.07.2016.
 */
public class JpaDemo {
    public static void main(String[] args) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        //EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();

        EntityUtil.getEntityFactoryInstance();

        StaffDAOImpl staffDAO = new StaffDAOImpl();
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setIdStaff(10);
        staffDAO.save(staffEntity);
        System.out.println(staffDAO.findAll());

    }

}
