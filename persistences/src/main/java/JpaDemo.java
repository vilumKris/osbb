import dao.impl.EventDAOImpl;
import dao.impl.OsbbDAOImpl;
import model.EventEntity;
import model.OsbbEntity;
import util.EntityUtil;

/**
 * Created by Aska on 01.07.2016.
 */
public class JpaDemo {
    public static void main(String[] args) {

        /*StaffDAOImpl staffDAO = new StaffDAOImpl();
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setIdStaff(13);
        staffDAO.save(staffEntity);
        System.out.println("saved staff id"+ staffEntity.getIdStaff());*/

        /*OsbbEntity osbbEntity = new OsbbEntity();
        osbbEntity.setName("osbb_1");
        osbbEntity.setIdCreator((byte)3);
        osbbEntity.setDescription("osbb in Lviv");

        OsbbDAOImpl osbbImpl = new OsbbDAOImpl();
        osbbImpl.save(osbbEntity);*/

        EventEntity eventEntity = new EventEntity();
        eventEntity.setName("Raise money for funeral");
        eventEntity.setAuthor("The head of OSBB");
        eventEntity.setDescription("The grandmother Zina's cat has dead.");
        EventDAOImpl eventDAO = new EventDAOImpl();
        eventDAO.save(eventEntity);
//        eventDAO.findOne(1);
//        eventDAO.findAll();
        eventDAO.exists(0);

        EntityUtil.closeEntityManagerFactory();

    }

}
