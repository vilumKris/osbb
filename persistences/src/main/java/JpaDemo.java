import dao.impl.StaffDAOImpl;
import model.StaffEntity;

/**
 * Created by Aska on 01.07.2016.
 */
public class JpaDemo {
    public static void main(String[] args) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        //EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();

        StaffDAOImpl staffDAO = new StaffDAOImpl();
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setIdStaff(10);
        staffDAO.save(staffEntity);
        System.out.println("saved staff id"+ staffEntity.getIdStaff());

    }

}
